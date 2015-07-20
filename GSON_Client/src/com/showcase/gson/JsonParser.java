package com.showcase.gson;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class JsonParser {

	/**
	 * @param args
	 */
	static String JSON_IP="";
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("*****************Parsing JSON Object*****************");
		Gson gson = new Gson();
		System.out.println("Enter your JSON here (Press enter to submit) \n");
		Scanner in = new Scanner(System.in);
		String input = in.next();
		System.out.println("Input JSON is: "+input);

		Type listType = new TypeToken<ArrayList<MyBean>>() {
		}.getType();
		List<MyBean> myBeanList = new Gson().fromJson(input, listType);
		System.out.println("Size of List of Objects: "+ myBeanList.size());
		System.out.println("******************************");
		for(int i=0;i<myBeanList.size();i++){
			System.out.println("Object "+(i+1)+":");
			MyBean bean =myBeanList.get(i);
			System.out.println("Bean ID: "+bean.getBeanId());
			System.out.println("Bean Name: "+bean.getBeanName());
			System.out.println("Bean Prop "+bean.getBeanProp());
			System.out.println("****************************");
		}
		

	}

}
