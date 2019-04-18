package ru.itis.batmandbboot.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.itis.batmandbboot.services.ConfirmService;

@Controller
public class ConfirmController {
    @Autowired
    private ConfirmService confirmService;

    @GetMapping("/confirm/{confirm-string}")
    @ResponseBody
    public String confirmUser(@PathVariable("confirm-string") String confirmString) {
        confirmService.confirm(confirmString);
        return "Успешно";
    }
}
