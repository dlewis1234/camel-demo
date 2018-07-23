package com.example.demo.repository;

import java.util.UUID;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.domain.WorkflowEvent;

@Repository
public interface WorkflowEventRepository extends CrudRepository<WorkflowEvent,UUID> {
	
	
}
