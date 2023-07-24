package com.example.gestion.des.voyages.dto;

import com.example.gestion.des.voyages.model.Passager;
import com.example.gestion.des.voyages.model.Reservation;
import lombok.Builder;

@Builder
public class passagerdto {
    private Long id;

    private Reservation reservation;

    private String nom;

    private String prénom;

    private int num_de_passeport;

    private String date_de_naissance;
    public passagerdto fromEntity(Passager passager)
    {
        if(passager == null)
        {
            return null;
        }
        return passagerdto.builder()
                .id(passager.getId())
                .nom(passager.getNom())
                .prénom(passager.getPrénom())
                .num_de_passeport(passager.getNum_de_passeport())
                .date_de_naissance(passager.getDate_de_naissance())
                .build();



    }
    public Reservation toEntity(Reservationdto reservationdto)
    {
        if(reservationdto == null)
        {
            return null;
        }
        Reservation reservation = new Reservation();
        reservation.setId(reservation.getId());
        reservation.setDate(reservation.getDate());
        reservation.setNbre_personne(reservation.getNbre_personne());
        return reservation;

    }

}
