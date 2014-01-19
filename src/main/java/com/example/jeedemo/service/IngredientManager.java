package com.example.jeedemo.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.example.jeedemo.domain.Ingredient;

@Stateless
public class IngredientManager 
{	
	@PersistenceContext
    EntityManager em;
    
    public void addIngredient(Ingredient ingredient) 
    {
        ingredient.setId(null);
        em.persist(ingredient);
    }
    
    public void deleteIngredient(Ingredient ingredient) 
    {
    	ingredient = em.find(Ingredient.class, ingredient.getId());
		em.remove(ingredient);
	}
    
    public void editIngredient(Ingredient ingredientToChange) 
    {
        em.merge(ingredientToChange);
    }
        
    @SuppressWarnings("unchecked")
    public List<Ingredient> getAllIngredients() 
    {
        return em.createNamedQuery("ingredient.all").getResultList();
    }
}