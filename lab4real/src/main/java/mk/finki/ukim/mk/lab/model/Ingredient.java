package mk.finki.ukim.mk.lab.model;

import lombok.Data;
import lombok.Generated;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
public class Ingredient {
    @Id @GeneratedValue
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "spicy")
    private boolean spicy;
    @Column(name = "amount")
    private float amount;
    @Column(name = "veggie")
    private boolean veggie;
}
