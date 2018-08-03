package com.example.demo.repository;

import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.domain.FileEvent;

@Repository
public interface FileEventRepository extends CassandraRepository<FileEvent,FileEvent.Key>{

}
