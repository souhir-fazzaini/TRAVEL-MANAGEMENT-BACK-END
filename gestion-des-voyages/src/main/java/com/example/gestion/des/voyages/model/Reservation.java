package com.example.gestion.des.voyages.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.*;
import java.util.Date;
import java.util.List;
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="reservation")
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long   id ;
    @ManyToOne
    @JoinColumn(name = "voyage_id")
    private Voyage voyage;
    @OneToMany(mappedBy = "reservation",fetch=FetchType.LAZY)
    private List<Passager> Passagers;
    private Date date ;
   private int nbre_personne; //TODO fix it
   private Statut statut;
/*    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "paiement")
    private Paiement paiement_id;*/
    // zayda normalment : unidirectional TODO zid a3ml 3liha recherche b3d
}
