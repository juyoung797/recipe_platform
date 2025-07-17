package com.j797.recipe_platform.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Fetch;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "recipes")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Recipe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 200)
    private String title;

    @Column(columnDefinition = "TEXT")
    private String description;

    @OneToMany(mappedBy = "recipe", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference("recipe-ri")
    private List<RecipeIngredient> recipeIngredientList = new ArrayList<>();
//
//    @ManyToOne(fetch = FetchType.LAZY)
//    @MapsId("ingredientId")
//    @JoinColumn(name = "ingredient_id")
//    @JsonBackReference("ingredient-ri")
//    private Ingredient ingredient;
//
//    @Column(length = 50)
//    private String quantity;
}