package com.test;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import com.google.gson.Gson;
import com.test.model.ContactDetails;
import com.test.model.Contacts;
import com.test.model.Phone;

public class Caller {

	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String sCurrentLine = null;
		Contacts con= new Contacts();
		Gson gson = new Gson();
		BufferedReader br = null;
		StringBuffer sb= new StringBuffer();
		try {
			 
			
 
			br = new BufferedReader(new FileReader("C:\\json.txt"));
			while ((sCurrentLine = br.readLine()) != null) {
				sb.append(sCurrentLine);
//				System.out.println(sCurrentLine);
			}
 
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (br != null)br.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
		String json=sb.toString();
		
//		System.out.println("JSON: "+json);
		Contacts c = new Contacts();
		ContactDetails cdetails = new ContactDetails();
		Phone p= new Phone();
		p.setHome("0354-2254701");
		p.setMobile("9804064091");
		p.setOffice("03366367120");
		
//		ArrayList<Phone> phone = new ArrayList<Phone>();
//		phone.add(p);
		
		cdetails.setName("Dushyant");
		cdetails.setAddress("Darjeeling");
		cdetails.setEmail("dushdushyant@gmail.cim");
		cdetails.setId("240417");
		cdetails.setGender("male");
		cdetails.setPhone(p);
		
		ArrayList<ContactDetails> contact = new ArrayList<ContactDetails>();
		contact.add(cdetails);
		contact.add(cdetails);
		
		c.setContactList(contact);
//		Contacts c= gson.fromJson(json, con.getClass());
		String opJson= gson.toJson(c);
		System.out.println("Object Created "+opJson);
		
		
		ArrayList<ContactDetails> contactListReceived = new ArrayList<ContactDetails>();
		try{
			Contacts c_Received= gson.fromJson(json, Contacts.class);
//			Contacts c_Received= gson.fromJson(opJson, Contacts.class);
		contactListReceived=c_Received.getContactList();
		System.out.println("size: "+contactListReceived.size());
		}catch(Exception e){
			e.printStackTrace();
		}
		
//		System.out.println(c.getContactList().size());
	}

//	http://stackoverflow.com/questions/7632541/json-parsing-with-gson
}
