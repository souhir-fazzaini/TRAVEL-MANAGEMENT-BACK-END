package com.example.gestion.des.voyages.dto;

import com.example.gestion.des.voyages.model.Reservation;
import com.example.gestion.des.voyages.model.Utilisateur;
import com.example.gestion.des.voyages.model.Voyage;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Voyagedto {
    private int id; /* mademou auto gen me test'ha9ouch fel baathen, ken besh tejbed byh men hne twaly haja okhra*/
    private String destination;
    private Date date_debut;
    private Date date_fin;
    private int nbre_place_disponible;
    private int prix;

    private Utilisateur utilisateur;
@JsonIgnore
@JsonProperty("reservations")
    private List<Reservation> reservations;
    public static Voyagedto fromEntity(@JsonProperty Voyage voyage)
    {
        if(voyage == null)
        {
            return null;
        }
        return Voyagedto.builder()
                .id(voyage.getId())
                .destination(voyage.getDestination())
                .date_debut(voyage.getDate_debut())
                .date_fin(voyage.getDate_fin())
                .nbre_place_disponible(voyage.getNbre_place_disponible())
                .prix(voyage.getPrix())
                .reservations(voyage.getReservations())
                .build();




    }
    public static Voyage toEntity(@JsonProperty Voyagedto voyagedto)
    {
        if(voyagedto == null)
        {
            return null;
        }
       Voyage voyage = new Voyage();
                voyage.setDestination(voyagedto.getDestination());
                voyage.setDate_debut(voyagedto.getDate_debut());
                voyage.setDate_fin(voyagedto.getDate_fin());
                voyage.setNbre_place_disponible(voyagedto.getNbre_place_disponible());
                voyage.setPrix(voyage.getPrix());
                voyage.setReservations(voyage.getReservations());
                return voyage;



    }



}
