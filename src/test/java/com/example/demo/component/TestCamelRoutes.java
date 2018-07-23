package com.example.demo.component;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.stereotype.Component;

@Component
public class TestCamelRoutes extends RouteBuilder {

	@Override
	public void configure() throws Exception {
		from("direct:sftpFile").id("sftpFiles").to("mock:sftpFiles");
		
	}

}
