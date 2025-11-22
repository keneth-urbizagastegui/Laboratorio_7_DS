package com.example.msproveedores.service;

import com.example.msproveedores.entity.Proveedor;
import com.example.msproveedores.repository.ProveedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProveedorService {

    @Autowired
    private ProveedorRepository proveedorRepository;

    public org.springframework.data.domain.Page<Proveedor> findAll(org.springframework.data.domain.Pageable pageable) {
        return proveedorRepository.findAll(pageable);
    }

    public Optional<Proveedor> findById(Long id) {
        return proveedorRepository.findById(id);
    }

    public Proveedor save(Proveedor proveedor) {
        return proveedorRepository.save(proveedor);
    }

    public void deleteById(Long id) {
        proveedorRepository.deleteById(id);
    }
}
