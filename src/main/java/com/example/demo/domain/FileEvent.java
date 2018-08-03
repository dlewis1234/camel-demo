package com.example.demo.domain;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.CassandraType;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyClass;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.core.mapping.Table;


import com.datastax.driver.core.DataType.Name;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(value = "file_event") @Data @NoArgsConstructor 
public class FileEvent {
	
	@PrimaryKeyClass @Data @AllArgsConstructor
	public class Key implements Serializable {
		@PrimaryKeyColumn(name = "file_name", ordinal = 0, type = PrimaryKeyType.PARTITIONED)
		private String fileName;
		@PrimaryKeyColumn(name = "event_type", ordinal = 1, type = PrimaryKeyType.CLUSTERED)
		private String eventType;
		@PrimaryKeyColumn(name = "event_date", ordinal = 2, type = PrimaryKeyType.CLUSTERED)
		private LocalDate eventDate;
		@PrimaryKeyColumn(name = "event_time", ordinal = 3, type = PrimaryKeyType.CLUSTERED) 
		@CassandraType(type = Name.TIME)
	    private LocalTime localTime;
		
	}
	
	@PrimaryKey
	private Key key;
}
