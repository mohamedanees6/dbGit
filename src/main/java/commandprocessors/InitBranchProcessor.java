package commandprocessors;

public class InitBranchProcessor extends AbstractCommandProcessor {

  private static String CREATE_DUMP_FILE = "pg_dump ";


  @Override
  public void process(String branchName) throws Exception {
    String dbName = this.connectionParams.getDbName();
    this.statement.executeQuery(
        CREATE_DUMP_FILE + dbName + " > " + "dbgit_" + dbName + "_" + branchName);
  }

}
