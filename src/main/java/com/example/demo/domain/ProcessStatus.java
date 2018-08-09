package com.example.demo.domain;

import java.io.Serializable;
import java.time.LocalDate;

import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyClass;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.core.mapping.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Table(value = "process_status")
@Data
@NoArgsConstructor
public class ProcessStatus {
	
	@PrimaryKeyClass
	@Data
	public class Key implements Serializable {
		
		@PrimaryKeyColumn(name ="year", ordinal=0 , type = PrimaryKeyType.PARTITIONED)
		private String year;
		@PrimaryKeyColumn(name ="received_date", ordinal=1 , type = PrimaryKeyType.CLUSTERED)
		private LocalDate receivedDate;
		@PrimaryKeyColumn(name ="file_name", ordinal=2 , type = PrimaryKeyType.CLUSTERED)
		private String fileName;
	}
	
	@PrimaryKey
	private Key key;
	
	@Column(value = "file_type")
	private String fileType;
	
	@Column(value = "file_size")
	private String fileSize;
	
	@Column(value = "status")
	private String status;
	
	@Column(value = "status_date")
	private LocalDate statusDate;
	
	@Column(value = "archive_location")
	private String archiveLocation;
	
	@Column(value = "parent_file")
	private String parentFile;
	
	@Column(value = "dm6_verified")
	private String DM6Verified;
}
