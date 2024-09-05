package bertcoscia.Epicode_W17D4;

import bertcoscia.Epicode_W17D4.entities.Drink;
import bertcoscia.Epicode_W17D4.entities.Pizza;
import bertcoscia.Epicode_W17D4.entities.Topping;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.util.ArrayList;
import java.util.List;

@Configuration
@PropertySource("application.properties")
public class AppConfig {

    @Bean(name = "toppings_tomato")
    public Topping toppingTomatoBean() {
        return new Topping("Tomato", 0, 0);
    }

    @Bean(name = "toppings_cheese")
    public Topping toppingCheeseBean() {
        return new Topping("Cheese", 92, 0.69);
    }

    @Bean(name = "toppings_ham")
    public Topping toppingHamBean() {
        return new Topping("Ham", 35, 0.99);
    }

    @Bean(name = "toppings_pineapple")
    public Topping toppingPineappleBean() {
        return new Topping("Pineapple", 24, 0.79);
    }

    @Bean(name = "toppings_salami")
    public Topping toppingSalamiBean() {
        return new Topping("Salami", 86, 0.99);
    }

    @Bean(name = "pizza_margherita")
    public Pizza pizzaMargheritaBean() {
        List<Topping> tList = new ArrayList<>();
        tList.add(toppingTomatoBean());
        tList.add(toppingCheeseBean());
        return new Pizza("Pizza Margherita", tList, false);
    }

    @Bean(name = "hawaiian_pizza")
    public Pizza pizzaHawaiianBean() {
        List<Topping> tList = new ArrayList<>();
        tList.add(toppingTomatoBean());
        tList.add(toppingCheeseBean());
        tList.add(toppingHamBean());
        tList.add(toppingPineappleBean());
        return new Pizza("Hawaiian Pizza", tList, false);
    }

    @Bean(name = "salami_pizza")
    public Pizza pizzaSalamiBean() {
        List<Topping> tList = new ArrayList<>();
        tList.add(toppingTomatoBean());
        tList.add(toppingCheeseBean());
        tList.add(toppingSalamiBean());
        return new Pizza("Salami Pizza", tList, false);
    }

    @Bean(name = "salami_pizza_xl")
    public Pizza pizzaSalamiXlBean() {
        List<Topping> tList = new ArrayList<>();
        tList.add(toppingTomatoBean());
        tList.add(toppingCheeseBean());
        tList.add(toppingSalamiBean());
        return new Pizza("Salami Pizza XL", tList, true);
    }

    @Bean(name = "lemonade")
    public Drink lemonadeBean() {
        return new Drink("Lemonade", 128, 1.29);
    }

    @Bean(name = "water")
    public Drink waterBean() {
        return new Drink("Water", 0, 1.29);
    }

    @Bean(name = "wine")
    public Drink wineBean() {
        return new Drink("Wine", 607, 7.49);
    }
}
