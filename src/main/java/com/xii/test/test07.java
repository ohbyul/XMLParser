package com.xii.test;

import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;

public class test07 {

	public static void main(String[] args) {

		try {

			new test07().start();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private void start() throws Exception {
		URL url = new URL("xml 주소입력");
		URLConnection connection = url.openConnection();

		Document doc = parseXML(connection.getInputStream());
		NodeList descNodes = doc.getElementsByTagName("Parent");

		for (int i = 0; i < descNodes.getLength(); i++) {

			for (Node node = descNodes.item(i).getFirstChild(); node != null; node = node.getNextSibling()) {
				// 첫번째 자식을 시작으로 마지막까지 다음 형제를 실행 

				if (node.getNodeName().equals("Child1")) {
					System.out.println(node.getTextContent());
				} else if (node.getNodeName().equals("Child2")) {
					System.out.println(node.getTextContent());
				} else if (node.getNodeName().equals("Child3")) {
					System.out.println(node.getTextContent());
				}

			}

		}
	}

	private Document parseXML(InputStream stream) throws Exception {

		DocumentBuilderFactory objDocumentBuilderFactory = null;
		DocumentBuilder objDocumentBuilder = null;
		Document doc = null;

		try {

			objDocumentBuilderFactory = DocumentBuilderFactory.newInstance();
			objDocumentBuilder = objDocumentBuilderFactory.newDocumentBuilder();

			doc = objDocumentBuilder.parse(stream);

		} catch (Exception ex) {
			throw ex;
		}

		return doc;
	}

	
	
	
	
	
	
	
	
/*test.xml
 * <?xml version="1.0" encoding="UTF-8"?>
<list>
    <Parent>
        <Child1>123</Child1>
        <Child2>홍길동전</Child2>
        <Child3>허균</Child3>
    </Parent>
    <Parent>
        <Child1>124</Child1>
        <Child2>레미제라블</Child2>
        <Child3>빅토르 위고</Child3>
    </Parent>
</list>

 * */
	
	
	
	
}
