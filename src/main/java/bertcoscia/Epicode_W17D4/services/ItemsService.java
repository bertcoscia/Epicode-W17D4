package bertcoscia.Epicode_W17D4.services;

import bertcoscia.Epicode_W17D4.entities.Drink;
import bertcoscia.Epicode_W17D4.entities.Item;
import bertcoscia.Epicode_W17D4.entities.Pizza;
import bertcoscia.Epicode_W17D4.entities.Topping;
import bertcoscia.Epicode_W17D4.exceptions.NotFoundException;
import bertcoscia.Epicode_W17D4.repositories.ItemsRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class ItemsService {
    @Autowired
    private ItemsRepository itemsRepository;

    public void saveDrink(Drink drink) {
        itemsRepository.save(drink);
        log.info("Drink {} salvato correttamente", drink.getName());
    }

    public void savePizza(Pizza pizza) {
        itemsRepository.save(pizza);
        log.info("Pizza {} salvata correttamente", pizza.getName());
    }

    public void saveTopping(Topping topping) {
        itemsRepository.save(topping);
        log.info("Topping {} salvato correttamente", topping.getName());
    }

    public List<Pizza> findAllPizzas() {
        return itemsRepository.findAllPizzas();
    }

    public Item findById(long id) {
        return itemsRepository.findById(id).orElseThrow(() -> new NotFoundException(id));
    }

    public void findByIdAndDelete(long id) {
        Item found = this.findById(id);
        itemsRepository.delete(found);
        log.info("Articolo {} cancellato correttamente", found.getName());
    }

    public void findByIdAndUpdate(long id, Item updatedItem) {
        Item found = this.findById(id);
        found.setName(updatedItem.getName());
        found.setCalories(updatedItem.getCalories());
        found.setPrice(updatedItem.getPrice());
        itemsRepository.save(found);
        log.info("Articolo {} modificato correttamente", found.getName());
    }

    public List<Item> findByName(String name) {
        return itemsRepository.findByNameIgnoreCase(name);
    }

}
