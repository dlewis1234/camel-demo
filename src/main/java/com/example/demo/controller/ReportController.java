package com.example.demo.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.WorkflowEvent;
import com.example.demo.service.WorkFlowEventService;

@RestController
@RequestMapping("/reports")
public class ReportController {
	
	@Autowired
	WorkFlowEventService service;
	
	@GetMapping(path="/daily",produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Map<String,String>> getDailyReport() {
		List<Map<String,String>> ret = new ArrayList<Map<String,String>>();
		StreamSupport.stream(service.findAll().spliterator(),false).filter((event) -> event.getEventType().contains("contains")).map(WorkflowEvent::getEventType).forEach(s -> {
			StringTokenizer st = new StringTokenizer(s);
			String b = st.nextToken();
			st.nextToken();
			String c = st.nextToken();
			long c1 = StreamSupport.stream(service.findAll().spliterator(),false).filter((event) -> event.getEventType().matches("Processing record") && event.getFileName().matches(b)).count();
			Map<String,String> batch = new HashMap<String,String>();
			batch.put("file name",b);
			batch.put("received recs", c);
			batch.put("processed recs",String.valueOf(c1));
			ret.add(batch);
		});;
		return ret;
	}

}
