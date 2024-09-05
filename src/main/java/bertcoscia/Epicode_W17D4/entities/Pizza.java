import bertcoscia.Epicode_W17D4.entities.Item;
import bertcoscia.Epicode_W17D4.entities.Topping;
import lombok.Getter;
import lombok.Setter;

import java.util.List;


@Getter
@Setter
public class Pizza extends Item {
    private String name;
    private List<Topping> toppingList;
    private boolean isXl = false;

    public Pizza(String name, List<Topping> toppingList, boolean isXl) {
        super(700, 4.3);
        this.name = name;
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