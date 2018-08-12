package com.example.demo.repository;

import java.time.LocalDate;

import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.cassandra.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.domain.ProcessStatusDetail;

@Repository
public interface ProcessStatusDetailRepository extends CassandraRepository<ProcessStatusDetail,ProcessStatusDetail.Key> {

	@Query("update process_status_detaiil SET ?2 = ?2+1 WHERE year = ?0 AND processDate = ?1;")
	Object updateCounterValue(String value1, LocalDate value2, String fieldName);
}
