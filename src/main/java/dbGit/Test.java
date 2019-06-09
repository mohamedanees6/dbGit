package dbGit;

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
        System.exit(1);
      }
      DbGitCommand command = DbGitCommand.getDbGitCommand(args[0]);
      AbstractCommandProcessor commandProcessor =
          AbstractCommandProcessor.getCommandProcessor(command);
      String branchName = null;
      if (command != DbGitCommand.HELP) {
        if (command != DbGitCommand.VIEW) {
          branchName = args[5];
        }
        commandProcessor.execute(ConnectionParams.getConnectionParams(args), branchName);
      } else {
        commandProcessor.process(null);
      }
    } catch (Exception e) {
      e.printStackTrace();
      System.out.println("Exception " + e.getMessage());
    }
  }
}

