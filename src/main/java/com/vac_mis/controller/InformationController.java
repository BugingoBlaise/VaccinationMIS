package com.vac_mis.controller;

import com.vac_mis.model.Information;
import com.vac_mis.service.IInformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class InformationController {
    private IInformationService service;

    @Autowired

    public InformationController(IInformationService service) {
        this.service = service;
    }

    @GetMapping("/info")
    public String getInformationDashboard(Model model) {
        model.addAttribute("informationList", service.informationList());
        model.addAttribute("vac", new Information());
        return "information";
    }


    @PostMapping("/information/create")
    public String createSemester(@ModelAttribute("vac") Information information, @Param("action") String action) {


        if (action.equals("Delete")) {
            service.deleteInformation(information);
        } else if (action.equals("Update")) {
            information.setId(information.getId());
            service.updateInformation(information);
        } else {
            service.saveInformation(information);
        }
        return "redirect:/information";
    }
}
