package commandprocessors;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import dbGit.ConnectionParams;
import dbGit.DbGitCommand;
import dbGit.PgConnectionUtility;

public abstract class AbstractCommandProcessor {

  protected Connection connection;

  protected Statement statement;
  
  protected ConnectionParams connectionParams;

  public abstract void process(String branchName) throws Exception;

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

  public Statement preProcess(ConnectionParams connectionParam) throws Exception {
    this.connectionParams = connectionParam;
    this.statement = this.connection.createStatement();
    return statement;
  }

  public void postProcess(Connection c, Statement statement) throws SQLException {
    PgConnectionUtility.commitClose(c, statement);
  }

  public void execute(ConnectionParams connectionParam, String branchName) throws Exception {
    preProcess(connectionParam);
    process(branchName);
    postProcess(this.connection, this.statement);
  }
}
