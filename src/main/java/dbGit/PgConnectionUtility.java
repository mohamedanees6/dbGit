package dbGit;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * The Class PgConnectionUtility.
 */
public class PgConnectionUtility {
  
  /**
   * Gets the connection.
   *
   * @return the connection
   * @throws Exception the exception
   */
  public static Connection getConnection() throws Exception {
    Class.forName("org.postgresql.Driver");
    Connection c =
        DriverManager.getConnection("jdbc:postgresql://localhost:5432/testdb", "postgres", "");
    if(c == null){
      throw new Exception("Unable to obtain connection");
    }
    return c;
  }
}
