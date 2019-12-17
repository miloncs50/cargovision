package org.fusion.application.controller;

import org.fusion.application.dao.ImportDAO;
import org.fusion.application.model.Imports;
import org.fusion.application.repository.ImportRepository;
import org.fusion.application.repository.VehicaleRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/import")
public class ImportController {

    private VehicaleRepository vehicaleRepository;
    private ImportRepository importRepository;

    public ImportController(VehicaleRepository vehicaleRepository, ImportRepository importRepository) {
        this.vehicaleRepository = vehicaleRepository;
        this.importRepository = importRepository;
    }

    @GetMapping
    public String getAllImport(Model model) {
        List<ImportDAO> imports = importRepository.getAllImport();
        model.addAttribute("imports", imports);
        return "import/list";
    }

    @GetMapping("/new")
    public String importCreateForms(Model model) {
        Imports imports = new Imports();
        model.addAttribute("import", imports);
        model.addAttribute("vehicale", vehicaleRepository.getVehivaleOnly());
        return "import/crete_update";
    }

    @PostMapping("/save")
    public String saveImport(@Valid Imports imports, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "import/crete_update";
        }
        importRepository.save(imports);
        return "import/list";
    }
}
