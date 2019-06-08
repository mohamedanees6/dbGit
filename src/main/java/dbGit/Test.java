package dbGit;

import java.sql.Connection;

import commandprocessors.AbstractCommandProcessor;

public class Test {

  /**
   * The main method.
   *
   * @param args the arguments
   * @throws Exception the exception
   */
  public static void main(String args[]) {
    try {
      if (args == null || args.length < 1) {
        PrintHelper.printHelpMessageToScreen(DbGitCommand.HELP);
      }
      DbGitCommand command = DbGitCommand.getDbGitCommand(args[0]);
      AbstractCommandProcessor commandProcessor =
          AbstractCommandProcessor.getCommandProcessor(command);
      commandProcessor.process(args);
    } catch (Exception e) {
      e.printStackTrace();
      System.out.println("Exception " + e.getMessage());
    }
  }
}

