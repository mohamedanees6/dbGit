package commandprocessors;

import dbGit.ConnectionParams;
import dbGit.DbGitCommand;
import dbGit.PrintHelper;

public class HelpProcessor extends AbstractCommandProcessor {
  @Override
  public void process(String branchName) throws Exception {
    PrintHelper.printHelpMessageToScreen(DbGitCommand.HELP);
  }


}
