package bertcoscia.Epicode_W17D4.entities;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
public class Topping extends Item {
    private String name;

    public Topping(String name, int calories, double price) {
        super(calories, price);
        this.name = name;
    }

    @Override
    public String toString() { return name + " " + calories + " kcal, $" + price;}
}
