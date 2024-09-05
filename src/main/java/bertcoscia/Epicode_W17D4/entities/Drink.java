package bertcoscia.Epicode_W17D4.entities;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Drink extends Item{
    private String name;

    public Drink(String name, int calories, double price) {
        super(calories, price);
        this.name = name;
    }

    @Override
    public String toString() { return name + " " + calories + " kcal, $" + price;}

}
