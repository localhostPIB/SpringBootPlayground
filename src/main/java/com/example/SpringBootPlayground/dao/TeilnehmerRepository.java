package com.example.SpringBootPlayground.dao;


import com.example.SpringBootPlayground.model.classes.Teilnehmer;
import com.example.SpringBootPlayground.model.interfaces.ITeilnehmer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeilnehmerRepository extends CrudRepository<Teilnehmer, Integer> {
    Teilnehmer findTeilnehmerById(Integer id);
}
