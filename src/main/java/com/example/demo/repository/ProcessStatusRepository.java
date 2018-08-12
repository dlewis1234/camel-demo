package com.example.demo.repository;

import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.domain.ProcessStatus;

@Repository
public interface ProcessStatusRepository extends CassandraRepository<ProcessStatus,ProcessStatus.Key> {

}
