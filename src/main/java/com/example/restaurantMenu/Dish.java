package com.example.restaurantMenu;


import java.math.BigDecimal;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;

@Entity // This tells Hibernate to make a table out of this class
public class Dish {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;

    private String name;

    @ManyToMany(fetch=FetchType.EAGER)
    @JoinTable(
        name = "dish_ingredient",
        joinColumns = @JoinColumn(name = "dish_id"),
        inverseJoinColumns = @JoinColumn(name = "ingredient_id")
    )
    private List<Ingredient> ingredients;

    public void setIngredients(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    private float weight;

    @Column(precision = 10, scale = 2)
    private BigDecimal price;  // Use BigDecimal for price

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

    public String getName(){
        return this.name;
    }

    public void setName(String name){
        this.name = name;
    }

    public List<Ingredient> getIngredients(){
        return ingredients;
    }

    public float getWeight(){
        return weight;
    }

    public void setWeight(float weight){
        this.weight = weight;
    }

    public BigDecimal getPrice(){
        return price;
    }

    public void setPrice(BigDecimal price){
        this.price = price;
    }



}
