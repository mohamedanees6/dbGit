package dbGit;

public class PrintHelper {

  public static void printHelpMessageToScreen(DbGitCommand command) {
    switch (command) {
      case INIT:
        printInitBranchHelpCommands();
        break;
      case DROP:
        printDropBranchHelpCommands();
        break;
      case CHECKOUT:
        printCheckoutBranchHelpCommands();
        break;
      case VIEW:
        printViewBranchesHelpCommands();
        break;
      case HELP:
      default:
        System.out.println("DbGit Usage Commands\n\n=====================================\n");
        printInitBranchHelpCommands();
        printDropBranchHelpCommands();
        printCheckoutBranchHelpCommands();
        printViewBranchesHelpCommands();
        break;
    }
  }

  private static void printViewBranchesHelpCommands() {
    System.out.println("\n View all available branches to a database\n");
    System.out.println("\nVIEW:\n dbgit view <db_name> <db_user_name> <db_password>");
    System.out.println("Example\n");
    System.out.println("dbgit view mytestdb postgres mypass123");
  }

  private static void printCheckoutBranchHelpCommands() {
    System.out.println("\n Checkout to available branch to a database\n");
    System.out.println(
        "\nCHECKOUT:\n dbgit checkout <db_name> <db_user_name> <db_password> <branch_name>");
    System.out.println("Example\n");
    System.out.println("dbgit checkout mytestdb postgres mypass123 mybranch");
  }

  private static void printDropBranchHelpCommands() {
    System.out.println("\n Drop available branch to a database \n");
    System.out
        .println("\nDROP:\n dbgit drop <db_name> <db_user_name> <db_password> <branch_name>");
    System.out.println("Example\n");
    System.out.println("dbgit drop mytestdb postgres mypass123 mybranch");
  }

  private static void printInitBranchHelpCommands() {
    System.out.println("\n Create a branch to a database \n");
    System.out
        .println("\nINIT:\n dbgit init <db_name> <db_user_name> <db_password> <branch_name>");
    System.out.println("Example\n");
    System.out.println("dbgit init mytestdb postgres mypass123 mybranch");
  }


}
