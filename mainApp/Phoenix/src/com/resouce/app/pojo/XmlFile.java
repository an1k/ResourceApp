package com.resouce.app.pojo;

import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class XmlFile {

	private FileObject xmlFile;
	private String rootTag;
	private String rootElement;
	private NodeList nodeList;
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
	Document doc=docBuilder.parse(xmlFile.getFile());
	
	doc.getDocumentElement().normalize();
	this.nodeList=doc.getElementsByTagName(rootTag);
	this.rootElement=doc.getDocumentElement().getNodeName();
	}
}
