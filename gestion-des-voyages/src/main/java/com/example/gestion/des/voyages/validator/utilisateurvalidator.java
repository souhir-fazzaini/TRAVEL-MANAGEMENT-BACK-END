package com.example.gestion.des.voyages.validator;

import com.example.gestion.des.voyages.dto.utilisateurdto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class utilisateurvalidator {
    public static List<String> validate(utilisateurdto utilisateurdto)
    {
        List<String> errors = new ArrayList<>();

        if(utilisateurdto == null || !StringUtils.hasLength(utilisateurdto.getNom()))
        {
            errors.add("veuiller saisir le nom");
        }
        if(utilisateurdto == null || !StringUtils.hasLength(utilisateurdto.getPrenom()))
        {
            errors.add("veuiller saisir le prenom");
        }
        if(utilisateurdto == null || !StringUtils.hasLength(utilisateurdto.getEmail()))
        {
            errors.add("veuiller saisir l'email");
        }
        if(utilisateurdto == null || !StringUtils.hasLength(utilisateurdto.getMot_de_passe()))
        {
            errors.add("veuiller saisir le mot de passe");
        }
        if(utilisateurdto == null || !StringUtils.hasLength(utilisateurdto.getAdresse()))
        {
            errors.add("veuiller saisir l'adresse");
        }
        if(utilisateurdto.getNum_telephone()==null)
        {
            errors.add("veuiller saisir le numero de telephone");
        }

        return errors;
    }
}
