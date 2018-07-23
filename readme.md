# Spring Boot Camel Demo

This project is an example of using Apache Camel along with Spring Boot to accomplish Enterprise Integration Tasks

## Getting Started

This project is built using Maven.  To build mvn clean package.  The camel.properties file contains a the directory path to monitor on the local machine.

### Prerequisites

This project requires Java 1.8+

### Running

This project expects a local Apache Cassandra.  The easiest way to do that is docker run --name cass1 -p 7000-7001:7000-7001 -p 7199:7199 -p 9042:9042 -p 9160:9160  cassandra

