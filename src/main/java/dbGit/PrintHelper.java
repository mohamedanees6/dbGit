package dbGit;

public class PrintHelper {

  public static void printHelpMessageToScreen(DbGitCommand command) {
    if (command == DbGitCommand.INIT) {
      printInitBranchHelpCommands();
    } if(command == DbGitCommand.DROP){
      printDropBranchHelpCommands();
    }else {
      System.out.println("DbGit Usage Commands\n\n=====================================\n");
      System.out.println("Get Init branch help: \n dbgit init -h");
      printInitBranchHelpCommands();
    }
  }

  private static void printDropBranchHelpCommands() {
    System.out.println("INIT:\n dbgit drop <db_name> <db_user_name> <db_password> <branch_name>");
    System.out.println("Example");
    System.out.println("dbgit drop mytestdb postgres mypass123 mybranch");
  }

  private static void printInitBranchHelpCommands() {
    System.out.println("INIT:\n dbgit init <db_name> <db_user_name> <db_password> <branch_name>");
    System.out.println("Example");
    System.out.println("dbgit init mytestdb postgres mypass123 mybranch");
  }

  
}
