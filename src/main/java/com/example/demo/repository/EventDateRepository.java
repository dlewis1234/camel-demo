package com.example.demo.repository;

import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.domain.EventDate;

@Repository
public interface EventDateRepository extends CassandraRepository<EventDate,EventDate.Key> {

}
