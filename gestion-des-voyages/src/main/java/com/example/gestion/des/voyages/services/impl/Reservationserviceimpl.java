package com.example.gestion.des.voyages.services.impl;

import com.example.gestion.des.voyages.dao.ReservationRepository;
import com.example.gestion.des.voyages.dto.Reservationdto;
import com.example.gestion.des.voyages.dto.Voyagedto;
import com.example.gestion.des.voyages.execption.EntityNotfoundException;
import com.example.gestion.des.voyages.execption.ErrorCodes;
import com.example.gestion.des.voyages.execption.InvalidEntityException;
import com.example.gestion.des.voyages.model.Reservation;
import com.example.gestion.des.voyages.services.Reservationservice;
import com.example.gestion.des.voyages.validator.reservationvalidator;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
@AllArgsConstructor
public class Reservationserviceimpl implements Reservationservice {
    private final ReservationRepository reservationrepository;
    @Override
   public  Reservationdto save(Reservationdto dto)
    {
        List<String> errors = reservationvalidator.validate(dto);
        if(!errors.isEmpty())
        {
            log.error("voyage not valide",dto);
            throw new InvalidEntityException("voyage n'est pas valide", ErrorCodes.VOYAGE_NOT_FOUND,errors);

        }
        return Reservationdto.fromEntity(reservationrepository.save(Reservationdto.toEntity(dto))); /* hedha yetsama mapping*/
    }
   public Reservation findById(Integer id){
       if(id == null)
       {
           log.error("voyage id is null");
           return null;
       }
       Optional<Reservation> reservation = reservationrepository.findById(id);

       return reservation.orElseThrow(() -> new EntityNotfoundException("Aucune voyage", ErrorCodes.RESERVATION_NOT_FOUND));
    }


    @Override
   public List<Reservationdto> findAll()
    {
        return reservationrepository.findAll().stream()
                .map(Reservationdto::fromEntity)
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
        reservationrepository.deleteById(id);


    }
}
