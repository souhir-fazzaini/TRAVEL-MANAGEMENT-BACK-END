package com.example.gestion.des.voyages.dto;

import com.example.gestion.des.voyages.model.Utilisateur;
import lombok.Builder;
import lombok.Data;

import java.util.List;
@Data
@Builder
public class utilisateurdto {

    private Integer id;
    private String nom;
    private String prenom;
    private String email;
    private String mot_de_passe;
    private String adresse;
    private Integer num_telephone;

    private List<Voyagedto> voyages;

    public utilisateurdto fromEntity(Utilisateur utilisateur)
    {
        if(utilisateur == null)
        {
            return null;
        }
        return utilisateurdto.builder()
                .id(utilisateur.getId())
                .nom(utilisateur.getNom())
                .prenom(utilisateur.getPrenom())
                .email(utilisateur.getEmail())
                .mot_de_passe(utilisateur.getMot_de_passe())
                .adresse(utilisateur.getAdresse())
                .num_telephone(utilisateur.getNum_telephone())
                .build();




    }
    public Utilisateur toEntity(utilisateurdto utilisateurdto)
    {
        if(utilisateurdto == null)
        {
            return null;
        }
        Utilisateur utilisateur = new Utilisateur();
        utilisateur.setId(utilisateur.getId());
        utilisateur.setNom(utilisateur.getNom());
        utilisateur.setPrenom(utilisateur.getPrenom());
        utilisateur.setEmail(utilisateur.getEmail());
        utilisateur.setMot_de_passe(utilisateur.getMot_de_passe());
        utilisateur.setAdresse(utilisateur.getAdresse());
        utilisateur.setNum_telephone(utilisateur.getNum_telephone());
        return utilisateur;


    }


}

