package dbGit;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConnectionParams {
  private String address;
  private String dbUsername;
  private String dbPassword;
  private Integer port;
  private String dbName;

  private ConnectionParams() {

  }

  /**
   * @return the address
   */
  public String getAddress() {
    return address;
  }

  /**
   * @param address the address to set
   */
  public void setAddress(String address) {
    this.address = address;
  }

  /**
   * @return the dbUsername
   */
  public String getDbUsername() {
    return dbUsername;
  }

  /**
   * @param dbUsername the dbUsername to set
   */
  public void setDbUsername(String dbUsername) {
    this.dbUsername = dbUsername;
  }

  /**
   * @return the dbPassword
   */
  public String getDbPassword() {
    return dbPassword;
  }

  /**
   * @param dbPassword the dbPassword to set
   */
  public void setDbPassword(String dbPassword) {
    this.dbPassword = dbPassword;
  }

  /**
   * @return the port
   */
  public Integer getPort() {
    return port;
  }

  /**
   * @param port the port to set
   */
  public void setPort(Integer port) {
    this.port = port;
  }

  public String getDbName() {
    return dbName;
  }

  public void setDbName(String dbName) {
    this.dbName = dbName;
  }

  public static ConnectionParams readConfigurationFromFile() throws IOException {
    ConnectionParams conParams = new ConnectionParams();
    try (InputStream input = new FileInputStream("dbgit.properties")) {
      Properties props = new Properties();
      props.load(input);
      conParams.setAddress(props.getProperty("db.address", "localhost"));
      conParams.setPort(Integer.parseInt(props.getProperty(props.getProperty("db.port", "5432"))));
      conParams.setDbName(props.getProperty(props.getProperty("db.name")));
      conParams.setDbUsername(props.getProperty("db.username"));
      conParams.setDbPassword(props.getProperty("db.password"));
    }
    return conParams;
  }


  public static ConnectionParams getConnectionParams(String[] args) throws IOException {
    ConnectionParams param = readConfigurationFromFile();
    return param;
  }

}
