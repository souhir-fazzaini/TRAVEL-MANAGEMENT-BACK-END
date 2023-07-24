package com.example.gestion.des.voyages.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.*;

import java.util.List;
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="utilisateur")
public class Utilisateur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int id;
    private String nom;
    private String prenom;
    private String email;
    private String mot_de_passe;
    private String adresse;
    private int num_telephone;
    @OneToMany(mappedBy = "utilisateur")
    private List<Voyage> Voyages;

}
