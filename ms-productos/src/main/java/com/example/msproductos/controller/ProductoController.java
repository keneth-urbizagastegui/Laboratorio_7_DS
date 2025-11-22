package com.example.msproductos.controller;

import com.example.msproductos.entity.Producto;
import com.example.msproductos.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/")
public class ProductoController {

    @Autowired
    private ProductoService productoService;

    @GetMapping
    public String getAll(@RequestParam(defaultValue = "0") int page, Model model) {
        Page<Producto> productos = productoService.findAll(PageRequest.of(page, 10));
        model.addAttribute("productos", productos);
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", productos.getTotalPages());
        return "index";
    }

    @GetMapping("/nuevo")
    public String createForm(Model model) {
        model.addAttribute("producto", new Producto());
        return "form";
    }

    @PostMapping("/guardar")
    public String save(@ModelAttribute Producto producto) {
        productoService.save(producto);
        return "redirect:/";
    }

    @GetMapping("/editar/{id}")
    public String editForm(@PathVariable Long id, Model model) {
        Optional<Producto> producto = productoService.findById(id);
        if (producto.isPresent()) {
            model.addAttribute("producto", producto.get());
            return "form";
        }
        return "redirect:/";
    }

    @GetMapping("/eliminar/{id}")
    public String delete(@PathVariable Long id) {
        productoService.deleteById(id);
        return "redirect:/";
    }
}
