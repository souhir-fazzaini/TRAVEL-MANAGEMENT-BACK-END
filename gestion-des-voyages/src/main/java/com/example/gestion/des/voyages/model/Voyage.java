package com.example.gestion.des.voyages.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.*;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;
import java.util.List;
@Data

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="voyage")

public class Voyage {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String destination;
    private Date date_debut;
    private Date date_fin;
    private int nbre_place_disponible; //TODO fix it
    private int prix;
   @ManyToOne
    @JoinColumn(name = "user_id")
    private Utilisateur utilisateur;

    public List<Reservation> getReservations() {
        return reservations;
    }

    public void setReservations(List<Reservation> reservations) {
        this.reservations = reservations;
    }

    @OneToMany(mappedBy = "voyage")
   private List<Reservation> reservations;

}
