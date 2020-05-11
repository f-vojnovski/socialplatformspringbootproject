package mk.finki.ukim.mk.lab.controllers;

import mk.finki.ukim.mk.lab.model.Ingredient;
import mk.finki.ukim.mk.lab.service.IngredientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class IngredientController {
    @Autowired
    IngredientService ingredientService;

    @GetMapping("/ingredients")
    private List<Ingredient> getAllIngredients() {
        return ingredientService.getAll();
    }

    @DeleteMapping("/ingredients/{id}")
    private void deleteIngredient(@PathVariable("id") int id) {
        ingredientService.delete(id);
    }

    @GetMapping("/ingredients/{id}")
    private Ingredient getIngredient(@PathVariable("id") int id) {
        return ingredientService.getById(id);
    }

    @PatchMapping("/ingredients")
    private int savePerson(@RequestBody Ingredient ingredient) {
        ingredientService.saveOrUpdate(ingredient);
        return ingredient.getId();
    }
}
