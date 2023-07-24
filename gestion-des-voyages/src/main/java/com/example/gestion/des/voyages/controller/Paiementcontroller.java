package com.example.gestion.des.voyages.controller;

import com.example.gestion.des.voyages.dto.Paiementdto;
import com.example.gestion.des.voyages.services.impl.Paiementserviceimpl;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
// todo hadhem 8altin les api haka  : hani chnsala7hom w tkaml b9iya kima bch nsala7 ana
public class Paiementcontroller {
    private final Paiementserviceimpl paiementserviceimpl;

    @PostMapping("/paiement")
    public Paiementdto create(@RequestBody Paiementdto dto) {
        return paiementserviceimpl.save(dto);
    }

    @PutMapping("/paiement") // hedhi update m7atya post nti
    public Paiementdto update(@RequestBody Paiementdto dto) {

        return paiementserviceimpl.save(dto);
    }


    @GetMapping("/paiements")
    public List<Paiementdto> getAll() {
        return paiementserviceimpl.findAll();
    }

    @DeleteMapping("/paiement/{id}")
    public void delete(@PathVariable Integer id) {
        paiementserviceimpl.delete(id);

    }
}
