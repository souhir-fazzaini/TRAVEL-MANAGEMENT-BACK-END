package com.example.gestion.des.voyages.dto;

import com.example.gestion.des.voyages.model.Paiement;
import com.example.gestion.des.voyages.model.StatutPaiement;
import lombok.Builder;
import lombok.Data;

import java.util.Date;
@Data
@Builder
public class Paiementdto {
    private int id;
    private int montant;
    private String methode_de_montant;
    private Date date_paiement;
    private Paiement reservation_id;
    private StatutPaiement statut;
    public static Paiementdto fromEntity(Paiement paiement)
    {
        if(paiement == null)
        {
            return null;
        }
        return Paiementdto.builder()
                .id(paiement.getId())
                .montant(paiement.getMontant())
                .methode_de_montant(paiement.getMethodeDeMontant())
                .statut(paiement.getStatut())
                .build();



    }
    public static Paiement toEntity(Paiementdto paiementdto)
    {
        if(paiementdto == null)
        {
            return null;
        }
        Paiement paiement = new Paiement();
        paiement.setId(paiement.getId());
        paiement.setMontant(paiement.getMontant());
        paiement.setMethodeDeMontant(paiement.getMethodeDeMontant());
        paiement.setStatut(paiement.getStatut());
        return paiement;

    }
}
