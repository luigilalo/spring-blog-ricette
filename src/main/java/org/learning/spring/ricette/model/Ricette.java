package org.learning.spring.ricette.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;

import java.math.BigDecimal;

@Entity
@Table (name = "ricette")

public class Ricette {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotEmpty (message = "Il nome non può essere vuoto")
    @Column(nullable = false)
    private String title;
    private String ingredients;
    private String image;
    private BigDecimal timePreparation;
    @Min(1)
    private int portions;
    @Lob
    private String description;

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

    public BigDecimal getTimePreparation() {
        return timePreparation;
    }

    public void setTimePreparation(BigDecimal timePreparation) {
        this.timePreparation = timePreparation;
    }

    public int getPortions() {
        return portions;
    }

    public void setPortions(int portions) {
        this.portions = portions;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
