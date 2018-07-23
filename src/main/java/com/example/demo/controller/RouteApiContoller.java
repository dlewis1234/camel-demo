package com.example.demo.controller;

import org.apache.camel.CamelContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.RouteListResponse;
import com.example.demo.model.RouteResponse;

@RestController
@RequestMapping("/routes")
public class RouteApiContoller {
	
	@Autowired
	CamelContext camelContext;
	
	@GetMapping(produces=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody RouteListResponse listRoutes() {
		RouteListResponse response = new RouteListResponse();
		camelContext.getRoutes().stream().forEach(r -> {
			response.addRouteStatus(r.getId(), camelContext.getRouteStatus(r.getId()).toString());
		});
		return response;
	}
	
	@GetMapping(path="/start/{id}", produces=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody RouteResponse startRoute(@PathVariable String id) {
		try {
			camelContext.startRoute(id);
			return new RouteResponse(id,"started successfully");
		} catch (Exception e) {
			return new RouteResponse(id,"failed to start");
		}
	}
	
	@GetMapping(path="/stop/{id}", produces=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody RouteResponse stopRoute(@PathVariable String id) {
		try {
			camelContext.stopRoute(id);
			return new RouteResponse(id,"stopped successfully");
		} catch (Exception e) {
			return new RouteResponse(id,"failed to stop");
		}
	}
	
	

}
