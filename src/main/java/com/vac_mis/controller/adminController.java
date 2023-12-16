package com.vac_mis.controller;

import com.vac_mis.model.Users;
import com.vac_mis.service.IInformationService;
import com.vac_mis.service.IUsersService;
import com.vac_mis.service.IVaccineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class adminController {
    private final IInformationService infoService;
    private final IVaccineService vaccineService;
    private final IUsersService usersService;
    @Autowired

    public adminController(IInformationService infoService, IVaccineService vaccineService, IUsersService usersService) {
        this.infoService = infoService;
        this.vaccineService = vaccineService;
        this.usersService = usersService;
    }
    @GetMapping("/admin")
    public String adminPage(Model model){
        model.addAttribute("nurselist",usersService.usersList());
        return "adminPage";
    }
}
