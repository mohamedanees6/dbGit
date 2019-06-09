package commandprocessors;

import java.io.File;

public class ViewBranchProcessor extends AbstractCommandProcessor {
  @Override
  public void process(String branchName) throws Exception {
    boolean isAnyBranchExists = false;
    System.out.println("DB --> Branch\n===============");
    for (File file : new File(".").listFiles()) {
      if (file.getName().startsWith("dbgit")) {
        isAnyBranchExists = true;
        System.out.println(file.getName().split("_")[1] + " --> "
            + file.getName().split("_")[2].split("[.]")[0]);
      }
    }
    if (!isAnyBranchExists) {
      System.out.println("No branches present. Type in dbGit help for further instructions");
    }
  }
}
