package com.xii.test;

import org.json.JSONObject;
import org.json.XML;

public class test01 {

	public static void main(String[] args) {

		
		String xmlString = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><test>test value</test><test2>test2 value</test2>";
		JSONObject jsonObject = XML.toJSONObject(xmlString);

		System.out.println("XML String : " + xmlString);
		System.out.println("Convert result : "+jsonObject.toString());
		System.out.println("Key : test   Value : " + jsonObject.getString("test"));
		System.out.println("Key : test2  Value : " + jsonObject.getString("test2"));

		
	}

}
