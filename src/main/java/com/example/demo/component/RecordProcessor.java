package com.example.demo.component;

import java.util.Random;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.domain.ProcessStatusDetail;
import com.example.demo.repository.CaseDetail2Repository;
import com.example.demo.repository.EventDateRepository;
import com.example.demo.repository.FileEventRepository;
import com.example.demo.repository.FileWorkflowItemRepository;
import com.example.demo.repository.ProcessStatusDetailRepository;
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

	@Autowired
	ProcessStatusDetailRepository processStatusDetailRepository;

	@Override
	public void process(Exchange exchange) throws Exception {
		int type = new Random().nextInt(4);
		switch (type) {
		case 0:
			processStatusDetailRepository.updateRecordCount((String) exchange.getIn().getHeader("CamelFileName"),
					"Pre-Arb");
			processStatusDetailRepository.updateValidatedCount((String) exchange.getIn().getHeader("CamelFileName"),
					"Pre-Arb");
			int report = new Random().nextInt(5);
			switch (report) {
			case 0:
				processStatusDetailRepository.update64Included((String) exchange.getIn().getHeader("CamelFileName"),
						"Pre-Arb");
				break;
			case 1:
				processStatusDetailRepository.update117Included((String) exchange.getIn().getHeader("CamelFileName"),
						"Pre-Arb");
				break;
			case 2:
				processStatusDetailRepository.update119Included((String) exchange.getIn().getHeader("CamelFileName"),
						"Pre-Arb");
				break;
			case 3:
				processStatusDetailRepository.update471Included((String) exchange.getIn().getHeader("CamelFileName"),
						"Pre-Arb");
				break;
			case 4:
				processStatusDetailRepository.update885Included((String) exchange.getIn().getHeader("CamelFileName"),
						"Pre-Arb");
				break;
			}
			break;
		case 1:
			processStatusDetailRepository.updateRecordCount((String) exchange.getIn().getHeader("CamelFileName"),
					"Dispute Response");
			processStatusDetailRepository.updateValidatedCount((String) exchange.getIn().getHeader("CamelFileName"),
					"Dispute Response");
			report = new Random().nextInt(5);
			switch (report) {
			case 0:
				processStatusDetailRepository.update64Included((String) exchange.getIn().getHeader("CamelFileName"),
						"Dispute Response");
				break;
			case 1:
				processStatusDetailRepository.update117Included((String) exchange.getIn().getHeader("CamelFileName"),
						"Dispute Response");
				break;
			case 2:
				processStatusDetailRepository.update119Included((String) exchange.getIn().getHeader("CamelFileName"),
						"Dispute Response");
				break;
			case 3:
				processStatusDetailRepository.update471Included((String) exchange.getIn().getHeader("CamelFileName"),
						"Dispute Response");
				break;
			case 4:
				processStatusDetailRepository.update885Included((String) exchange.getIn().getHeader("CamelFileName"),
						"Dispute Response");
				break;
			}
			break;
		case 2:
			processStatusDetailRepository.updateRecordCount((String) exchange.getIn().getHeader("CamelFileName"),
					"Dispute Response (Full)");
			processStatusDetailRepository.updateValidatedCount((String) exchange.getIn().getHeader("CamelFileName"),
					"Dispute Response (Full)");
			report = new Random().nextInt(5);
			switch (report) {
			case 0:
				processStatusDetailRepository.update64Included((String) exchange.getIn().getHeader("CamelFileName"),
						"Dispute Response (Full)");
				break;
			case 1:
				processStatusDetailRepository.update117Included((String) exchange.getIn().getHeader("CamelFileName"),
						"Dispute Response (Full)");
				break;
			case 2:
				processStatusDetailRepository.update119Included((String) exchange.getIn().getHeader("CamelFileName"),
						"Dispute Response (Full)");
				break;
			case 3:
				processStatusDetailRepository.update471Included((String) exchange.getIn().getHeader("CamelFileName"),
						"Dispute Response (Full)");
				break;
			case 4:
				processStatusDetailRepository.update885Included((String) exchange.getIn().getHeader("CamelFileName"),
						"Dispute Response (Full)");
				break;
			}
			break;
		case 3:
			processStatusDetailRepository.updateRecordCount((String) exchange.getIn().getHeader("CamelFileName"),
					"Other");
			processStatusDetailRepository.updateUnprocessed((String) exchange.getIn().getHeader("CamelFileName"),
					"Other");
			break;
			
		}

		repository.save(converter.createFileEvent("Reading record", exchange));
		eventDateRepository.save(eventDateConverter.createEventDate(exchange));
		repository.save(converter.createFileEvent("Updated event table", exchange));
		fileWorkflowItemRepository.save(fileWorkflowItemConverter.createWorkflowItem("VISA", exchange));
		repository.save(converter.createFileEvent("Processing record", exchange));
		caseDetail2Repository.save(caseDetail2Converter.createCaseDetail2(exchange));
		repository.save(converter.createFileEvent("Completed processing record", exchange));
	}

}
