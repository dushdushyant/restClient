package com.db.connection;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 * This class handles all the database connection related properties.
 * 
 * @author Dush
 * 
 */
public class DBManager implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * Creates and Returns connection to Database.
	 * 
	 * @return connection object
	 * @throws ClassNotFoundException 
	 * @throws TCSSerializationException
	 */
	public static Connection getConnection(){
		DBConfig dbConfig = new DBConfig();
		Connection conn = null;

		try {
			Class.forName(dbConfig.getDriverClass());
			conn = DriverManager.getConnection(dbConfig.getJdbcUrl()
					+ dbConfig.getDbName(), dbConfig.getUsername(), dbConfig
					.getPassword());

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		return conn;

	}

	}
