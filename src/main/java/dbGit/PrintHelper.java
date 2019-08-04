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
        System.out.println("=====================================\n");
        printDropBranchHelpCommands();
        System.out.println("=====================================\n");
        printCheckoutBranchHelpCommands();
        System.out.println("=====================================\n");
        printViewBranchesHelpCommands();
        System.out.println("=====================================\n");
        break;
    }
  }

  private static void printViewBranchesHelpCommands() {
    System.out.println("\n View all available branches to a database\n");
    System.out
        .println("\nVIEW:\n dbgit view");
    System.out.println("Example\n");
    System.out.println("dbgit view");
  }

  private static void printCheckoutBranchHelpCommands() {
    System.out.println("\n Checkout to available branch to a database\n");
    System.out.println(
        "\nCHECKOUT:\n dbgit checkout <branch_name>");
    System.out.println("Example\n");
    System.out.println("dbgit checkout mybranch");
  }

  private static void printDropBranchHelpCommands() {
    System.out.println("\n Drop available branch to a database \n");
    System.out.println(
        "\nDROP:\n dbgit drop <branch_name>");
    System.out.println("Example\n");
    System.out.println("dbgit drop mybranch");
  }

  private static void printInitBranchHelpCommands() {
    System.out.println("\n Create a branch to a database \n");
    System.out.println(
        "\nINIT:\n dbgit init <branch_name>");
    System.out.println("Example\n");
    System.out.println("dbgit init mybranch");
  }


}
