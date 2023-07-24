package com.example.gestion.des.voyages.validator;

import com.example.gestion.des.voyages.dto.Reservationdto;

import java.util.ArrayList;
import java.util.List;

public class reservationvalidator {
    public static List<String> validate(Reservationdto reservationdto)
    {
        List<String> errors = new ArrayList<>();
        if(reservationdto.getDate()==null)
        {
            errors.add("veuiller saisir la date");
        }
        if(reservationdto.getNbre_personne()==0)
        {
            errors.add("veuiller saisir le nombre de personne");
        }
        return errors;
    }
}
