package com.resouce.app.utillities;



import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.resouce.app.pojo.XmlFile;

public class XMLInteraction {
	
	
	XmlFile xmlFile;
	
	
	
	public XMLInteraction(String fileName,String rootTag){
		
		try {
			this.xmlFile=new XmlFile(fileName,rootTag);
		} catch (ParserConfigurationException | SAXException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	public void readXml(){
		
		
		
		System.out.println("root element: "+xmlFile.getRootElement());
		NodeList nodeList=xmlFile.getNodeList();
		for(int temp=0;temp<nodeList.getLength();temp++){
			Node node=nodeList.item(temp);
			
			System.out.println("element type: "+node.getNodeName());
			
			if(node.getNodeType()==Node.ELEMENT_NODE){
				Element element=(Element)node;
				//System.out.println("element id="+element.getAttribute("id"));
				//System.out.println("firstname: "+element.getElementsByTagName("firstname").item(0).getTextContent());
				//System.out.println("lastname: "+element.getElementsByTagName("lastname").item(0).getTextContent());
				//System.out.println("email: "+element.getElementsByTagName("email").item(0).getTextContent());
				//System.out.println("phone: "+element.getElementsByTagName("phone").item(0).getTextContent());
				
			}
		}
	
	}
}
