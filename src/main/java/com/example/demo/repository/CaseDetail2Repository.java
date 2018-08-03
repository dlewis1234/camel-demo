package com.example.demo.repository;

import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.domain.CaseDetail2;

@Repository
public interface CaseDetail2Repository extends CassandraRepository<CaseDetail2,CaseDetail2.Key> {

}
