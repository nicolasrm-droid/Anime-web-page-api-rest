package com.example.Anime.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.Anime.Modelo.Anime;
import com.example.Anime.Repo.AnimeRepository;

@CrossOrigin
@RestController
@RequestMapping("/animes")
public class AnimeController {

	@Autowired
	private AnimeRepository animeRepository;

	@GetMapping("")

	List<Anime> index(){
		return animeRepository.findAll();

	}

	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping("")
	Anime create(@RequestBody Anime anime){
		return animeRepository.save(anime);

	}
	
	@PutMapping("/{id}")
	Anime update(@PathVariable String id,@RequestBody  Anime anime) {
		Anime animeFromDb = animeRepository
				.findById(id)
				.orElseThrow(RuntimeException::new);
		
		animeFromDb.setNombre(anime.getNombre());
		animeFromDb.setPartes(anime.getPartes());
		animeFromDb.setLugar(anime.getLugar());
		animeFromDb.setDemonio(anime.getDemonio());
				
		return animeRepository.save(animeFromDb);

	}
	
	@ResponseStatus(HttpStatus.NO_CONTENT)	
	@DeleteMapping("/{id}")
	void delete(@PathVariable String id) {
		Anime anime = animeRepository
				.findById(id)
				.orElseThrow(RuntimeException::new);
		
		animeRepository.delete(anime);
		
		
		
	}

}
