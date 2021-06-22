package com.xii.test;


import java.io.File;
import java.io.FileInputStream;
import org.json.XML;
import org.json.JSONObject;


public class test02 {

	public static void main(String[] args) {

		String BASE_DATA_PATH = "C:/test_in/";
		
		getXmlFile(BASE_DATA_PATH);
		
	}

	public static void getXmlFile(String BASE_DATA_PATH) {
		
		String xmlFileName = null;
		String DATA_PATH = "C:/test_out/";
		
		File files = new File(BASE_DATA_PATH);
		File[] XmlFileList = files.listFiles();
		
		for(int i =0;i<XmlFileList.length;i++) {
			File file = XmlFileList[i];
			
			if(file.isDirectory()) {
				
				getXmlFile(file.getPath());
				
			}else if((file.getName().endsWith(".xml"))){
				xmlFileName = file.getName();
				
				xmlReadProcess(BASE_DATA_PATH,xmlFileName,DATA_PATH);
			}
		}
		
	}
	
	
	public static void xmlReadProcess(String BASE_DATA_PATH,String xmlFileName,String DATA_PATH) {
	
		try {
			FileInputStream fis = new FileInputStream(BASE_DATA_PATH+"/"+xmlFileName);
			
			byte[] byteBuff = new byte[9999]; 
			int nRLen = fis.read(byteBuff); 
			
			String strBuffer = new String(byteBuff,0,nRLen);
			
			System.out.printf("읽은 바이트수[%d] : \n읽은 내용 : \n%s \n", nRLen, strBuffer); 

/*
			String XmlStr = "<?xml version=\"1.0\"?>\r\n"
					+ "<company>\r\n"
					+ "    <employee id=\"1001\">\r\n"
					+ "        <firstname>Tony</firstname>\r\n"
					+ "        <lastname>Black</lastname>\r\n"
					+ "        <salary>100000</salary>\r\n"
					+ "    </employee>\r\n"
					+ "</company>";

			JSONObject jsonObject = XML.toJSONObject(XmlStr);

			System.out.println("Convert result : "+jsonObject.toString());
*/			
			//JSONParser jp = new JSONParser();
			
			
			
			JSONObject jsonObject = XML.toJSONObject(strBuffer);
			
			System.out.println("XML String : " + strBuffer);
			System.out.println("Convert result : "+jsonObject.toString());
			System.out.println("Key : gender   Value : " + jsonObject.getString("gender"));
			System.out.println("Key : tall  Value : " + jsonObject.getString("tall"));

			
			
			fis.close();

			
		} catch (Exception e) {
			e.printStackTrace();
		}


	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
