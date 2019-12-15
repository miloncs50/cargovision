package org.fusion.application.controller;

//import org.fusion.application.repository.CustomerRepository;
import org.fusion.application.model.Customer;
import org.fusion.application.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@Controller
@RequestMapping("/customer/")
public class CustomerController {

    @Autowired
    private CustomerRepository customerRepository;

    @RequestMapping("/list")
    public String getAll(Model model) {
        model.addAttribute("customers", customerRepository.findAll());
        return "customer/list";
    }

    @GetMapping("save")
    public String customerNewForm(Model model) {
        Customer customer = new Customer();
        model.addAttribute("customer", customer);
        return "customer/create_update";
    }

    @PostMapping("save")
    public String customerSaveNew(@Valid Customer customer, BindingResult result) {
        if (result.hasErrors()) {
            return "customer/create_update";
        }
        customerRepository.save(customer);
        return "redirect:list";
    }

    @GetMapping("/edit/{id}")
    public String updateCustomer(@PathVariable Integer id, Model model) {
        Optional<Customer> customer = customerRepository.findById(id);
        model.addAttribute("customer", customer);
        return "customer/create_update";
    }
}
