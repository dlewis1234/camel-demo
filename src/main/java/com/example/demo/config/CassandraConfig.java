package com.example.demo.config;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.BeanClassLoaderAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.cassandra.config.AbstractCassandraConfiguration;
import org.springframework.data.cassandra.config.CassandraClusterFactoryBean;
import org.springframework.data.cassandra.config.SchemaAction;
import org.springframework.data.cassandra.core.cql.keyspace.CreateKeyspaceSpecification;
import org.springframework.data.cassandra.core.cql.keyspace.DropKeyspaceSpecification;

@Configuration
public class CassandraConfig extends AbstractCassandraConfiguration implements BeanClassLoaderAware{

	public static final String KEYSPACE = "casemgmt_9999";

	@Override
    public SchemaAction getSchemaAction() {
        return SchemaAction.RECREATE;
    }

    @Override
    protected List<CreateKeyspaceSpecification> getKeyspaceCreations() {
        CreateKeyspaceSpecification specification = CreateKeyspaceSpecification.createKeyspace(KEYSPACE);

        return Arrays.asList(specification);
    }
    
    @Override
    public String getContactPoints() {
        return "localhost";
      }
    
    @Override
    protected List<DropKeyspaceSpecification> getKeyspaceDrops() {
        return Arrays.asList(DropKeyspaceSpecification.dropKeyspace(KEYSPACE));
    }

    @Override
    protected String getKeyspaceName() {
        return KEYSPACE;
    }
    

    @Override
    public String[] getEntityBasePackages() {
        return new String[]{"com.example.demo.domain"};
    }

}
