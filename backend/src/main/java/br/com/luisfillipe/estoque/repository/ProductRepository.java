package br.com.luisfillipe.estoque.repository;
import br.com.luisfillipe.estoque.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
public interface ProductRepository extends JpaRepository<Product, Long> {}
