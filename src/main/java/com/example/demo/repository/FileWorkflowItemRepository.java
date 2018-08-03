package com.example.demo.repository;

import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.domain.FileWorkflowItem;

@Repository
public interface FileWorkflowItemRepository extends CassandraRepository<FileWorkflowItem,FileWorkflowItem.Key> {

}
