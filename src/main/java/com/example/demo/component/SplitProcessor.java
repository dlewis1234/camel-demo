package com.example.demo.component;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.repository.FileEventRepository;
import com.example.demo.repository.ProcessStatusRepository;
import com.example.demo.utils.FileEventConverter;

@Component
public class SplitProcessor implements Processor {

	@Autowired
	FileEventConverter converter;
	
	@Autowired
	FileEventRepository repository;
	
	@Autowired
	ProcessStatusRepository processStatusRepository;

	@Override
	public void process(Exchange exchange) throws Exception {
		/*String fileName = (String) exchange.getIn().getHeader("CamelFileName");
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
		service.save(event);*/
		repository.save(converter.createFileEvent("Splitting Records",exchange));
	}

}
