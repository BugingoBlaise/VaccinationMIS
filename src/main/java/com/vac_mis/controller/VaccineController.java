package com.vac_mis.controller;

import com.vac_mis.model.Vaccine;
import com.vac_mis.service.IVaccineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class VaccineController {
    private final IVaccineService service;

    @Autowired
    public VaccineController(IVaccineService service) {
        this.service = service;
    }

    @GetMapping("/vaccine")
    public String getVaccineDashboard(Model model) {
        model.addAttribute("vaccineList", service.vaccineList());
        model.addAttribute("vac", new Vaccine());
        return "vaccine";
    }

    @GetMapping
    public List<Vaccine> getVaccines() {
        return service.vaccineList();
    }

    @PostMapping
    public void registerStudent(@RequestBody Vaccine vaccine) {
        service.saveVaccine(vaccine);
    }
    @PostMapping("/vaccine/create")
    public String createSemester(@ModelAttribute("vac") Vaccine vaccine, @Param("action") String action) {


        if (action.equals("Delete")) {
            service.deleteVaccine(vaccine);
        } else if (action.equals("Update")) {
            vaccine.setId(vaccine.getId());
            service.updateVaccine(vaccine);
        } else {
            service.saveVaccine(vaccine);
        }
        return "redirect:/vaccine";
    }
}
