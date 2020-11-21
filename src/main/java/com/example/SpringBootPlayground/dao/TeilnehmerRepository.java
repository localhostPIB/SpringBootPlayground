package com.example.SpringBootPlayground.dao;


import com.example.SpringBootPlayground.model.classes.Teilnehmer;
import org.springframework.data.mongodb.repository.MongoRepository;



public interface TeilnehmerRepository extends MongoRepository<Teilnehmer, String> {
    Teilnehmer findTeilnehmerByEmail(String email);

    Teilnehmer deleteByEmail(String email);
}
