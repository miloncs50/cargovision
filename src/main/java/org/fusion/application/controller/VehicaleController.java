package org.fusion.application.controller;

import org.fusion.application.dao.VehicaleInterface;
import org.fusion.application.model.Customer;
import org.fusion.application.model.Vehicale;
import org.fusion.application.repository.CustomerRepository;
import org.fusion.application.repository.VehicaleRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/vehicale")
public class VehicaleController {
    private VehicaleRepository vehicaleRepository;
    private CustomerRepository customerRepository;

    public VehicaleController(VehicaleRepository vehicaleRepository, CustomerRepository customerRepository) {
        this.vehicaleRepository = vehicaleRepository;
        this.customerRepository = customerRepository;
    }

    @GetMapping
    public String getAllVehicale(Model model) {
        model.addAttribute("getvehicales", vehicaleRepository.getVehivaleAll());
        return "vehicale/list";
    }

    @GetMapping("/new")
    public String createNew(Model model) {
        Vehicale vehicale = new Vehicale();
        model.addAttribute("vehicales", vehicale);
        model.addAttribute("owner", customerRepository.getAllCustomer());
        return "vehicale/create_update";
    }

    @PostMapping("/save")
    public String saveVehicale(@Valid Vehicale vehicale, BindingResult bindingResult) {
        vehicaleRepository.save(vehicale);
        return "redirect:/vehicale";
    }

    @GetMapping("/edit/{id}")
    public String editVehicale(@PathVariable Integer id, Model model) {
        Optional<Vehicale> vehicale = vehicaleRepository.findById(id);
        model.addAttribute("vehicales", vehicale);
        return "vehicale/create_update";
    }
}
