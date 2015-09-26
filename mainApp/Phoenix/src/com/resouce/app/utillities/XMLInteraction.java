package com.resouce.app.utillities;



import java.io.File;
import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.resouce.app.pojo.XmlFile;

public class XMLInteraction {
	
	
	private XmlFile xmlFile;
	private Document document;
	private Element rootElement;
	
	public void existingXml(String fileName,String rootTag) throws ParserConfigurationException, SAXException, IOException{
		
		
			this.xmlFile=new XmlFile(fileName,rootTag);
			this.document=xmlFile.getDocument();
		
		
		
	}
	
	public void newXml(String fileName,String rootTag) throws ParserConfigurationException{
		
		xmlFile=XmlFile.createNewXml(fileName, rootTag);
		this.document=xmlFile.getDocument();
		this.rootElement=createRootElement(rootTag);
	}
	
	public void readXml(){
		
		
		
		System.out.println("root element: "+ xmlFile.getRootElement());
		NodeList nodeList=xmlFile.getNodeList();
		this.rootElement=document.getDocumentElement();
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
	
	public XmlFile getXmlFile() {
		return xmlFile;
	}

	public Document getDocument() {
		return document;
	}

	public void writeXml() throws TransformerException{
			
		
			
			
			
			TransformerFactory transformerFactory=TransformerFactory.newInstance();
			Transformer transformer=transformerFactory.newTransformer();
			DOMSource domSource=new DOMSource(document);
			StreamResult streamResult=new StreamResult(xmlFile.getXmlFile().getFile());
			
			transformer.transform(domSource, streamResult);
			System.out.println("file saved");
			
			
		
	}
	
	private Element createRootElement(String rootTag){

		Element rootElement =document.createElement(rootTag);
		document.appendChild(rootElement);	
		
		return rootElement;
	}
	
	
	
	public Element createElement(String tagName){
		
		Element element=xmlFile.getDocument().createElement(tagName);
		
		rootElement.appendChild(element);
		
		return element;
		
	}
	
	public void setAttribute(Element element,String attributeName,String attributeValue){
		
		Attr attribute=document.createAttribute(attributeName);
		attribute.setValue(attributeValue);
		element.setAttributeNode(attribute);
	}
	
	public Element createTextNode(Element element,String tagName,String textValue){
		Element textElement=document.createElement(tagName);
		textElement.appendChild(document.createTextNode(textValue));
		element.appendChild(textElement);
		return textElement;
		
	}
	
	}

