package org.fusion.application.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/vehicale")
public class VehicaleController {

    @GetMapping
    public String getAllVehicale(Model model) {
        return "vehicale/list";
    }

    @GetMapping("/new")
    public String createNew(Model model) {
        return "vehicale/create_update";
    }
}
