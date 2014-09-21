package com.db.connection;

import java.util.Hashtable;



/**
 * This class holds the DataBase connection related information from the
 * configuration file.
 * 
 * @author Dush
 * 
 */
public class DBConfig {

	private String driverClass = "com.mysql.jdbc.Driver";

	private String IP = "";

	private String PORT = "";

	private String jdbcUrl = "";

	private String username = "";

	private String password = "";

	private String dbName = "";

	/**
	 * Constructor
	 */
	public DBConfig() {
		try {
			DBConfigReader confReader = new DBConfigReader();
			Hashtable<String, String> props = confReader.getProperties();
			IP = props.get("IP");
			PORT = props.get("PORT");
			username = props.get("UserName");
			password = props.get("Password");
			dbName = props.get("DataBase");
			jdbcUrl = "jdbc:mysql://" + IP + ":" + PORT + "/";
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * @return the driver class.
	 */
	public String getDriverClass() {
		return driverClass;
	}

	/**
	 * @param driverClass
	 *            the driver class to set.
	 */
	public void setDriverClass(String driverClass) {
		this.driverClass = driverClass;
	}

	/**
	 * @return the jdbc Url.
	 */
	public String getJdbcUrl() {
		return jdbcUrl;
	}

	/**
	 * @param jdbcUrl
	 *            the jdbc url to set.
	 */
	public void setJdbcUrl(String jdbcUrl) {
		this.jdbcUrl = jdbcUrl;
	}

	/**
	 * @return the user name.
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param username
	 *            the user name to set.
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * @return the password.
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password
	 *            the password to set.
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * 
	 * @return database name.
	 */
	public String getDbName() {
		return dbName;
	}

	/**
	 * 
	 * @param dbName
	 *            the database name to set.
	 */
	public void setDbName(String dbName) {
		this.dbName = dbName;
	}

	/**
	 * 
	 * @return IP address.
	 */
	public String getIP() {
		return IP;
	}

	/**
	 * 
	 * @param iP
	 *            the IP address to set.
	 */
	public void setIP(String iP) {
		IP = iP;
	}

	/**
	 * 
	 * @return the port number.
	 */
	public String getPORT() {
		return PORT;
	}

	/**
	 * the port number to set.
	 * 
	 * @param pORT
	 */
	public void setPORT(String pORT) {
		PORT = pORT;
	}

}
