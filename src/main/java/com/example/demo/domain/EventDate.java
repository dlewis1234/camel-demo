package com.example.demo.domain;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.UUID;

import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.CassandraType;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyClass;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.core.mapping.Table;

import com.datastax.driver.core.DataType.Name;

import lombok.Data;
import lombok.NoArgsConstructor;

@Table(value = "event_date")
@Data
@NoArgsConstructor
public class EventDate {

	@PrimaryKeyClass
	@Data
	public class Key implements Serializable {
		
		public Key(java.time.LocalDate eventDate, LocalTime eventTime, String caseId, UUID eventId) {
			this.eventDate = eventDate;
			this.eventTime = eventTime;
			this.caseId = caseId;
			this.event_id = eventId;
		}

		@PrimaryKeyColumn(name = "event_date", ordinal = 0, type = PrimaryKeyType.PARTITIONED)
		private LocalDate eventDate;
		@PrimaryKeyColumn(name = "event_time", ordinal = 1, type = PrimaryKeyType.CLUSTERED)
		@CassandraType(type = Name.TIME)
		private LocalTime eventTime;
		@PrimaryKeyColumn(name = "case_id", ordinal = 2, type = PrimaryKeyType.CLUSTERED)
		private String caseId;
		@PrimaryKeyColumn(name = "event_id", ordinal = 3, type = PrimaryKeyType.CLUSTERED)
		private UUID event_id;
	};

	@PrimaryKey
	private Key key;

}
