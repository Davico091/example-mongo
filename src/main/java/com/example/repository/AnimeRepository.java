package com.example.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.example.examplemongo.document.AnimeDct;

@Repository
public interface AnimeRepository extends MongoRepository<AnimeDct, String> {

}
