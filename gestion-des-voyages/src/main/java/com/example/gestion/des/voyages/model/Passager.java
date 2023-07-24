package com.example.gestion.des.voyages.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.*;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="passager")
public class Passager {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id; //3oud 7oteha Long 5ir
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "reservation_id")
    private Reservation reservation;
    @Column(name = "nom")
    private String nom;
    @Column(name = "prenom")
     private String prénom;
    @Column(name = "num_de_passeport")
    private int num_de_passeport;
    @Column(name = "date_de_naissance")
   private String date_de_naissance; //hadhem tbadelhom kima 9otli : ay attribut yelzm yabda b minuscule TODO fix _ it later
}
