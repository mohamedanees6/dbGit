package dbGit;

/**
 * The Class ConnectionParams.
 */
public class ConnectionParams {

  /** The port. */
  private String port;

  /** The user name. */
  private String userName;

  /** The password. */
  private String password;

  /** The db name. */
  private String dbName;

  /**
   * Gets the port.
   *
   * @return the port
   */
  public String getPort() {
    return port;
  }

  /**
   * Sets the port.
   *
   * @param port the new port
   */
  public void setPort(String port) {
    this.port = port;
  }

  /**
   * Gets the schema.
   *
   * @return the schema
   */
  public String getSchema() {
    return schema;
  }

  /**
   * Sets the schema.
   *
   * @param schema the new schema
   */
  public void setSchema(String schema) {
    this.schema = schema;
  }

  /**
   * Gets the password.
   *
   * @return the password
   */
  public String getPassword() {
    return password;
  }

  /**
   * Sets the password.
   *
   * @param password the new password
   */
  public void setPassword(String password) {
    this.password = password;
  }

  /**
   * Gets the user name.
   *
   * @return the user name
   */
  public String getUserName() {
    return userName;
  }

  /**
   * Sets the user name.
   *
   * @param userName the new user name
   */
  public void setUserName(String userName) {
    this.userName = userName;
  }

  /**
   * Gets the db name.
   *
   * @return the db name
   */
  public String getDbName() {
    return dbName;
  }

  /**
   * Sets the db name.
   *
   * @param dbName the new db name
   */
  public void setDbName(String dbName) {
    this.dbName = dbName;
  }
}
