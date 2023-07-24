package com.example.gestion.des.voyages.services;

import com.example.gestion.des.voyages.dto.Voyagedto;
import com.example.gestion.des.voyages.model.Voyage;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;


public interface Voyageservice {
    Voyagedto save(Voyagedto dto);


    Voyage update(Voyagedto dto, @PathVariable int id);

    Voyage findById(Integer id);


    List<Voyage> findByDestination(String destination1);

    List<Voyagedto> findAll();
    void delete(Integer id);

}
