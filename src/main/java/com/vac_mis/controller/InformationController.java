package com.vac_mis.controller;

import com.vac_mis.model.Information;
import com.vac_mis.service.IInformationService;
import com.vac_mis.service.IUsersService;
import com.vac_mis.service.IVaccineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.repository.query.Param;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class InformationController {
    private final IInformationService infoService;
    private final IVaccineService vaccineService;
    private final IUsersService usersService;
    @Autowired
    JavaMailSender javaMailSender;

    @Value("${spring.mail.username}")
    String sender;

    @Autowired
    public InformationController(IInformationService infoService, IVaccineService vaccineService, IUsersService usersService) {
        this.infoService = infoService;
        this.vaccineService = vaccineService;
        this.usersService = usersService;
    }

    @GetMapping("/info")
    public String getInformationDashboard(Model model) {
        model.addAttribute("informationList", infoService.informationList());
        model.addAttribute("inform", new Information());
        model.addAttribute("vacList", vaccineService.vaccineList());
        model.addAttribute("nurseList", usersService.usersList());
        return "information";
    }


    @PostMapping("/information/create")
    public String createInfo(@ModelAttribute("inform") Information information, @Param("action") String action) {


        if (action.equals("Delete")) {
            infoService.deleteInformation(information);
        } else if (action.equals("Update")) {
            information.setId(information.getId());
            infoService.updateInformation(information);
        } else {





            infoService.saveInformation(information);

            SimpleMailMessage mailMessage
                    = new SimpleMailMessage();

            mailMessage.setFrom(sender);
            mailMessage.setTo(information.getEmail());
            mailMessage.setText("Thank you " + information.getPatientName() +
                    "for using our vaccines, you have been vaccinated well with " + information.getVaccine() + " stay healthy😉");
            mailMessage.setSubject("Welcome *.*");

            javaMailSender.send(mailMessage);
        }
        return "redirect:/info";
    }
}
