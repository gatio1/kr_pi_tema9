package com.example.restaurantMenu;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;

@Entity
public class Ingredient {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;

    private String name;

    @JsonIgnore
    @ManyToMany(mappedBy = "ingredients", fetch=FetchType.LAZY)
    private List<Dish> menuEntries;

    public void setMenuEntries(List<Dish> menuEntries) {
        this.menuEntries = menuEntries;
    }

    public List<Dish> getMenuEntries() {
        return menuEntries;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }
}
