package ru.itis.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ru.itis.forms.EntityForm;
import ru.itis.models.Subject;
import ru.itis.models.User;
import ru.itis.services.EditService;
import ru.itis.services.InformationService;
import ru.itis.services.LoginService;
import ru.itis.services.SearchService;

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

    @RequestMapping(value = "/mainPage", method = RequestMethod.GET)
    public ModelAndView getMainPage(@CookieValue("AuthFilter") String cookie) {
        return initModelAndView(cookie);
    }

    private void setUserNameByCookie(String cookie) {
        User user = null;
        if (cookie != null) {
            if (loginService.isExistByCookie(cookie)) {
                user = loginService.getUserByCookie(cookie);
            }
            modelAndView.addObject("userName", user.getName());
        }
    }

    @RequestMapping(value = "/mainPage/json", method = RequestMethod.POST, produces = MediaType.TEXT_PLAIN_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public String deleteEntity(@RequestBody EntityForm entityForm) {
        System.out.println(entityForm.toString());
        if (editService.deleteEntity(entityForm.getTable_name(), Long.valueOf(entityForm.getEntity_id()))) {
            return "Deleted successfully";
        }
        return "Error";
    }

    @GetMapping(value = "/mainPage/search", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<Subject> searchSubject(@RequestParam("q") String q) {
        return searchService.searchSubject(q);
    }

    private ModelAndView initModelAndView(String cookie) {
        modelAndView = new ModelAndView();
        modelAndView.setViewName("mainPage");

        setUserNameByCookie(cookie);

        modelAndView.addObject("subjectList", informationService.getAllSubjects());
        modelAndView.addObject("weaponList", informationService.getAllWeapon());
        modelAndView.addObject("ammoList", informationService.getAllAmmo());
        modelAndView.addObject("equipmentList", informationService.getAllEquipment());
        modelAndView.addObject("transportList", informationService.getAllTransport());
        modelAndView.addObject("expensesList", informationService.getAllExpenses());

        return modelAndView;
    }
}
