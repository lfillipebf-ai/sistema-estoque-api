package br.com.luisfillipe.estoque.repository;
import br.com.luisfillipe.estoque.model.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;
public interface SupplierRepository extends JpaRepository<Supplier, Long> {}
