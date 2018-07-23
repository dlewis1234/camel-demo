package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.domain.WorkflowEvent;
import com.example.demo.repository.WorkflowEventRepository;

@Service
public class WorkFlowEventService {
	
	@Autowired
	WorkflowEventRepository repository;
	
	public WorkflowEvent save(WorkflowEvent event) {
		
		return repository.save(event);
	}
	
	public Iterable<WorkflowEvent> findAll() {
		return repository.findAll();
	}
}
