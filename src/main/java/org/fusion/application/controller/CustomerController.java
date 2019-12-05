package org.fusion.application.controller;

import org.fusion.application.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CustomerController {

    @Autowired
    private CustomerRepository customerRepository;

    @RequestMapping("/customer/list")
    public String getAll(Model model){
        model.addAttribute("customer", customerRepository.findAll());
        return "customer/list";
    }
}
