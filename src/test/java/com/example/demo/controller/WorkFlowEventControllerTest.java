package com.example.demo.controller;

import static org.mockito.Mockito.when;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.payload.PayloadDocumentation.fieldWithPath;
import static org.springframework.restdocs.payload.PayloadDocumentation.responseFields;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.example.demo.domain.WorkflowEvent;
import com.example.demo.service.WorkFlowEventService;

@RunWith(SpringRunner.class)
@WebMvcTest(WorkflowEventController.class)
@AutoConfigureRestDocs(outputDir = "target/generated-snippets")
public class WorkFlowEventControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	WorkFlowEventService service;
	
	@Before
	public void setup() {
		List<WorkflowEvent> events = new ArrayList<WorkflowEvent>();
		WorkflowEvent event = new WorkflowEvent();
		event.setId(UUID.randomUUID());
		event.setEventDate(new Date());
		event.setEventType("Extract Data Files");
		event.setFileName("DDM56P00");
		events.add(event);
		event = new WorkflowEvent();
		event.setId(UUID.randomUUID());
		event.setEventDate(new Date());
		event.setEventType("Processing record");
		event.setRecordId("1050200752");
		//events.add(event);
		when(service.findAll()).thenReturn(events);
	}
	
	@Test
	public void testList() throws Exception {
		this.mockMvc.perform(get("/events")).andDo(document("events-list",responseFields(fieldWithPath("[].id").description("Record identifier"),fieldWithPath("[].eventType").description("A description of the event"),fieldWithPath("[].fileName").description("The name of the file the event occured on"),fieldWithPath("[].recordId").description("The record the event occured on"),fieldWithPath("[].eventDate").description("When the event occured"))));
	}

}
