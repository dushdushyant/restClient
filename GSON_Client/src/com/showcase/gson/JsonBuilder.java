package com.showcase.gson;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;

public class JsonBuilder {

	/**
	 * @param args
	 */
	static Gson gson= new Gson();
	public static void main(String[] args) {
		System.out.println("****************Creating JSON Object*************");
		
		List<MyBean> listBeanObj = new ArrayList<MyBean>();
		for(int i=1;i<11;i++){
			MyBean beanObj = new MyBean();
			beanObj.setBeanId(i);
			beanObj.setBeanName("Bean"+i);
			beanObj.setBeanProp("BeanProp:"+i);
			listBeanObj.add(beanObj);
		}
		String listJSONBean=gson.toJson(listBeanObj);
		System.out.println(listJSONBean);

	}

}
