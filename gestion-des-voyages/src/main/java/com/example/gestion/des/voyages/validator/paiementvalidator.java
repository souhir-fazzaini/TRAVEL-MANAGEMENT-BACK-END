package com.example.gestion.des.voyages.validator;

import com.example.gestion.des.voyages.dto.Paiementdto;

import java.util.ArrayList;
import java.util.List;

public class paiementvalidator {
    public static List<String> validate(Paiementdto paiementdto)
    {
        List<String> errors = new ArrayList<>();
        if(paiementdto.getMontant()==0)
        {
            errors.add("veuiller saisir le montant");
        }
        if(paiementdto.getMethode_de_montant()==null)
        {
            errors.add("veuiller saisir la methode de paiement");
        }
        if(paiementdto.getDate_paiement()==null)
        {
            errors.add("veuiller saisir la date de paiement");
        }
        if(paiementdto.getStatut()==null)
        {
            errors.add("veuiller saisir le statut");
        }
        return errors;
    }
}
