package com.example.demo.component;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.repository.FileEventRepository;
import com.example.demo.utils.FileEventConverter;

@Component
public class ValidationProcessor implements Processor {

	@Autowired
	FileEventConverter converter;
	
	@Autowired
	FileEventRepository repository;

	@Override
	public void process(Exchange exchange) throws Exception {
		String fileName = (String) exchange.getIn().getHeader("CamelFileName");
		if (fileName.startsWith("BDM"))
			repository.save(converter.createFileEvent("Validation failed",exchange));
		else
			repository.save(converter.createFileEvent("Validation passed",exchange));
		if (fileName.startsWith("BDM"))
			throw new Exception("Validation failed");
	}

}
