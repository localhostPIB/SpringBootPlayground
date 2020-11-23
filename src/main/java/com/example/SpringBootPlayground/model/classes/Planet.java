package com.example.SpringBootPlayground.model.classes;

import lombok.*;
import org.bson.types.Binary;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Data
@Document
public class Planet {

   @Id
   private String id;

   private String name;

   private Binary image;

   public Planet(String name){
       this.name = name;
   }
}
