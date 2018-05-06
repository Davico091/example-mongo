package com.example.examplemongo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.examplemongo.dao.AnimeDao;
import com.example.examplemongo.dao.impl.AnimeDaoImpl;
import com.example.examplemongo.document.AnimeDct;
import com.example.examplemongo.dto.AnimeDto;
import com.example.repository.AnimeRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ExampleMongoApplicationTests {

	@Autowired
	AnimeDao animeDao;
	
	@Test
	public void shouldInsertAnime() {
		
		
		AnimeDto animeDto = new AnimeDto();
		animeDto.setName("hunter x hunter");
		animeDao.insertAnime(animeDto);
		
	}
	
	@Test
	public void shouldUpdateAnime() {
		
		
		AnimeDto animeDto = new AnimeDto();
		animeDto.setId("5adc0838aaa80b1b48ead30f");;
		animeDto.setName("Nanatsu no taizai");
		animeDao.updateAnime(animeDto);
		
	}

}
