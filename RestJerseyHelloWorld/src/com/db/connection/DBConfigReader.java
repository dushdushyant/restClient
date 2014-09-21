package com.db.connection;

import java.io.IOException;

/**
 * DataBase Configuration Reader class which reads the DataBase Configuration
 * from a XML file and generates all the necessary parameters
 * 
 * @author Dush
 * 
 */
public class DBConfigReader extends ConfigReader {

	/**
	 * Constructor.
	 * 
	 * @throws TCSSerializationException
	 * @throws IOException
	 */
	public DBConfigReader() throws IOException {
		super("db");
	}

}
