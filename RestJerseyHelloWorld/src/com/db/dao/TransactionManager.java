package com.db.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.db.connection.DBManager;


public class TransactionManager {
	
	public ArrayList<String> getUsers() throws SQLException{
		ArrayList<String> userList = new ArrayList<String>();
		Connection conn= DBManager.getConnection();
		ResultSet r1 = null;
		Statement st = null;
		try {
			st = conn.createStatement();
			r1 = st.executeQuery(SqlQueries.GET_USERS);
			while (r1.next()) {
				userList.add(r1.getString(1));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			st.close();
			r1.close();
			conn.close();
		}
		return userList;
	}

}
