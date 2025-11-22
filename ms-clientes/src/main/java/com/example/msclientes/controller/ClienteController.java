package com.example.msclientes.controller;

import com.example.msclientes.entity.Cliente;
import com.example.msclientes.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping
    public String getAll(@RequestParam(defaultValue = "0") int page, Model model) {
        Page<Cliente> clientes = clienteService.findAll(PageRequest.of(page, 10));
        model.addAttribute("clientes", clientes);
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", clientes.getTotalPages());
        return "index";
    }

    @GetMapping("/nuevo")
    public String createForm(Model model) {
        model.addAttribute("cliente", new Cliente());
        return "form";
    }

    @PostMapping("/guardar")
    public String save(@ModelAttribute Cliente cliente) {
        clienteService.save(cliente);
        return "redirect:/clientes";
    }

    @GetMapping("/editar/{id}")
    public String editForm(@PathVariable Long id, Model model) {
        Optional<Cliente> cliente = clienteService.findById(id);
        if (cliente.isPresent()) {
            model.addAttribute("cliente", cliente.get());
            return "form";
        }
        return "redirect:/clientes";
    }

    @GetMapping("/eliminar/{id}")
    public String delete(@PathVariable Long id) {
        clienteService.deleteById(id);
        return "redirect:/clientes";
    }
}
