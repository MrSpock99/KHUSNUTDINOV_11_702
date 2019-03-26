package ru.itis.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import ru.itis.services.EditService;
import ru.itis.services.InformationService;

@Controller
public class MainPageController {

    @Autowired
    private EditService editService;
    @Autowired
    private InformationService informationService;

    @RequestMapping(value = "/mainPage", method = RequestMethod.GET)
    public ModelAndView getMainPage() {
        return initModelAndView();
    }

    @RequestMapping(value = "/mainPage", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public String deleteEntity(@RequestParam("table_name") String tableName, @RequestParam("entity_id") String entityId,
                               @RequestParam("action") String action) {
        System.out.println(tableName + entityId + action);
        return tableName;
    }

    private ModelAndView initModelAndView() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("mainPage");

        modelAndView.addObject("subjectList", informationService.getAllSubjects());
        modelAndView.addObject("weaponList", informationService.getAllWeapon());
        modelAndView.addObject("ammoList", informationService.getAllAmmo());
        modelAndView.addObject("equipmentList", informationService.getAllEquipment());
        modelAndView.addObject("transportList", informationService.getAllTransport());
        modelAndView.addObject("expensesList", informationService.getAllExpenses());

        return modelAndView;
    }
}
