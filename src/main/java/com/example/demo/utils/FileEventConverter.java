package com.example.demo.utils;

import java.time.LocalDate;
import java.time.LocalTime;

import org.apache.camel.Exchange;
import org.springframework.stereotype.Component;

import com.example.demo.domain.FileEvent;

@Component 
public class FileEventConverter {
	
	public FileEvent createFileEvent(String event,Exchange exchange) {
		FileEvent fileEvent = new FileEvent();
		fileEvent.setKey(fileEvent.new Key((String) exchange.getIn().getHeader("CamelFileName"),event,LocalDate.now(),LocalTime.now()));
		return fileEvent;
	}
}
