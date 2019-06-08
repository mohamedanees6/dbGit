package dbGit;

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


  public static ConnectionParams getConnectionParams(String[] args) {
    ConnectionParams param = null;
    String command = args[0];
    String addressAndPort = args[1];
    String dbName = args[2];
    String dbUserName = args[3];
    String dbPassword = args[4];
    if (isInvalidParam(command, addressAndPort, dbName, dbUserName, dbPassword)) {
      PrintHelper.printHelpMessageToScreen(DbGitCommand.HELP);
    } else {
      param = new ConnectionParams();
      param.setAddress(addressAndPort.split(":")[0]);
      param.setPort(Integer.parseInt(addressAndPort.split(":")[1]));
      param.setDbName(dbName);
      param.setDbUsername(dbUserName);
      param.setDbPassword(dbPassword);
    }
    return param;
  }

  private static boolean isInvalidParam(String command, String addressAndPort, String dbName,
      String dbUserName, String dbPassword) {
    return addressAndPort == null || command == null || dbUserName == null || dbPassword == null
        || !addressAndPort.contains(":") || addressAndPort.equals("null")
        || dbName.equals("null") || dbUserName.equals("null");
  }

}
