package com.example.examplemongo.dao;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.examplemongo.dto.AnimeDto;

@Service
public interface AnimeDao {

	public String insertAnime(AnimeDto animeDto);
	public String updateAnime(AnimeDto animeDto);
	public List<AnimeDto> findAll();
	public void deleteAnime(String animeId);
}
