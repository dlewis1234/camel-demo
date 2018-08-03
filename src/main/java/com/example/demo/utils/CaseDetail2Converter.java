package com.example.demo.utils;

import java.io.ByteArrayInputStream;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.util.UUID;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;

import org.apache.camel.Exchange;
import org.springframework.stereotype.Component;
import org.springframework.util.xml.SimpleNamespaceContext;
import org.w3c.dom.Document;
import org.w3c.dom.Node;

import com.example.demo.domain.CaseDetail2;

@Component
public class CaseDetail2Converter {
	
	public CaseDetail2 createCaseDetail2(Exchange exchange) throws Exception {
		CaseDetail2 caseDetail = new CaseDetail2();
		String xmlString = (String) exchange.getIn().getBody(String.class);
		DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = builderFactory.newDocumentBuilder();
		Document xmlDocument = builder.parse(new ByteArrayInputStream(xmlString.getBytes(StandardCharsets.UTF_8)));
		XPath xPath = XPathFactory.newInstance().newXPath();
		SimpleNamespaceContext nsc = new SimpleNamespaceContext();
		nsc.bindDefaultNamespaceUri("http://www.visa.com/ROLSI");
		xPath.setNamespaceContext(nsc);
		Node node = (Node) xPath.compile("//VisaCaseNumber").evaluate(xmlDocument, XPathConstants.NODE);
		caseDetail.setKey(caseDetail.new Key(node.getTextContent(),LocalDateTime.now()));
		caseDetail.setUuid(UUID.randomUUID());
		caseDetail.setIdentifier1("identifier1");
		caseDetail.setIdentifier2("identifier2");
		caseDetail.setIdentifier3("identifier3");
		caseDetail.setIdentifier4("identifier4");
		caseDetail.setCreatedBy("Apache Camel");
		caseDetail.setActive(1);
		return caseDetail;
	}
}
