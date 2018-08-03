package com.example.demo.component;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.repository.FileEventRepository;
import com.example.demo.utils.FileEventConverter;

@Component
public class SftpProcessor implements Processor {
	
	@Autowired
	FileEventConverter converter;
	
	@Autowired
	FileEventRepository repository;
	
	@Override
	public void process(Exchange exchange) throws Exception {
		repository.save(converter.createFileEvent("Download and Extract", exchange));
	}

}
