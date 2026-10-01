package br.com.luisfillipe.estoque.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
@Table(name = "stock_movements")
public class StockMovement {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull @Enumerated(EnumType.STRING) @Column(nullable = false)
    private MovementType type;
    @NotNull @Min(1) @Column(nullable = false)
    private Integer quantity;
    @Column(nullable = false) private LocalDateTime createdAt;
    @ManyToOne(optional = false) @JoinColumn(name = "product_id")
    private Product product;
    @Column(length = 255) private String reason;

    public StockMovement() {}
    @PrePersist public void prePersist() { if (createdAt == null) createdAt = LocalDateTime.now(); }
    public Long getId() { return id; }
    public MovementType getType() { return type; }
    public Integer getQuantity() { return quantity; }
    public LocalDateTime getCreatedAt() { return createdAt; }
    public Product getProduct() { return product; }
    public String getReason() { return reason; }
    public void setType(MovementType type) { this.type = type; }
    public void setQuantity(Integer quantity) { this.quantity = quantity; }
    public void setProduct(Product product) { this.product = product; }
    public void setReason(String reason) { this.reason = reason; }
}
