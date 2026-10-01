package br.com.luisfillipe.estoque.controller;

import br.com.luisfillipe.estoque.model.Product;
import br.com.luisfillipe.estoque.repository.ProductRepository;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {
    private final ProductRepository repository;
    public ProductController(ProductRepository repository) { this.repository = repository; }

    @GetMapping public List<Product> list() { return repository.findAll(); }

    @GetMapping("/{id}")
    public Product get(@PathVariable Long id) {
        return repository.findById(id).orElseThrow(() -> new IllegalArgumentException("Produto não encontrado"));
    }

    @PostMapping @ResponseStatus(HttpStatus.CREATED)
    public Product create(@Valid @RequestBody Product product) { return repository.save(product); }

    @PutMapping("/{id}")
    public Product update(@PathVariable Long id, @Valid @RequestBody Product data) {
        Product product = get(id);
        product.setName(data.getName());
        product.setSku(data.getSku());
        product.setPrice(data.getPrice());
        product.setCategory(data.getCategory());
        product.setSupplier(data.getSupplier());
        return repository.save(product);
    }

    @DeleteMapping("/{id}") @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        if (!repository.existsById(id)) throw new IllegalArgumentException("Produto não encontrado");
        repository.deleteById(id);
    }
}
