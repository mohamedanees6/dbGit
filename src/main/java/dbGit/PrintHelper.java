package dbGit;

public class PrintHelper {

  public static void printHelpMessageToScreen(DbGitCommand command) {
    if (command == DbGitCommand.INIT) {
      printInitHelpCommands();
    } else {
      System.out.println("DbGit Usage Commands\n\n=====================================\n");
      System.out.println("Get Init help: \n dbgit init -h");
      printInitHelpCommands();
    }
  }

  private static void printInitHelpCommands() {
    System.out.println("INIT:\n dbgit init <db_name> <db_user_name> <db_password> <branch_name>");
    System.out.println("Example");
    System.out.println("dbgit init mytestdb postgres mypass123 mybranch");
  }

}
