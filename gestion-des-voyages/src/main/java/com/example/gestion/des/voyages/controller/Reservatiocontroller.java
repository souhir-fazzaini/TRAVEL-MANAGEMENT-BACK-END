package com.example.gestion.des.voyages.controller;

import com.example.gestion.des.voyages.dto.Reservationdto;
import com.example.gestion.des.voyages.dto.Voyagedto;
import com.example.gestion.des.voyages.services.impl.Reservationserviceimpl;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@AllArgsConstructor
@RequestMapping("/gestion/v1")
@RestController
public class Reservatiocontroller {
    private final Reservationserviceimpl reservationserviceimpl;

    @PostMapping("/reservations/create")
    public Reservationdto create(@RequestBody Reservationdto dto) {
        return reservationserviceimpl.save(dto);
    }
    @PostMapping("/reservations/update")
    public Reservationdto update(@RequestBody Reservationdto dto) {

        return reservationserviceimpl.save(dto);
    }

    @GetMapping("/reservations/All")
    public List<Reservationdto> getAll() {
        return reservationserviceimpl.findAll();
    }
    @DeleteMapping("/reservations/delete/{id}" )
    public void delete(@PathVariable Integer id) {
        reservationserviceimpl.delete(id);

    }
}
