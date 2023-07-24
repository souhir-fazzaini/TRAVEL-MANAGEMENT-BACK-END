package com.example.gestion.des.voyages.validator;

import com.example.gestion.des.voyages.dto.Voyagedto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class voyagevalidator {
    public static List<String> validate(Voyagedto voyagedto)
    {
        List<String> errors = new ArrayList<>();
        if(voyagedto == null || !StringUtils.hasLength(voyagedto.getDestination()))
        {
            errors.add("veuiller saisir la destination");
        }
                return errors;
    }
}
