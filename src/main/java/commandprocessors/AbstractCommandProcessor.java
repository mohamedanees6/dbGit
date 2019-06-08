package commandprocessors;

import dbGit.DbGitCommand;

public abstract class AbstractCommandProcessor {
  protected String[] args;

  public abstract void process(String[] args) throws Exception;

  public static AbstractCommandProcessor getCommandProcessor(DbGitCommand inputCommand) {
    AbstractCommandProcessor commandProcessor = null;
    switch (inputCommand) {
      case INIT:
        commandProcessor = new InitBranchProcessor();
        break;
      case DROP:
        commandProcessor = new DropBranchProcessor();
        break;
      case CHECKOUT:
        commandProcessor = new CheckoutBranchProcessor();
        break;
      case VIEW:
        commandProcessor = new ViewBranchProcessor();
        break;
      case HELP:
      default:
        commandProcessor = new HelpProcessor();
        break;
    }
    return commandProcessor;
  }
}
