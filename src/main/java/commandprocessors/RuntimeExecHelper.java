package commandprocessors;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;

public class RuntimeExecHelper {

  public static Process execRuntimeCommand(String command) throws Exception {
    Process exec = Runtime.getRuntime().exec(command);
    exec.waitFor();
    String line;
    BufferedReader error = new BufferedReader(new InputStreamReader(exec.getErrorStream()));
    while ((line = error.readLine()) != null) {
      System.out.println(line);
    }
    error.close();

    BufferedReader input = new BufferedReader(new InputStreamReader(exec.getInputStream()));
    while ((line = input.readLine()) != null) {
      System.out.println(line);
    }
    OutputStream outputStream = exec.getOutputStream();
    PrintStream printStream = new PrintStream(outputStream);
    printStream.println();
    printStream.flush();
    printStream.close();
    return exec;
  }

  public static Process execRuntimeCommand(String[] command) throws Exception {
    Process exec = Runtime.getRuntime().exec(command);
    exec.waitFor();
    String line;
    BufferedReader error = new BufferedReader(new InputStreamReader(exec.getErrorStream()));
    while ((line = error.readLine()) != null) {
      System.out.println(line);
    }
    error.close();

    BufferedReader input = new BufferedReader(new InputStreamReader(exec.getInputStream()));
    while ((line = input.readLine()) != null) {
      System.out.println(line);
    }
    OutputStream outputStream = exec.getOutputStream();
    PrintStream printStream = new PrintStream(outputStream);
    printStream.println();
    printStream.flush();
    printStream.close();
    return exec;
  }



  public static Process execWithProcessBuilder(String command)
      throws IOException, InterruptedException {
    ProcessBuilder builder = new ProcessBuilder(command);
    builder.inheritIO();
    Process p = builder.start();
    return p;
  }

  public static Process execWithProcessBuilder(String[] command)
      throws IOException, InterruptedException {
    ProcessBuilder builder = new ProcessBuilder(command);
    builder.inheritIO();
    Process p = builder.start();
    p.waitFor();
    return p;
  }
}
