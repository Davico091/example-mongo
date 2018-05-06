package com.example.examplemongo.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.mongodb.MongoClient;

@Configuration
@EnableMongoRepositories(basePackages="com.example.repository")
public class MongoConfig extends AbstractMongoConfiguration  {

	@Value( "${com.example.database.name}" )
	private String databaseName;
	
	@Override
	public MongoClient mongoClient() {
		MongoClient mongoClient = new MongoClient("127.0.0.1",27017);
		return mongoClient;
	}

	@Override
	protected String getDatabaseName() {
		// TODO Auto-generated method stub
		return databaseName;
	}
	
	

}
