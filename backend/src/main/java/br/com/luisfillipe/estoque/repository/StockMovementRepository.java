package br.com.luisfillipe.estoque.repository;
import br.com.luisfillipe.estoque.model.StockMovement;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
public interface StockMovementRepository extends JpaRepository<StockMovement, Long> {
    List<StockMovement> findByProductIdOrderByCreatedAtDesc(Long productId);
}
