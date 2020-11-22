package com.example.SpringBootPlayground.model.classes;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Getter
@Setter
@ToString
@Document
@AllArgsConstructor
@NoArgsConstructor
public class Planet {

   @Id
   private String id;

   private String name;

   public Planet(String name){
       this.name = name;
   }
}
