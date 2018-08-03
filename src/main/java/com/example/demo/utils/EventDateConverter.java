package com.example.demo.utils;

import java.io.ByteArrayInputStream;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.UUID;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;

import org.apache.camel.Exchange;
import org.springframework.stereotype.Component;
import org.springframework.util.xml.SimpleNamespaceContext;
import org.w3c.dom.Document;
import org.w3c.dom.Node;

import com.example.demo.domain.EventDate;

@Component
public class EventDateConverter {
	
	public EventDate createEventDate(Exchange exchange) throws Exception {
		EventDate eventDate = new EventDate();
		String xmlString = (String) exchange.getIn().getBody(String.class);
		
		DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = builderFactory.newDocumentBuilder();
		Document xmlDocument = builder.parse(new ByteArrayInputStream(xmlString.getBytes(StandardCharsets.UTF_8)));
		XPath xPath = XPathFactory.newInstance().newXPath();
		SimpleNamespaceContext nsc = new SimpleNamespaceContext();
		nsc.bindDefaultNamespaceUri("http://www.visa.com/ROLSI");
		xPath.setNamespaceContext(nsc);
		Node node = (Node) xPath.compile("//VisaCaseNumber").evaluate(xmlDocument, XPathConstants.NODE);
		eventDate.setKey(eventDate.new Key(LocalDate.now(),LocalTime.now(),node.getTextContent(),UUID.randomUUID()));
		return eventDate;
	}

}
