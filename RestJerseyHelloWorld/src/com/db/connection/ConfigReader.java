package com.db.connection;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;


/**
 * This class reads the Configuration properties file from a predefined path
 * 
 * @author Dush
 * @version 1.0.1
 */
public class ConfigReader {

	/** configuration keys . */
	private List<String> keys;

	/** Configuration properties. */
	private Hashtable<String, String> properties;

	/**
	 * Constructor
	 * 
	 * @param configName
	 *            configuration name.
	 * @throws IOException
	 */
	public ConfigReader(String configName) throws IOException {
		readXML(configName);
	}

	/**
	 * Reads XML configuration file
	 * 
	 * @param configName
	 * @throws IOException 
	 */
	private void readXML(String configName) throws IOException {
		URL url = ConfigReader.class.getResource(configName
				+ "_config.properties");
		String fileString = url.getPath();
		fileString = fileString.replaceAll("%20", " ");
		File file = new File(fileString);
		NodeList list = null;
		try {
			DocumentBuilderFactory factory = DocumentBuilderFactory
					.newInstance();
					
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document doc = builder.parse(file);

			list = doc.getElementsByTagName("*");
			if (list != null) {
				properties = new Hashtable<String, String>(list.getLength(), 1);
				keys = new ArrayList<String>();
			}
			for (int i = 0; i < list.getLength(); i++) {
				Node element = (Node) list.item(i);
				if (!element.getNodeName().equals("root")) {
					NodeList child = doc.getElementsByTagName(element
							.getNodeName());
					Node node = child.item(0);
					keys.add(element.getNodeName());
					properties
							.put(element.getNodeName(), node.getTextContent());
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			
		}
	}

	/**
	 * @return the keys
	 */
	public List<String> getKeys() {
		return keys;
	}

	/**
	 * @return the properties
	 */
	public Hashtable<String, String> getProperties() {
		return properties;
	}

}
