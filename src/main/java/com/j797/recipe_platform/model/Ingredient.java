package com.j797.recipe_platform.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.j797.recipe_platform.model.RecipeIngredient;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "ingredients")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Ingredient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100, unique = true)
    private String name;

    @OneToMany(mappedBy = "ingredient", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference("ingredient-ri")
    private List<RecipeIngredient> ingredienRecipetList = new ArrayList<>();

//    @ManyToOne(fetch = FetchType.LAZY)
//    @MapsId("recipeId")
//    @JoinColumn(name = "recipe_id")
//    @JsonBackReference("recipe-ri")
//    private Ingredient ingredient;
//
//    @Column(length = 50)
//    private String quantity;
}