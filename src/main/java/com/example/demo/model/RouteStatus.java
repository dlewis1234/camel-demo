package com.example.demo.model;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter @Setter @RequiredArgsConstructor
public class RouteStatus {
	private @NonNull String routeName;
	private @NonNull String routeStatus;
}
