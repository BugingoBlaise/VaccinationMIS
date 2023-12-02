package com.vac_mis.controller;

import com.vac_mis.model.Vaccine;
import com.vac_mis.service.IVaccineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/v1")
public class VaccineController {
    private final IVaccineService service;

    @Autowired
    public VaccineController(IVaccineService service) {
        this.service = service;
    }

    @GetMapping
    public List<Vaccine> getVaccines() {
        return service.vaccineList();
    }

    @PostMapping
    public void registerStudent(@RequestBody Vaccine vaccine) {
        service.saveVaccine(vaccine);
    }

}
