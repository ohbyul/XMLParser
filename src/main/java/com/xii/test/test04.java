package com.xii.test;

import java.io.IOException;
import java.io.StringReader;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

public class test04 {

	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {

		//문자열 일때
		
		String XmlStr = "<?xml version=\"1.0\" encoding=\"utf-8\" ?> \r\n" + "<xml form_ver=\"1.0\"> \r\n"
				+ "    <FILE> \r\n" + "        <name>0001_20210525095758_04-02__41_a.jpg</name> \r\n"
				+ "    </FILE>\r\n" + "    <CAMERA ID=\"0001\">\r\n" + "        <resolution>FHD</resolution>\r\n"
				+ "    </CAMERA>\r\n" + "    <ANNOTATOR>a</ANNOTATOR>\r\n" + "    <REVIEWER>a</REVIEWER>\r\n"
				+ "    <OBJECT ID=\"0001_20210525095758_04-02__41_a\" TYPE=\"Human\">\r\n" + "        <info>\r\n"
				+ "        <face_side>side</face_side>\r\n" + "        <gender>unknown</gender>\r\n"
				+ "        <age>Unknown</age>\r\n" + "        <tall>Unknown</tall>\r\n"
				+ "        <upperclothes>long_sleeve</upperclothes>\r\n"
				+ "        <upperclothes_color>black</upperclothes_color>\r\n"
				+ "        <lowerclothes>long_pants</lowerclothes>\r\n"
				+ "        <lowerclothes_color>black</lowerclothes_color>\r\n"
				+ "        <shoes_color>white</shoes_color>\r\n" + "        <bag>unuse</bag>\r\n"
				+ "        <glasses>no</glasses>\r\n" + "        <head_type>undefine</head_type>\r\n" + "</info>\r\n"
				+ "    </OBJECT>\r\n" + " </xml>";


		// XML 문서 파싱
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		
		DocumentBuilder documentBuilder = factory.newDocumentBuilder();
	
		InputSource is = new InputSource(new StringReader(XmlStr));
		documentBuilder = factory.newDocumentBuilder();
		Document document = documentBuilder.parse(is);
		
		// root 구하기
		Element root = document.getDocumentElement();
		
		// root의 속성
		System.out.println("class name: " + root.getAttribute("TYPE"));
		
		NodeList childeren = root.getChildNodes(); // 자식 노드 목록 get
		for(int i = 0; i < childeren.getLength(); i++){
			Node node = childeren.item(i);
			if(node.getNodeType() == Node.ELEMENT_NODE){ // 해당 노드의 종류 판정(Element일 때)
				Element ele = (Element)node;
				String nodeName = ele.getNodeName();
				System.out.println("node name: " + nodeName);
				if(nodeName.equals("CAMERA")){
					System.out.println("node attribute: " + ele.getAttribute("ID"));
				}
				else if(nodeName.equals("OBJECT")){
					// 이름이 student인 노드는 자식노드가 더 존재함
					NodeList childeren2 = ele.getChildNodes();
					for(int a = 0; a < childeren2.getLength(); a++){
						Node node2 = childeren2.item(a);
						
						if(node2.getNodeType() == Node.ELEMENT_NODE){
//							Element ele2 = (Element)node2;
//							String nodeName2 = ele2.getNodeName();
//							System.out.println("node name2: " + nodeName2);
//							System.out.println("node attribute2: " + ele2.getAttribute("bag"));

							Element ele2 = (Element)node2;
							System.out.println(ele2.getTextContent());
						}
					}
				}
			}
		}
			
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
