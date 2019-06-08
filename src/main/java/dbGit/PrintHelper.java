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
    System.out
        .println("\nVIEW:\n dbgit view <address:port> <db_name> <db_user_name> <db_password>");
    System.out.println("Example\n");
    System.out.println("dbgit view localhost:5432 mytestdb postgres mypass123");
    System.out.println("Please enter **null** for empty fields");
  }

  private static void printCheckoutBranchHelpCommands() {
    System.out.println("\n Checkout to available branch to a database\n");
    System.out.println(
        "\nCHECKOUT:\n dbgit checkout <address:port> <db_name> <db_user_name> <db_password> <branch_name>");
    System.out.println("Example\n");
    System.out.println("dbgit checkout localhost:5432 mytestdb postgres mypass123 mybranch");
    System.out.println("Please enter **null** for empty fields");
  }

  private static void printDropBranchHelpCommands() {
    System.out.println("\n Drop available branch to a database \n");
    System.out.println(
        "\nDROP:\n dbgit drop <address:port> <db_name> <db_user_name> <db_password> <branch_name>");
    System.out.println("Example\n");
    System.out.println("dbgit drop localhost:5432 mytestdb postgres mypass123 mybranch");
    System.out.println("Please enter **null** for empty fields");
  }

  private static void printInitBranchHelpCommands() {
    System.out.println("\n Create a branch to a database \n");
    System.out.println(
        "\nINIT:\n dbgit init <address:port> <db_name> <db_user_name> <db_password> <branch_name>");
    System.out.println("Example\n");
    System.out.println("dbgit init localhost:5432 mytestdb postgres mypass123 mybranch");
    System.out.println("Please enter **null** for empty fields");
  }


}
