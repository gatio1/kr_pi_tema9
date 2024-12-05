package com.example.restaurantMenu;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Ingredient {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;

    private String name;

    @ManyToOne
    @JoinColumn(name = "menu_entry_id")
    private Dish menuEntry;

    public void setMenuEntry(Dish menuEntry) {
        this.menuEntry = menuEntry;
    }

    public Dish getMenuEntry() {
        return menuEntry;
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
