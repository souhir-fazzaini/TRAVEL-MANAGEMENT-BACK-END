package com.example.gestion.des.voyages.services.impl;

import com.example.gestion.des.voyages.dao.PaiementRepository;
import com.example.gestion.des.voyages.dto.Paiementdto;
import com.example.gestion.des.voyages.execption.EntityNotfoundException;
import com.example.gestion.des.voyages.execption.ErrorCodes;
import com.example.gestion.des.voyages.execption.InvalidEntityException;
import com.example.gestion.des.voyages.model.Paiement;
import com.example.gestion.des.voyages.services.Paiementservice;
import com.example.gestion.des.voyages.validator.paiementvalidator;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
@Service
@Slf4j
@AllArgsConstructor
public class Paiementserviceimpl implements Paiementservice {
    private final PaiementRepository paiementRepository;
    @Override
    public Paiementdto save(Paiementdto dto)
    {
        List<String> errors = paiementvalidator.validate(dto);
        if(!errors.isEmpty())
        {
            log.error("voyage not valide",dto);
            throw new InvalidEntityException("voyage n'est pas valide", ErrorCodes.VOYAGE_NOT_FOUND,errors);

        }
        return Paiementdto.fromEntity(paiementRepository.save(Paiementdto.toEntity(dto))); /* hedha yetsama mapping*/
    }
    @Override
    public Paiement findById(Integer id){
        if(id == null)
        {
            log.error("voyage id is null");
            return null;
        }
        Optional<Paiement> paiement = paiementRepository.findById(id);

        return paiement.orElseThrow(() -> new EntityNotfoundException("Aucune voyage", ErrorCodes.PAIEMENT_NOT_FOUND));
    }


    @Override
    public List<Paiementdto> findAll()
    {
        return paiementRepository.findAll().stream()
                .map(Paiementdto::fromEntity)
                .collect(Collectors.toList());
    }
    @Override
    public void delete(Integer id)
    {
        if(id == null)
        {
            log.error(("voyage id is null"));
            return;

        }
        paiementRepository.deleteById(id);


    }
}
