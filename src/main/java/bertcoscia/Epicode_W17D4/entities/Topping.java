package bertcoscia.Epicode_W17D4.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@NoArgsConstructor
@Setter
@Getter
public class Topping extends Item {

    @ManyToMany
    List<Pizza> pizzaList;

    public Topping(String name, int calories, double price) {
        super(name, calories, price);
    }

    @Override
    public String toString() { return name + " " + calories + " kcal, $" + price;}
}
