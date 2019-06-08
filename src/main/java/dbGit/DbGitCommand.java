package dbGit;

public enum DbGitCommand {
  INIT, HELP, DROP, CHECKOUT, VIEW;

  public static DbGitCommand getDbGitCommand(String inputCommand) {
    for (DbGitCommand command : DbGitCommand.values()) {
      if (inputCommand.equalsIgnoreCase(command.toString())) {
        return command;
      }
    }
    return HELP;
  }
}
