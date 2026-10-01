package br.com.luisfillipe.estoque.controller;

import br.com.luisfillipe.estoque.model.Supplier;
import br.com.luisfillipe.estoque.repository.SupplierRepository;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/suppliers")
public class SupplierController {
    private final SupplierRepository repository;
    public SupplierController(SupplierRepository repository) { this.repository = repository; }
    @GetMapping public List<Supplier> list() { return repository.findAll(); }
    @PostMapping @ResponseStatus(HttpStatus.CREATED)
    public Supplier create(@Valid @RequestBody Supplier supplier) { return repository.save(supplier); }
}
