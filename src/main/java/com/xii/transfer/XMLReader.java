package com.xii.transfer;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.json.XML;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.json.JSONObject;


public class XMLReader {

	public static void main(String[] args) {

		String BASE_DATA_PATH = "C:/test_in/";	//가져올 디렉토리 복사할 디렉토리
		
		getXmlFile(BASE_DATA_PATH);
		
	}

	public static void getXmlFile(String BASE_DATA_PATH) {
		
		String xmlFileName = null;
		String DATA_PATH = "C:/test_out/";	//내보낼 디렉토리 붙여넣을 디렉토리 
		
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

			org.json.JSONObject xmlJSONObject = XML.toJSONObject(strBuffer);
			
			String xmlJSONObjString = xmlJSONObject.toString();
    		
			System.out.println("XML -> JSON : " + xmlJSONObjString );

			
			fis.close();

			
		} catch (Exception e) {
			e.printStackTrace();
		}


	}






	
	
	
}
