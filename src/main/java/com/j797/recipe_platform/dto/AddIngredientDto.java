package com.j797.recipe_platform.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddIngredientDto {
    @NotNull
    private Long ingredientId;

    @NotBlank
    private String quantity;
}
