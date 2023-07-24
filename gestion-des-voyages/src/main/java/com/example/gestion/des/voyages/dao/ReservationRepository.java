package com.example.gestion.des.voyages.dao;


import com.example.gestion.des.voyages.model.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface ReservationRepository extends JpaRepository<Reservation, Integer> {
}
