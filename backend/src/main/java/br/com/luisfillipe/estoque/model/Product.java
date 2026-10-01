package br.com.luisfillipe.estoque.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.math.BigDecimal;

@Entity
@Table(name = "products")
public class Product {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank @Column(nullable = false) private String name;
    @Column(unique = true) private String sku;
    @NotNull @DecimalMin("0.0") @Column(nullable = false, precision = 12, scale = 2) private BigDecimal price;
    @Min(0) @Column(nullable = false) private Integer stockQuantity = 0;
    @ManyToOne @JoinColumn(name = "category_id") private Category category;
    @ManyToOne @JoinColumn(name = "supplier_id") private Supplier supplier;

    public Product() {}
    public Long getId() { return id; }
    public String getName() { return name; }
    public String getSku() { return sku; }
    public BigDecimal getPrice() { return price; }
    public Integer getStockQuantity() { return stockQuantity; }
    public Category getCategory() { return category; }
    public Supplier getSupplier() { return supplier; }
    public void setName(String name) { this.name = name; }
    public void setSku(String sku) { this.sku = sku; }
    public void setPrice(BigDecimal price) { this.price = price; }
    public void setStockQuantity(Integer stockQuantity) { this.stockQuantity = stockQuantity; }
    public void setCategory(Category category) { this.category = category; }
    public void setSupplier(Supplier supplier) { this.supplier = supplier; }
}
