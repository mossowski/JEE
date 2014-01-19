package com.example.jeedemo.web;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.faces.model.ListDataModel;
import javax.inject.Inject;
import javax.inject.Named;

import com.example.jeedemo.domain.Ingredient;
import com.example.jeedemo.service.IngredientManager;

@SessionScoped
@Named("ingredientBean")
public class IngredientFormBean implements Serializable 
{

    private static final long serialVersionUID = 1L;

    private Ingredient ingredient = new Ingredient();
    private ListDataModel<Ingredient> ingredients = new ListDataModel<Ingredient>();

    @Inject
    private IngredientManager im;
        
    public Ingredient getIngredient() 
    {
        return ingredient;
    }

    public void setIngredient(Ingredient ingredient) 
    {
        this.ingredient = ingredient;
    }

    public ListDataModel<Ingredient> getAllIngredients() 
    {
        ingredients.setWrappedData(im.getAllIngredients());
        return ingredients;
    }
        
    public String addIngredient() 
    {
        im.addIngredient(ingredient);
        //return "list";
        return null;
    }
        
    public String deleteIngredient() 
    {
        Ingredient ingredientToDelete = ingredients.getRowData();
        im.deleteIngredient(ingredientToDelete);
    	return null;
    }
        
    public String editIngredient() 
    {
        im.editIngredient(ingredient);
    	return null;
    }
}