package com.example.examplemongo.bdd;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import org.junit.runner.RunWith;

import cucumber.api.java.en.Given;
import org.springframework.http.HttpStatus;

import cucumber.api.CucumberOptions;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/resources")
public class ExampleMongoBdd {
	
	@When("^the client calls /version$")
	public void the_client_get_version() {
		executeGet("");
	}
	

}
