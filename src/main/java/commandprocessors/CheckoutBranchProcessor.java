package commandprocessors;

import java.io.File;

import dbGit.ConnectionParams;

public class CheckoutBranchProcessor extends AbstractCommandProcessor {

  @Override
  public void preProcess(ConnectionParams connectionParam) throws Exception {
    this.connectionParams = connectionParam;
  };

  @Override
  public void postProcess(java.sql.Connection c, java.sql.Statement statement)
      throws java.sql.SQLException {};

  @Override
  public void process(String branchName) throws Exception {
    if (isBackupBranchAvailable(branchName)) {
      Process dropProcess =
          RuntimeExecHelper.execRuntimeCommand("dropdb " + this.connectionParams.getDbName());
      if (dropProcess.exitValue() != 0) {
        System.out.println("Unable to drop existing db from database. Process exited with "
            + dropProcess.exitValue());
        return;
      }
      System.out.println("Checkout to Branch " + branchName + " is processing");
      createDB();
      checkoutToBranch(branchName);
    } else {
      System.out.println("Non existing branch for DB " + this.connectionParams.getDbName()
          + " Branch:" + branchName);
    }
  }

  private void createDB() throws Exception {
    String command = "createdb --owner=postgres " + this.connectionParams.getDbName();
    Process pr = RuntimeExecHelper.execRuntimeCommand(command);
    if (pr.exitValue() != 0) {
      throw new RuntimeException(
          "Unable to create database " + this.connectionParams.getDbName());
    } else {
      System.out.println("Successfully Created DB " + this.connectionParams.getDbName());
    }
  }

  private void checkoutToBranch(String branchName) throws Exception {
    String[] command = {"psql", "-U", "postgres", "-d", this.connectionParams.getDbName(),
        "-f", "dbgit_" + this.connectionParams.getDbName() + "_" + branchName + ".sql",};
    Process process = RuntimeExecHelper.execWithProcessBuilder(command);
    checkForSuccess(branchName, process);
  }

  private void checkForSuccess(String branchName, Process process) {
    if (process.exitValue() != 0) {
      throw new RuntimeException("Unable to checkout to branch name " + branchName);
    } else {
      System.out.println("Checkout to branch " + branchName + " is successful");
    }
  }

  private boolean isBackupBranchAvailable(String branchName) {
    boolean isBackUpBranchAvailable = false;
    for (File file : new File(".").listFiles()) {
      String fileName = file.getName();
      if (fileName.contains("dbgit_" + this.connectionParams.getDbName() + "_" + branchName)) {
        isBackUpBranchAvailable = true;
        break;
      }
    }
    return isBackUpBranchAvailable;
  }


}
