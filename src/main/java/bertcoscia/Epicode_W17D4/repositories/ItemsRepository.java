package bertcoscia.Epicode_W17D4.repositories;

import bertcoscia.Epicode_W17D4.entities.Item;
import bertcoscia.Epicode_W17D4.entities.Pizza;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ItemsRepository extends JpaRepository<Item, Long> {

    List<Item> findByNameIgnoreCase(String name);

    @Query(value = "SELECT * FROM item WHERE category = 'pizza'", nativeQuery = true)
    List<Pizza> findAllPizzas();

}
