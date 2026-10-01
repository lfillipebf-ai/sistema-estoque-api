package br.com.luisfillipe.estoque.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "suppliers")
public class Supplier {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank @Column(nullable = false)
    private String name;
    private String contact;

    public Supplier() {}
    public Supplier(String name, String contact) { this.name = name; this.contact = contact; }
    public Long getId() { return id; }
    public String getName() { return name; }
    public String getContact() { return contact; }
    public void setName(String name) { this.name = name; }
    public void setContact(String contact) { this.contact = contact; }
}
