package com.example.demo.component;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.repository.CaseDetail2Repository;
import com.example.demo.repository.EventDateRepository;
import com.example.demo.repository.FileEventRepository;
import com.example.demo.repository.FileWorkflowItemRepository;
import com.example.demo.utils.CaseDetail2Converter;
import com.example.demo.utils.EventDateConverter;
import com.example.demo.utils.FileEventConverter;
import com.example.demo.utils.FileWorkflowItemConverter;

@Component
public class RecordProcessor implements Processor {

	@Autowired
	FileEventConverter converter;
	
	@Autowired
	EventDateConverter eventDateConverter;
	
	@Autowired
	FileWorkflowItemConverter fileWorkflowItemConverter;
	
	@Autowired
	CaseDetail2Converter caseDetail2Converter;
	
	@Autowired
	FileEventRepository repository;
	
	@Autowired
	EventDateRepository eventDateRepository;
	
	@Autowired
	FileWorkflowItemRepository fileWorkflowItemRepository;
	
	@Autowired
	CaseDetail2Repository caseDetail2Repository;

	@Override
	public void process(Exchange exchange) throws Exception {
		
		repository.save(converter.createFileEvent("Reading record",exchange));
		eventDateRepository.save(eventDateConverter.createEventDate(exchange));
		repository.save(converter.createFileEvent("Updated event table",exchange));
		fileWorkflowItemRepository.save(fileWorkflowItemConverter.createWorkflowItem("VISA", exchange));
		repository.save(converter.createFileEvent("Processing record",exchange));
		caseDetail2Repository.save(caseDetail2Converter.createCaseDetail2(exchange));
		repository.save(converter.createFileEvent("Completed processing record",exchange));
	}

}
