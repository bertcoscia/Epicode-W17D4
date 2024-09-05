package bertcoscia.Epicode_W17D4.entities;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Pizza extends Item {

    @ManyToMany()
    private List<Topping> toppingList;

    @Column(name = "is_xl")
    private boolean isXl = false;

    public Pizza(String name, List<Topping> toppingList, boolean isXl) {
        super(name, 700, 4.3);
        this.calories = this.getCalories() + toppingList.stream().mapToInt(Item::getCalories).sum();
        this.price = this.getPrice() + toppingList.stream().mapToDouble(Item::getPrice).sum();
        this.toppingList = toppingList;
        this.isXl = isXl;
    }

    public void addTopping(Topping topping) {
        this.getToppingList().add(topping);
        this.setCalories(this.calories + topping.getCalories());
        this.setPrice(this.price + topping.getPrice());
    }

    @Override
    public String toString() {
        StringBuilder toppingsBuilder = new StringBuilder();
        this.toppingList.forEach(topping -> toppingsBuilder.append(topping.getName()).append(", "));
        if (!toppingsBuilder.isEmpty()) {
            toppingsBuilder.setLength(toppingsBuilder.length() - 2);
        }
        return name + " (" + toppingsBuilder + ") " + calories + " kcal, $" + price;
    }
}