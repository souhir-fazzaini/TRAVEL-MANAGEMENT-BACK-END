package com.example.gestion.des.voyages.services;

import com.example.gestion.des.voyages.dto.Reservationdto;
import com.example.gestion.des.voyages.model.Reservation;

import java.util.List;

public interface Reservationservice {
    Reservationdto save(Reservationdto dto);
    Reservation findById(Integer id);



    List<Reservationdto> findAll();
    void delete(Integer id);
}
