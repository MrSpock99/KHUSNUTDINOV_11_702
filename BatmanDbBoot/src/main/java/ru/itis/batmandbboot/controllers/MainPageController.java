package ru.itis.batmandbboot.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ru.itis.batmandbboot.forms.EntityForm;
import ru.itis.batmandbboot.models.Subject;
import ru.itis.batmandbboot.services.EditService;
import ru.itis.batmandbboot.services.InformationService;
import ru.itis.batmandbboot.services.LoginService;
import ru.itis.batmandbboot.services.SearchService;

import java.security.Principal;
import java.util.List;

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
        modelAndView.addObject("weaponList", informationService.getAllWeaponAmmo());
        modelAndView.addObject("ammoList", informationService.getAllAmmo());
        modelAndView.addObject("equipmentList", informationService.getAllEquipment());
        modelAndView.addObject("transportList", informationService.getAllTransport());
        modelAndView.addObject("expensesList", informationService.getAllExpenses());

        return modelAndView;
    }


    @RequestMapping(value = "/mainPage/delete", method = RequestMethod.POST, produces = MediaType.TEXT_PLAIN_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public String deleteEntity(@RequestBody EntityForm entityForm) {
        System.out.println(entityForm.toString());
        if (editService.deleteEntity(entityForm.getTable_name(), Long.valueOf(entityForm.getEntity_id()))) {
            return "Deleted successfully";
        }
        return "Error";
    }

    @RequestMapping(value = "/mainPage/add", method = RequestMethod.POST, produces = MediaType.TEXT_PLAIN_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public String addEntity(@RequestBody EntityForm entityForm) {
        switch (entityForm.getTable_name()) {
            case "subject":
                editService.saveSubject(entityForm.getEntity());
                break;
            case "weapon":
                editService.saveWeapon(entityForm.getEntity());
                break;
            case "equipment":
                editService.saveEquipment(entityForm.getEntity());
                break;
            case "transport":
                editService.saveTransport(entityForm.getEntity());
                break;
            case "expense":
                editService.saveExpense(entityForm.getEntity());
                break;
        }
        return "Added successfully";
    }

    @GetMapping(value = "/mainPage/search", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<Subject> searchSubject(@RequestParam("q") String q) {
        List<Subject> list = searchService.searchSubject(q);
        return searchService.searchSubject(q);
    }

}
