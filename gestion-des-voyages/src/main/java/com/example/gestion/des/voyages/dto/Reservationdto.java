package com.example.gestion.des.voyages.dto;

import com.example.gestion.des.voyages.model.*;
import lombok.Builder;
import lombok.Data;
import lombok.NonNull;

import java.util.Date;
import java.util.List;
@Data
@Builder
public class Reservationdto {
    @NonNull
    private Long  id ;

    private Voyage voyage;

    private List<Passager> Passagers;
    @NonNull
    private Date date ;
    private int nbre_personne;
    private Paiement paiement_id;
    public static Reservationdto fromEntity(Reservation reservation)
    {
        if(reservation == null)
        {
            return null;
        }
        return Reservationdto.builder()
                .id(reservation.getId())
                .date(reservation.getDate())
                .nbre_personne(reservation.getNbre_personne())
                .build();


    }
    public static Reservation toEntity(Reservationdto reservationdto)
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
