package com.example.gestion.des.voyages.services.impl;

import com.example.gestion.des.voyages.dao.VoyageRepository;
import com.example.gestion.des.voyages.dto.Voyagedto;
import com.example.gestion.des.voyages.execption.EntityNotfoundException;
import com.example.gestion.des.voyages.execption.ErrorCodes;
import com.example.gestion.des.voyages.execption.InvalidEntityException;
import com.example.gestion.des.voyages.model.Voyage;
import com.example.gestion.des.voyages.services.Voyageservice;
import com.example.gestion.des.voyages.validator.voyagevalidator;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
@AllArgsConstructor
public class Voyageserviceimpl implements Voyageservice {
    private final VoyageRepository voyageRepository;


    @Override
    public Voyagedto save(Voyagedto dto) {
     List<String> errors = voyagevalidator.validate(dto);
     if(!errors.isEmpty())
     {
         log.error("voyage not valide",dto);
         throw new InvalidEntityException("voyage n'est pas valide", ErrorCodes.VOYAGE_NOT_FOUND,errors);

     }
     return Voyagedto.fromEntity(voyageRepository.save(Voyagedto.toEntity(dto))); /* hedha yetsama mapping*/
    }

    @Override
    public Voyage update(Voyagedto dto, int id) {
   Voyage voyage = voyageRepository.findById(id);

   voyage.setDestination(dto.getDestination());
        voyage.setDate_debut(dto.getDate_debut());
        voyage.setDate_fin(dto.getDate_fin());
        voyage.setPrix(dto.getPrix());
        voyage.setNbre_place_disponible(dto.getNbre_place_disponible());
        Voyage updatevoyage=voyageRepository.save(voyage);

        return updatevoyage;
    }



    @Override
    public Voyage findById(Integer id) {
        if(id == null)
        {
            log.error("voyage id is null");
            return null;
        }
        Optional<Voyage> voyage = voyageRepository.findById(id);

return voyage.orElseThrow(() -> new EntityNotfoundException("Aucune voyage", ErrorCodes.VOYAGE_NOT_FOUND));
    }

    @Override
    public List<Voyage> findByDestination(String destination1)
    {
      List<Voyage> voyage = voyageRepository.findByDestination(destination1);
        return voyage ;
    }
    @Override
    public List<Voyagedto> findAll() {
        return voyageRepository.findAll().stream()
                .map(Voyagedto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Integer id) {
        if(id == null)
        {
            log.error(("voyage id is null"));
            return;

        }
        voyageRepository.deleteById(id);


    }


}
