package mk.finki.ukim.mk.lab.service;

import mk.finki.ukim.mk.lab.model.Ingredient;
import mk.finki.ukim.mk.lab.repository.IngredientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class IngredientService {

    @Autowired
    IngredientRepository ingredientRepository;

    public void delete(int id) {
        ingredientRepository.deleteById(id);
    }

    public List<Ingredient> getAll() {
        List<Ingredient> ingredients = new ArrayList<Ingredient>();
        ingredientRepository.findAll().forEach(ingredient -> ingredients.add(ingredient));
        return ingredients;
    }

    public Ingredient getById(int id) {
        return ingredientRepository.findById(id).get();
    }

    public void saveOrUpdate(Ingredient ingredient) {
        ingredientRepository.save(ingredient);
    }

}