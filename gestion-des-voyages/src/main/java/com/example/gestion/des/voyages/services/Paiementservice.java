package com.example.gestion.des.voyages.services;

import com.example.gestion.des.voyages.dto.Paiementdto;
import com.example.gestion.des.voyages.model.Paiement;

import java.util.List;

public interface Paiementservice {
    Paiementdto save(Paiementdto dto);
    Paiement findById(Integer id);



    List<Paiementdto> findAll();
    void delete(Integer id);
}
