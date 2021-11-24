package com.example.Anime.Repo;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.Anime.Modelo.Anime;

public interface AnimeRepository extends MongoRepository<Anime, String>{

}
