package com.example.SpringBootPlayground.dao;

import com.example.SpringBootPlayground.model.classes.Geschlecht;
import org.springframework.data.repository.CrudRepository;

public interface GeschlechtRepository extends CrudRepository<Geschlecht, Integer> {
}
