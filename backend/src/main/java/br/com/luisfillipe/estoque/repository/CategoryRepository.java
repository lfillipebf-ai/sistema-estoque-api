package br.com.luisfillipe.estoque.repository;
import br.com.luisfillipe.estoque.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
public interface CategoryRepository extends JpaRepository<Category, Long> {}
