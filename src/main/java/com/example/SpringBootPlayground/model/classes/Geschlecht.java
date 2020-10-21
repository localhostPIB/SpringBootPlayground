package com.example.SpringBootPlayground.model.classes;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@NoArgsConstructor
public class Geschlecht {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int sexId;

    private String art;
}
