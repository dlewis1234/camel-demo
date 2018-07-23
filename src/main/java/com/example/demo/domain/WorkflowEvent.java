package com.example.demo.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table @Data @NoArgsConstructor @AllArgsConstructor
public class WorkflowEvent implements Serializable{
	
	@PrimaryKey
    private UUID id;
	private String eventType;
	private String fileName;
	private String recordId;
	private Date eventDate;

}
