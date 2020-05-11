package mk.finki.ukim.mk.lab.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import java.util.List;
import javax.persistence.Id;

@Data
@AllArgsConstructor
@Entity
public class Pizza {
    @Id @GeneratedValue
    private int Id;
    private String name;
    private String description;
    private List<Ingredient> ingredients;
    private boolean veggie;
}
