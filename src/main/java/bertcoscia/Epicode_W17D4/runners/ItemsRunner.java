package bertcoscia.Epicode_W17D4.runners;

import bertcoscia.Epicode_W17D4.EpicodeW17D4Application;
import bertcoscia.Epicode_W17D4.entities.Drink;
import bertcoscia.Epicode_W17D4.entities.Item;
import bertcoscia.Epicode_W17D4.entities.Pizza;
import bertcoscia.Epicode_W17D4.entities.Topping;
import bertcoscia.Epicode_W17D4.repositories.ItemsRepository;
import bertcoscia.Epicode_W17D4.services.ItemsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ContextAnnotationAutowireCandidateResolver;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ItemsRunner implements CommandLineRunner {
    @Autowired
    private ItemsService itemsService;

    @Autowired
    AnnotationConfigApplicationContext ctx;

    @Override
    public void run(String... args) throws Exception {

        try {
            itemsService.saveDrink((Drink) ctx.getBean("lemonade"));
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
        }

        try {
            itemsService.saveTopping((Topping) ctx.getBean("toppings_tomato"));
            itemsService.saveTopping((Topping) ctx.getBean("toppings_cheese"));
            itemsService.saveTopping((Topping) ctx.getBean("toppings_salami"));
            itemsService.saveTopping((Topping) ctx.getBean("toppings_ham"));
            itemsService.saveTopping((Topping) ctx.getBean("toppings_pineapple"));
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
        }

        try {
            List<Topping> margheritaTList = new ArrayList<>();
            margheritaTList.add((Topping) itemsService.findById(2));
            margheritaTList.add((Topping) itemsService.findById(3));
            Pizza margherita = new Pizza("Pizza Margherita", margheritaTList, false);
            itemsService.savePizza(margherita);
        } catch (IllegalArgumentException e){
            System.err.println(e.getMessage());
        }

        try {
            List<Topping> salamiPizzaTList = new ArrayList<>();
            salamiPizzaTList.add((Topping) itemsService.findById(2));
            salamiPizzaTList.add((Topping) itemsService.findById(3));
            salamiPizzaTList.add((Topping) itemsService.findById(4));
            Pizza salami = new Pizza("Pizza Salami", salamiPizzaTList, false);
            itemsService.savePizza(salami);
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
        }

        try{
            List<Topping> hawaiianTList = new ArrayList<>();
            hawaiianTList.add((Topping) itemsService.findById(2));
            hawaiianTList.add((Topping) itemsService.findById(3));
            hawaiianTList.add((Topping) itemsService.findById(8));
            hawaiianTList.add((Topping) itemsService.findById(9));
            Pizza hawaiian = new Pizza("Hawaiian Pizza", hawaiianTList, false);
            itemsService.savePizza(hawaiian);
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
        }

        try {
            itemsService.savePizza((Pizza) ctx.getBean("pizza_margherita"));
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
        }
    }

}

