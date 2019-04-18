package ru.itis.batmandbboot.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import ru.itis.batmandbboot.models.User;
import ru.itis.batmandbboot.services.EditService;
import ru.itis.batmandbboot.services.InformationService;
import ru.itis.batmandbboot.services.LoginService;
import ru.itis.batmandbboot.services.SearchService;

import java.security.Principal;

@Controller
public class MainPageController {
    @Autowired
    private EditService editService;
    @Autowired
    private InformationService informationService;
    @Autowired
    private SearchService searchService;
    @Autowired
    private LoginService loginService;

    private ModelAndView modelAndView;


    @GetMapping("/mainPage")
    public ModelAndView getMainPage(Principal principal) {
        return initModelAndView(principal);
    }

    private ModelAndView initModelAndView(Principal principal) {
        modelAndView = new ModelAndView();
        modelAndView.setViewName("mainPage");

        modelAndView.addObject("userName",principal.getName());

        modelAndView.addObject("subjectList", informationService.getAllSubjects());
        modelAndView.addObject("weaponList", informationService.getAllWeapon());
        modelAndView.addObject("ammoList", informationService.getAllAmmo());
        modelAndView.addObject("equipmentList", informationService.getAllEquipment());
        modelAndView.addObject("transportList", informationService.getAllTransport());
        modelAndView.addObject("expensesList", informationService.getAllExpenses());

        return modelAndView;
    }
}
