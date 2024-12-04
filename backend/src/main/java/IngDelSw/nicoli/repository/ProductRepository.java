
package IngDelSw.nicoli.repository;

import IngDelSw.nicoli.model.Product;
import IngDelSw.nicoli.model.Treatment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long> {
    Optional<Product> findByProductId(Integer id);
}
