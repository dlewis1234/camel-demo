package com.example.demo.component;

import java.io.ByteArrayInputStream;
import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.UUID;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.stream.StreamSource;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.xml.SimpleNamespaceContext;
import org.w3c.dom.Document;

import com.example.demo.domain.WorkflowEvent;
import com.example.demo.repository.WorkflowEventRepository;
import com.example.demo.service.WorkFlowEventService;

@Component
public class SplitProcessor implements Processor {

	@Autowired
	WorkFlowEventService service;

	@Override
	public void process(Exchange exchange) throws Exception {
		String fileName = (String) exchange.getIn().getHeader("CamelFileName");
		String xmlString = (String) exchange.getIn().getBody(String.class);
		
		DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = builderFactory.newDocumentBuilder();
		Document xmlDocument = builder.parse(new ByteArrayInputStream(xmlString.getBytes(StandardCharsets.UTF_8)));
		XPath xPath = XPathFactory.newInstance().newXPath();
		SimpleNamespaceContext nsc = new SimpleNamespaceContext();
		nsc.bindDefaultNamespaceUri("http://www.visa.com/ROLSI");
		xPath.setNamespaceContext(nsc);
		Object recount = xPath.compile("count(//Case)").evaluate(xmlDocument, XPathConstants.NUMBER);
		WorkflowEvent event = new WorkflowEvent();
		event.setId(UUID.randomUUID());
		event.setEventDate(new Date());
		event.setEventType(fileName + " contains " + (Double) recount + " records");
		event.setFileName(fileName);
		service.save(event);
	}

}
