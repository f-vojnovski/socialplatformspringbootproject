package mk.finki.ukim.mk.lab.controllers;

import mk.finki.ukim.mk.lab.model.Ingredient;
import mk.finki.ukim.mk.lab.model.Pizza;
import mk.finki.ukim.mk.lab.service.IngredientService;
import mk.finki.ukim.mk.lab.service.PizzaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PizzaController {
    @Autowired
    PizzaService pizzaService;

    @GetMapping("/ingredients")
    private List<Pizza> getAllIngredients() {
        return pizzaService.getAll();
    }

    @DeleteMapping("/ingredients/{id}")
    private void deleteIngredient(@PathVariable("id") int id) {
        pizzaService.delete(id);
    }

    @GetMapping("/ingredients/{id}")
    private Pizza getIngredient(@PathVariable("id") int id) {
        return pizzaService.getById(id);
    }

    @PatchMapping("/ingredients")
    private int savePerson(@RequestBody Pizza pizza) {
        pizzaService.saveOrUpdate(pizza);
        return pizza.getId();
    }
}
