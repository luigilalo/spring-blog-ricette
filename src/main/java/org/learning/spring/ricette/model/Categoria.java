package org.learning.spring.ricette.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table (name = "categorie")
public class Categoria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty(message = "Il nome non può essere vuoto")
    private String name;

    @OneToMany (mappedBy = "categorie" , orphanRemoval = true , cascade = CascadeType.ALL)
    private List<Ricette> ricetteList;

    public List<Ricette> getRicetteList() {
        return ricetteList;
    }

    public void setRicetteList(List<Ricette> ricetteList) {
        this.ricetteList = ricetteList;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}


