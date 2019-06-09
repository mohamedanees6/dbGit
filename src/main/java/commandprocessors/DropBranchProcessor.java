package commandprocessors;

import java.io.File;

public class DropBranchProcessor extends AbstractCommandProcessor {

  @Override
  public void process(String branchName) throws Exception {

    String command =
        "rm dbgit_" + this.connectionParams.getDbName() + "_" + branchName + ".sql";
    Process process = RuntimeExecHelper.execRuntimeCommand(command);
    if (process.exitValue() != 0) {
      System.out.println("Unable to drop branch " + branchName + " to database "
          + this.connectionParams.getDbName());
    } else {
      System.out.println("Dropped branch " + branchName);
    }

  }

}
