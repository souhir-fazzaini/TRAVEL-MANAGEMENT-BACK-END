package com.example.gestion.des.voyages.dao;

import com.example.gestion.des.voyages.model.Voyage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VoyageRepository extends JpaRepository<Voyage, Integer> {

    List<Voyage> findByDestination(String destination);
    Voyage findById(int id);

}
