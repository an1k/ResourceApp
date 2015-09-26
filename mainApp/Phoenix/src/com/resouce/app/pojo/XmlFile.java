package com.resouce.app.pojo;

import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class XmlFile {

	private FileObject xmlFile;
	private String rootTag;
	private String rootElement;
	private NodeList nodeList;
	private Document document;
	public FileObject getXmlFile() {
		return xmlFile;
	}
	public String getRootTag() {
		return rootTag;
	}
	public String getRootElement() {
		return rootElement;
	}
	public NodeList getNodeList() {
		return nodeList;
	}
	public XmlFile(String fileName,String rootTag) throws ParserConfigurationException, SAXException, IOException{
		this.xmlFile=new FileObject(fileName);
		this.rootTag=rootTag;
	DocumentBuilderFactory documentFactory=DocumentBuilderFactory.newInstance();
	DocumentBuilder docBuilder=documentFactory.newDocumentBuilder();
	this.document=docBuilder.parse(xmlFile.getFile());
	
	document.getDocumentElement().normalize();
	this.nodeList=document.getElementsByTagName(rootTag);
	this.rootElement=document.getDocumentElement().getNodeName();
	
	}
	
	private XmlFile(String rootTag) throws ParserConfigurationException{
		this.rootTag=rootTag;
		DocumentBuilderFactory documentFactory=DocumentBuilderFactory.newInstance();
		DocumentBuilder docBuilder=documentFactory.newDocumentBuilder();
		
		//defines root elements
		this.document=docBuilder.newDocument();
		
	}
	
	public static synchronized XmlFile createNewXml(String fileName,String rootTag) throws ParserConfigurationException{
		XmlFile temp=new XmlFile(rootTag);
		
		temp.xmlFile=new FileObject(fileName);
		
		return temp;
		
	}
	public Document getDocument() {
		return document;
	}


}

