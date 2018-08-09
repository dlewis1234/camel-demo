package com.example.demo.domain;

import java.io.Serializable;

import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.CassandraType;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyClass;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.core.mapping.Table;

import com.datastax.driver.core.DataType.Name;

import lombok.Data;
import lombok.NoArgsConstructor;

@Table(value = "process_status_detail")
@Data
@NoArgsConstructor
public class ProcessStatusDetail {

	@PrimaryKeyClass
	@Data
	public class Key implements Serializable {
		@PrimaryKeyColumn(name ="file_name", ordinal=0 , type = PrimaryKeyType.PARTITIONED)
		private String fileName;
		@PrimaryKeyColumn(name ="record_type", ordinal=1 , type = PrimaryKeyType.CLUSTERED)
		private String recordType;
	}
	
	@PrimaryKey
	private Key key;
	
	@Column(value = "record_count")
	@CassandraType(type=Name.COUNTER)
	private long recordCount;
	
	@Column(value ="validate_count")
	@CassandraType(type=Name.COUNTER)
	private long validateCount;
	
	@Column(value ="included_119")
	@CassandraType(type=Name.COUNTER)
	private long included119;
	
	@Column(value ="included_885")
	@CassandraType(type=Name.COUNTER)
	private long included885;
	
	@Column(value ="included_117")
	@CassandraType(type=Name.COUNTER)
	private long included117;
	
	@Column(value ="included_64")
	@CassandraType(type=Name.COUNTER)
	private long included64;
	
	@Column(value ="included_471")
	@CassandraType(type=Name.COUNTER)
	private long included1471;
	
	@Column(value ="unprocessed")
	@CassandraType(type=Name.COUNTER)
	private long unprocessed;
	
}
