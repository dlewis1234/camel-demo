package com.example.demo.controller;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.FileEvent;
import com.example.demo.repository.FileEventRepository;

@RestController
@RequestMapping("/events")
public class WorkflowEventController {

	@Autowired
	FileEventRepository repository;

	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<FileEvent> listEvents() {
		Iterable<FileEvent> events = repository.findAll();
		return StreamSupport.stream(events.spliterator(), false)
				.sorted((e1, e2) -> e1.getKey().getEventDate().compareTo(e2.getKey().getEventDate())).collect(Collectors.toList());
	}

}
