package dbGit;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

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
  public static Connection getConnection(ConnectionParams connectionParam) throws Exception {
    Class.forName("org.postgresql.Driver");
    Connection c = DriverManager.getConnection(
        "jdbc:postgresql://" + connectionParam.getAddress() + ":" + connectionParam.getPort()
            + "/" + connectionParam.getDbName(),
        connectionParam.getDbUsername(), connectionParam.getDbPassword());
    if (c == null) {
      throw new Exception("Unable to obtain connection");
    }
    return c;
  }

  public static void commitClose(Connection con, Statement st) throws SQLException {
    if (st != null && !st.isClosed()) {
      st.close();
    }
    if (con != null && !con.isClosed()) {
      con.close();
    }
  }
}
