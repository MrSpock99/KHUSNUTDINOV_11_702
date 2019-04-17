package ru.itis.batmandbboot.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import ru.itis.batmandbboot.services.InformationService;

@Controller
public class MainPageController {
    @Autowired
    private InformationService informationService;

    @GetMapping("/mainPage")
    public String getMainPage() {
        return "mainPage";
    }
}
