package com.example.demo.domain;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.CassandraType;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyClass;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.core.mapping.Table;

import com.datastax.driver.core.DataType.Name;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(value = "file_workflow_item") @Data @NoArgsConstructor 
public class FileWorkflowItem {
	
	@PrimaryKeyClass @Data @AllArgsConstructor
	public class Key implements Serializable {
		@PrimaryKeyColumn(name = "case_id", ordinal = 0, type = PrimaryKeyType.PARTITIONED)
		private String caseId;
		@PrimaryKeyColumn(name = "record_type", ordinal = 1, type = PrimaryKeyType.CLUSTERED)
		private String recordType;
		@PrimaryKeyColumn(name = "create_date", ordinal = 2, type = PrimaryKeyType.CLUSTERED)
		private LocalDate createDate;
		@PrimaryKeyColumn(name = "create_time", ordinal = 3, type = PrimaryKeyType.CLUSTERED) 
		@CassandraType(type = Name.TIME)
	    private LocalTime createTime;
	}
	
	@PrimaryKey
	private Key key;
	
	@Column(value="file_name")
	private String fileName;
	
	@Column(value="file_type")
	private String fileType;
	
	@Column(value="card_company")
    private String cardCompany;
	
	@Column(value="record_transaction_id")
	private String recordTransactionId;
    
	@Column(value="record_case_id")
    private String recordCaseId;
	
	@Column(value="secure_archive_key")
    private String secureArchiveKey;
}
