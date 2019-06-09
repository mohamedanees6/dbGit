package commandprocessors;

public class InitBranchProcessor extends AbstractCommandProcessor {

  @Override
  public void process(String branchName) throws Exception {
    String dbName = this.connectionParams.getDbName();
    String command = "pg_dump " + dbName + " -f dbgit_" + dbName + "_" + branchName + ".sql";
    Process exec = RuntimeExecHelper.execRuntimeCommand(command);
    if (exec.exitValue() != 0) {
      throw new Exception(
          "Please check the branch name is not existing before or ensure pg_dump is available in path");
    } else {
      System.out.println("Created branch " + branchName + " for Database " + dbName);
    }
  }
}
