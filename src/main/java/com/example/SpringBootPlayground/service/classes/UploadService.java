package com.example.SpringBootPlayground.service.classes;

import com.example.SpringBootPlayground.dao.PlanetRepository;
import com.example.SpringBootPlayground.model.classes.Planet;

import org.bson.BsonBinarySubType;
import org.bson.types.Binary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.gridfs.*;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class UploadService {
    @Autowired
    private GridFsTemplate gridFsTemplate;

    @Autowired
    private GridFsOperations operations;

    @Autowired
    private PlanetRepository planetRepository;


    public void addPhoto (String title, MultipartFile file, Planet planet) throws IOException {
        planet.setImage(new Binary(BsonBinarySubType.BINARY, file.getBytes()));
       // planet = planetRepository.insert(planet);
        }



}
