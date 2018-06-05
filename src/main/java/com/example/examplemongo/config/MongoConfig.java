package com.example.examplemongo.config;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.example.examplemongo.dto.Bank;
import com.google.common.collect.Lists;
import com.mongodb.MongoClient;

@Configuration
@EnableMongoRepositories(basePackages="com.example.repository")
public class MongoConfig extends AbstractMongoConfiguration  {

	@Value( "${com.example.database.name}" )
	private String databaseName;
	
	@Value( "${com.example.database.host}" )
	private String host;
	
	@Override
	public MongoClient mongoClient() {
		MongoClient mongoClient = new MongoClient(host,27017);
		return mongoClient;
	}

	@Override
	protected String getDatabaseName() {
		// TODO Auto-generated method stub
		return databaseName;
	}
	
	
	public static void main(String[] args) {
		
		List<Bank> bancos = new ArrayList<>();
		List<Bank> noPermitidos = new ArrayList<>();
		
		Bank n1 = new Bank();
		n1.setIdBanco(1);
		n1.setDescription("banco1");
		noPermitidos.add(n1);
		
		Bank n2 = new Bank();
		n2.setIdBanco(2);
		n2.setDescription("banco2");
		noPermitidos.add(n2);
	
		
		Bank b1 = new Bank();
		b1.setIdBanco(1);
		b1.setDescription("banco1");
		bancos.add(b1);
		
		Bank b2 = new Bank();
		b2.setIdBanco(2);
		b2.setDescription("banco2");
		bancos.add(b2);
		
		Bank b3 = new Bank();
		b3.setIdBanco(3);
		b3.setDescription("banco3");
		bancos.add(b3);
		
		Bank b4 = new Bank();
		b4.setIdBanco(4);
		b4.setDescription("banco4");
		bancos.add(b4);
		
		Bank b5 = new Bank();
		b5.setIdBanco(5);
		b5.setDescription("banco5");
		bancos.add(b5);
		
		Bank b6 = new Bank();
		b6.setIdBanco(6);
		b6.setDescription("banco6");
		bancos.add(b6);
		
		ListIterator<Bank> iter = bancos.listIterator();
		System.out.println(bancos.size());

		while (iter.hasNext()) {
			if(validateElement(iter.next().getIdBanco(),noPermitidos)) {
				iter.remove();
			}
			
		}
		
		System.out.println(bancos.size());
		
	
		
	}

	private static boolean validateElement(int idBanco,List<Bank> nop) {
		
		for(Bank lst : nop) {
			if(lst.getIdBanco()==idBanco) {
				System.out.println(lst.getDescription() + "se quito ");
				return true;
			}
		}
		
		return false;
	}

}
