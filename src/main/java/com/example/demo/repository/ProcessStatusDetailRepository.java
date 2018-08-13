package com.example.demo.repository;

import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.cassandra.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.domain.ProcessStatusDetail;

@Repository
public interface ProcessStatusDetailRepository extends CassandraRepository<ProcessStatusDetail,ProcessStatusDetail.Key> {

	@Query("update process_status_detail SET record_count = record_count+1 WHERE file_name = ?0 AND record_type = ?1;")
	Object updateRecordCount(String fileName, String recordType);
	
	@Query("update process_status_detail SET validate_count = validate_count+1 WHERE file_name = ?0 AND record_type = ?1;")
	Object updateValidatedCount(String fileName, String recordType);
	
	@Query("update process_status_detail SET included_119 = included_119+1 WHERE file_name = ?0 AND record_type = ?1;")
	Object update119Included(String fileName, String recordType);
	
	@Query("update process_status_detail SET included_885 = included_885+1 WHERE file_name = ?0 AND record_type = ?1;")
	Object update885Included(String fileName, String recordType);
	
	@Query("update process_status_detail SET included_117 = included_117+1 WHERE file_name = ?0 AND record_type = ?1;")
	Object update117Included(String fileName, String recordType);
	
	@Query("update process_status_detail SET included_64 = included_64+1 WHERE file_name = ?0 AND record_type = ?1;")
	Object update64Included(String fileName, String recordType);
	
	@Query("update process_status_detail SET included_471 = included_471+1 WHERE file_name = ?0 AND record_type = ?1;")
	Object update471Included(String fileName, String recordType);
	
	@Query("update process_status_detail SET unprocessed = unprocessed+1 WHERE file_name = ?0 AND record_type = ?1;")
	Object updateUnprocessed(String fileName, String recordType);
}
