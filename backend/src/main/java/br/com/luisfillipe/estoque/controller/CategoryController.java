package br.com.luisfillipe.estoque.controller;

import br.com.luisfillipe.estoque.model.Category;
import br.com.luisfillipe.estoque.repository.CategoryRepository;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {
    private final CategoryRepository repository;
    public CategoryController(CategoryRepository repository) { this.repository = repository; }
    @GetMapping public List<Category> list() { return repository.findAll(); }
    @PostMapping @ResponseStatus(HttpStatus.CREATED)
    public Category create(@Valid @RequestBody Category category) { return repository.save(category); }
}
