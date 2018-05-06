package com.example.examplemongo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.examplemongo.dao.AnimeDao;
import com.example.examplemongo.dto.AnimeDto;

import io.swagger.annotations.Api;
@CrossOrigin(origins = "*")
@Api
@RestController 
public class MainController {

	@Autowired
	AnimeDao animeDao;
	
	@GetMapping(value="/Anime")
	public ResponseEntity<List<AnimeDto>> getAnimes(){
		
		ResponseEntity<List<AnimeDto>> response = new ResponseEntity<List<AnimeDto>>(animeDao.findAll(), HttpStatus.OK);  
		
		return response;
	}
	
	@SuppressWarnings({ "rawtypes", "static-access" })
	@RequestMapping(value="/Anime",method=RequestMethod.POST)
	public ResponseEntity insertAnime(@RequestBody AnimeDto animeDto){
				
		try {
			animeDao.insertAnime(animeDto);
			return new ResponseEntity(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}
	
	@RequestMapping(value="/Anime",method=RequestMethod.PATCH)
	public ResponseEntity updateAnime(@RequestBody AnimeDto animeDto){
				
		try {
			animeDao.updateAnime(animeDto);
			return new ResponseEntity(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}
	
	@RequestMapping(value="/Anime/{animeId}",method=RequestMethod.DELETE)
	public ResponseEntity deleteAnime(@PathVariable String animeId){
				
		try {
			animeDao.deleteAnime(animeId);
			return new ResponseEntity(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}
	
	
}
