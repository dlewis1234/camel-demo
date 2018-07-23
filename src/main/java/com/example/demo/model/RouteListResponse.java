package com.example.demo.model;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class RouteListResponse {
	private List<RouteStatus> response;
	
	public RouteListResponse() {
		response = new ArrayList<RouteStatus>();
	}
	
	public void addRouteStatus(String name,String status) {
		response.add(new RouteStatus(name,status));
	}
}
