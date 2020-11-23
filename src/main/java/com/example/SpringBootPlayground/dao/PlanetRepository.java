package com.example.SpringBootPlayground.dao;

import com.example.SpringBootPlayground.model.classes.Planet;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface PlanetRepository extends MongoRepository<Planet, String> {
    Planet findPlanetById(String id);
}
