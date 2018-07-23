package com.example.demo.component;

import java.util.Date;
import java.util.UUID;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.domain.WorkflowEvent;
import com.example.demo.repository.WorkflowEventRepository;
import com.example.demo.service.WorkFlowEventService;

@Component
public class DataProcessor implements Processor {
	
	@Autowired
	WorkFlowEventService service;

	@Override
	public void process(Exchange exchange) throws Exception {
		String fileName = (String) exchange.getIn().getHeader("CamelFileName");
		WorkflowEvent event = new WorkflowEvent();
		event.setId(UUID.randomUUID());
		event.setEventDate(new Date());
		event.setEventType("Extract Data Files");
		event.setFileName(fileName);
		service.save(event);
	}

}
