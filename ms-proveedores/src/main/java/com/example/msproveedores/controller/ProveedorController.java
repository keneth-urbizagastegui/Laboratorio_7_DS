package com.example.msproveedores.controller;

import com.example.msproveedores.entity.Proveedor;
import com.example.msproveedores.service.ProveedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/proveedores")
public class ProveedorController {

    @Autowired
    private ProveedorService proveedorService;

    @GetMapping
    public String getAll(@RequestParam(defaultValue = "0") int page, Model model) {
        Page<Proveedor> proveedores = proveedorService.findAll(PageRequest.of(page, 10));
        model.addAttribute("proveedores", proveedores);
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", proveedores.getTotalPages());
        return "index";
    }

    @GetMapping("/nuevo")
    public String createForm(Model model) {
        model.addAttribute("proveedor", new Proveedor());
        return "form";
    }

    @PostMapping("/guardar")
    public String save(@ModelAttribute Proveedor proveedor) {
        proveedorService.save(proveedor);
        return "redirect:/proveedores";
    }

    @GetMapping("/editar/{id}")
    public String editForm(@PathVariable Long id, Model model) {
        Optional<Proveedor> proveedor = proveedorService.findById(id);
        if (proveedor.isPresent()) {
            model.addAttribute("proveedor", proveedor.get());
            return "form";
        }
        return "redirect:/proveedores";
    }

    @GetMapping("/eliminar/{id}")
    public String delete(@PathVariable Long id) {
        proveedorService.deleteById(id);
        return "redirect:/proveedores";
    }
}
