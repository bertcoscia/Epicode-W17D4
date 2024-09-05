package bertcoscia.Epicode_W17D4.entities;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Drink extends Item{

    public Drink(String name, int calories, double price) {
        super(name, calories, price);
    }

    @Override
    public String toString() { return name + " " + calories + " kcal, $" + price;}

}
