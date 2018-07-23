package com.example.demo.controller;

import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.payload.PayloadDocumentation.fieldWithPath;
import static org.springframework.restdocs.payload.PayloadDocumentation.responseFields;
import static org.springframework.restdocs.request.RequestDocumentation.parameterWithName;
import static org.springframework.restdocs.request.RequestDocumentation.pathParameters;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import org.apache.camel.CamelContext;
import org.apache.camel.impl.DefaultCamelContext;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.example.demo.component.TestCamelRoutes;
import com.example.demo.controller.RouteApiContoller;

@RunWith(SpringRunner.class)
@WebMvcTest(RouteApiContoller.class)
@AutoConfigureRestDocs(outputDir = "target/generated-snippets")
public class RouteApiControllerTest {
	
		@TestConfiguration
		static class RouteApiControllerTestConfiguration {
	        
	      
	        
	        @Bean
	        public CamelContext camelContext() {
	        	CamelContext context = new DefaultCamelContext();
	        	try {
					context.addRoutes(new TestCamelRoutes());
					context.start();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	        	return context;
	        }
	    }
		
		@Autowired
		private MockMvc mockMvc;
		
		@Autowired
		CamelContext camelContext;
		
		@Before
		public void setup() throws Exception {
			
		}
		
		@Test
		public void testList() throws Exception {
			this.mockMvc.perform(get("/routes")).andDo(document("routes-list",responseFields(fieldWithPath("response[].routeName").description("The Camel route identifier"),fieldWithPath("response[].routeStatus").description("The status of the Camel route"))));
		}
		
		@Test
		public void testStart() throws Exception {
			camelContext.stopRoute("sftpFiles");
			this.mockMvc.perform(RestDocumentationRequestBuilders.get("/routes/start/{id}","sftpFiles")).andDo(document("routes-start", pathParameters(parameterWithName("id").description("The Camel route identifier")),responseFields(fieldWithPath("routeName").description("The Camel route identifier"),fieldWithPath("message").description("The response from Camel"))));
		}
		
		@Test
		public void testStop() throws Exception {
			this.mockMvc.perform(RestDocumentationRequestBuilders.get("/routes/stop/{id}","sftpFiles")).andDo(document("routes-stop", pathParameters(parameterWithName("id").description("The Camel route identifier")),responseFields(fieldWithPath("routeName").description("The Camel route identifier"),fieldWithPath("message").description("The response from Camel"))));
		}
}
