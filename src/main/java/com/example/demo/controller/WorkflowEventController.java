package com.example.demo.controller;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.WorkflowEvent;
import com.example.demo.service.WorkFlowEventService;

@RestController
@RequestMapping("/events")
public class WorkflowEventController {

	@Autowired
	WorkFlowEventService service;

	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<WorkflowEvent> listEvents() {
		Iterable<WorkflowEvent> events = service.findAll();
		return StreamSupport.stream(events.spliterator(), false)
				.sorted((e1, e2) -> e1.getEventDate().compareTo(e2.getEventDate())).collect(Collectors.toList());
	}

}
