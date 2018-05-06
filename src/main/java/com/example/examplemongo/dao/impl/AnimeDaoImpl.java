package com.example.examplemongo.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.examplemongo.dao.AnimeDao;
import com.example.examplemongo.document.AnimeDct;
import com.example.examplemongo.dto.AnimeDto;
import com.example.repository.AnimeRepository;

@Service
public class AnimeDaoImpl implements AnimeDao {

	@Autowired
	private AnimeRepository animeRepository;

	@Override
	public String insertAnime(AnimeDto animeDto) {

		AnimeDct animeDct = new AnimeDct();
		animeDct.setName(animeDto.getName());
		animeRepository.insert(animeDct);
		return "0";
	}

	@Override
	public String updateAnime(AnimeDto animeDto) {
		AnimeDct animeDct = new AnimeDct();
		animeDct.setId(animeDto.getId());
		animeDct.setName(animeDto.getName());
		animeRepository.save(animeDct);
		return "0";
	}

	@Override
	public List<AnimeDto> findAll() {
		
		List<AnimeDto> lstAnimeDtos = new ArrayList<>();
		
		for(AnimeDct dct : animeRepository.findAll()) {
			AnimeDto animeDto = new AnimeDto();
			animeDto.setId(dct.getId());
			animeDto.setName(dct.getName());
			lstAnimeDtos.add(animeDto);
			
		}
		
		return lstAnimeDtos;
	}

	@Override
	public void deleteAnime(String animeId) {
		animeRepository.deleteById(animeId);
	}

}
