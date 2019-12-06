package org.fusion.application.controller;

import org.fusion.application.model.Customer;
import org.fusion.application.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class CustomerController {

    @Autowired
    private CustomerRepository customerRepository;

    @RequestMapping("/customer/list")
    public String getAll(Model model) {
        return "customer/list";
    }

    @ModelAttribute("customer")
    public List<Customer> getAll() {
        return customerRepository.findAll();
    }

    @RequestMapping("/customer-save")
    public String saveNew(Model model) {
        model.addAttribute("cus", new Customer());
        return "customer/create_update";
    }
}
