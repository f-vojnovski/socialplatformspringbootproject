package mk.finki.ukim.mk.lab.service;

import mk.finki.ukim.mk.lab.model.Pizza;
import mk.finki.ukim.mk.lab.repository.PizzaRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PizzaService {

    private final PizzaRepository pizzaRepository;

    public PizzaService(PizzaRepository pizzaRepository) {
        this.pizzaRepository = pizzaRepository;
    }

    public void delete(int id) {
        pizzaRepository.deleteById(id);
    }

    public List<Pizza> getAll() {
        List<Pizza> pizzas = new ArrayList<Pizza>();
        pizzaRepository.findAll().forEach(pizza -> pizzas.add(pizza));
        return pizzas;
    }

    public Pizza getById(int id) {
        return pizzaRepository.findById(id).get();
    }

    public void saveOrUpdate(Pizza pizza) {
        pizzaRepository.save(pizza);
    }

    public List<Pizza> getSpicy() {
        List<Pizza> pizzas = new ArrayList<Pizza>();
        pizzaRepository.findAll().forEach(pizza -> pizzas.add(pizza));
        return pizzas;
    }

}