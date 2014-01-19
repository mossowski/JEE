package com.example.jeedemo.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@NamedQueries({ 
        @NamedQuery(name = "ingredient.all", query = "Select i from Ingredient i")
})

public class Ingredient 
{	
	private Long id;
	private String name;
	
	List<Sandwich> sandwiches = new ArrayList<Sandwich>();
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId() 
	{
        return id;
    }

    public void setId(Long id) 
    {
        this.id = id;
    }
    
    public String getName() 
    {
        return name;
    }

    public void setName(String name) 
    {
        this.name = name;
    }
    
    @ManyToMany(mappedBy = "ingredients")
    public List<Sandwich> getSandwiches() 
    {
        return sandwiches;
    }

    public void setSandwiches(List<Sandwich> sandwiches) 
    {
        this.sandwiches = sandwiches;
    }
}