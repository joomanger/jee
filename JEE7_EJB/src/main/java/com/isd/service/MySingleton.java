package com.isd.service;

import javax.annotation.sql.DataSourceDefinition;
import javax.ejb.Singleton;
import javax.ejb.Startup;

@DataSourceDefinition(name = "java:app/datasources/postgresql_ds", 
					  className = "org.postgresql.ds.PGSimpleDataSource", 
					  url = "jdbc:postgresql://localhost:5432/postgres", 
					  user = "postgres", 
					  password = "root")
@Singleton
@Startup
public class MySingleton {

}
