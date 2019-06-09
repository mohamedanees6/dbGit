package commandprocessors;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class InitBranchProcessor extends AbstractCommandProcessor {

  private static String CREATE_DUMP_FILE = "pg_dump ";


  @Override
  public void process(String branchName) throws Exception {
    String dbName = this.connectionParams.getDbName();
    String command = "pg_dump" + dbName + " -f dbgit_" + dbName + "_" + branchName + ".sql";
    Process exec = Runtime.getRuntime().exec(command);

    try (InputStream is = exec.getErrorStream();
        InputStreamReader isr = new InputStreamReader(is);
        BufferedReader br = new BufferedReader(isr)) {
      String line;
      while ((line = br.readLine()) != null) {
        System.out.println(line);
      }
    } catch (Exception exception) {
      exception.printStackTrace();
    }
    exec.waitFor();
    if (exec.exitValue() != 0) {
      throw new Exception(
          "Please check the branch name is not existing before or ensure pg_dump is available in path");
    } else {
      System.out.println("Created");
    }
  }
}
