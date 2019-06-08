package dbGit;

public class DbGitCommands {

  private static String INIT = "init";
  

  public static DbGitCommand getCommandFromInputString(String inputString) {
    DbGitCommand command = null;
    if (INIT.equalsIgnoreCase(inputString)) {
      command = DbGitCommand.INIT;
    } else {
      command = DbGitCommand.HELP;
    }
    return command;
  }

}
