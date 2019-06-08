package commandprocessors;

import java.sql.Connection;

import dbGit.PgConnectionUtility;

public class InitBranchProcessor extends AbstractCommandProcessor {


  @Override
  public void process(String[] args) throws Exception {
    Connection c = PgConnectionUtility.getConnection();
    
  }

}
