package com.example.gestion.des.voyages.controller;
import com.example.gestion.des.voyages.dto.Voyagedto;
import com.example.gestion.des.voyages.model.Voyage;
import com.example.gestion.des.voyages.services.impl.Voyageserviceimpl;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
public class Voyagecontroller {

    private final Voyageserviceimpl voyageserviceimpl;

    @PostMapping("/voyages")
    public Voyagedto create(@RequestBody Voyagedto dto) {
        return voyageserviceimpl.save(dto);
    }
    @PutMapping("/voyages/{id}")
    public Voyage update( @PathVariable int id,@RequestBody Voyagedto dto) {
        return voyageserviceimpl.update(dto, id);




    }
    @GetMapping("/voyages/{id}")
    public Voyage findById(@PathVariable int id) {
        return  voyageserviceimpl.findById(id);
    }

    @GetMapping("/voyages")
    public List<Voyagedto> getAll() {
        return voyageserviceimpl.findAll();
    }
    @DeleteMapping("/voyage/{id}" )
    public void delete(@PathVariable Integer id) {
        voyageserviceimpl.delete(id);

    }

}
