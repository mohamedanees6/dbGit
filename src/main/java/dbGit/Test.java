package dbGit;

import java.sql.Connection;

public class Test {

  /**
   * The main method.
   *
   * @param args the arguments
   * @throws Exception the exception
   */
  public static void main(String args[]) {
    try {
      Connection c = PgConnectionUtility.getConnection();
      if (args == null || args.length < 1) {
        PrintHelper.printHelpMessageToScreen(DbGitCommand.HELP);
      }
      DbGitCommand command = DbGitCommands.getCommandFromInputString(args[0]);
      processCommand(command);
    } catch (Exception e) {
      e.printStackTrace();
      System.out.println("Exception " + e.getMessage());
    }
  }

  private static void processCommand(DbGitCommand command) {

  }
}

