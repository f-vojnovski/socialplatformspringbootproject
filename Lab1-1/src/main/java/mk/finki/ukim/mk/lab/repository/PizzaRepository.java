package mk.finki.ukim.mk.lab.repository;

import mk.finki.ukim.mk.lab.model.Pizza;

import java.util.ArrayList;
import java.util.List;

public class PizzaRepository {
    public List<Pizza> pizzaList;

    public PizzaRepository() {
        pizzaList = new ArrayList<>();

        for (int i = 0; i<10; ++i) {
            pizzaList.add(new Pizza("margarita", "so kaskaval"));
            while(true) {
                
            }
        }


    }
}
