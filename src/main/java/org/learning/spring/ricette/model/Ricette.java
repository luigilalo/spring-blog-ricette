package org.learning.spring.ricette.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;

import java.math.BigDecimal;
import java.util.ArrayList;

@Entity
@Table (name = "ricette")

public class Ricette {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotEmpty (message = "Il nome non può essere vuoto")
    @Column
    private String title;
    private String ingredients;
    private String image;
    @Column
    private Integer time;
    private Integer portions;
    @Lob
    private String description;
    @ManyToOne  (cascade = CascadeType.ALL)
    private Categoria categorie;

    public Categoria getCategorie() {
        return categorie;
    }

    public void setCategorie(Categoria categorie) {
        this.categorie = categorie;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIngredients() {
        return ingredients;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Integer getTime() {
        return time;
    }

    public void setTime(Integer time) {
        this.time = time;
    }

    public Integer getPortions() {
        return portions;
    }

    public void setPortions(Integer portions) {
        this.portions = portions;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
