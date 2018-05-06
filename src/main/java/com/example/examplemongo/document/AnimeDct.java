package com.example.examplemongo.document;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Document(collection="Anime")
public class AnimeDct {

	@Id
	private String id;
	
	private String name;
	
}
