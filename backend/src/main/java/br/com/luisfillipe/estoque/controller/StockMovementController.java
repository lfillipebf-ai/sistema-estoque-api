package br.com.luisfillipe.estoque.controller;

import br.com.luisfillipe.estoque.model.*;
import br.com.luisfillipe.estoque.repository.ProductRepository;
import br.com.luisfillipe.estoque.repository.StockMovementRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/stock-movements")
public class StockMovementController {
    private final StockMovementRepository movementRepository;
    private final ProductRepository productRepository;

    public StockMovementController(StockMovementRepository movementRepository, ProductRepository productRepository) {
        this.movementRepository = movementRepository;
        this.productRepository = productRepository;
    }

    @GetMapping public List<StockMovement> list() { return movementRepository.findAll(); }

    @GetMapping("/product/{productId}")
    public List<StockMovement> byProduct(@PathVariable Long productId) {
        return movementRepository.findByProductIdOrderByCreatedAtDesc(productId);
    }

    @PostMapping @ResponseStatus(HttpStatus.CREATED) @Transactional
    public StockMovement create(@Valid @RequestBody StockMovement movement) {
        if (movement.getProduct() == null || movement.getProduct().getId() == null)
            throw new IllegalArgumentException("Informe o id do produto");

        Product product = productRepository.findById(movement.getProduct().getId())
                .orElseThrow(() -> new IllegalArgumentException("Produto não encontrado"));

        int current = product.getStockQuantity() == null ? 0 : product.getStockQuantity();
        int quantity = movement.getQuantity();

        if (movement.getType() == MovementType.IN) {
            product.setStockQuantity(current + quantity);
        } else {
            if (current < quantity) throw new IllegalArgumentException("Estoque insuficiente");
            product.setStockQuantity(current - quantity);
        }

        movement.setProduct(product);
        productRepository.save(product);
        return movementRepository.save(movement);
    }
}
