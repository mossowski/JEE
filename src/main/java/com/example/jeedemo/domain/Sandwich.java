package com.example.jeedemo.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@NamedQueries({ 
	@NamedQuery(name = "sandwich.all", query = "Select s from Sandwich s"),
	@NamedQuery(name = "sandwich.findByName", query = "Select s from Sandwich s where s.name LIKE :name")
})
public class Sandwich 
{
	private Long id;
    private String name;
    private int amount;
    private Date productionDate;
    private double price;
    private boolean vegetarian;
    private String breadColor;

    List<Ingredient> ingredients = new ArrayList<Ingredient>();
	Seller seller;
	Baker baker;
	
	public Sandwich() 
	{
		
	}
	
	public Sandwich(String name, int amount, Date productionDate, double price, boolean vegetarian, String breadColor) 
	{
	    super();
		this.name = name;
		this.amount = amount;
		this.productionDate = productionDate;
		this.price = price;
		this.vegetarian = vegetarian;
		this.breadColor = breadColor;
	}

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
	
	@Size(min = 3, max = 25)
    public String getName() 
	{
        return name;
    }
	
    public void setName(String name) 
    {
        this.name = name;
    }
    
    @Min(1) @Max(250)
    public int getAmount() 
    {
        return amount;
    }
    
    public void setAmount(int amount) 
    {
        this.amount = amount;
    }
    
    @Min(1) @Max(10) 
    public double getPrice() 
    {
        return price;
    }
    
    public void setPrice(double price) 
    {
        this.price = price;
    }
    
    public boolean getVegetarian() 
    {
        return vegetarian;
    }
    
    public void setVegetarian(boolean vegetarian) 
    {
        this.vegetarian = vegetarian;
    }

	@Temporal(TemporalType.DATE)
	public Date getProductionDate() 
	{
        return productionDate;
    }
	
    public void setProductionDate(Date productionDate) 
    {
        this.productionDate = productionDate;
    }
    
    @NotNull
    public String getBreadColor() 
    {
        return breadColor;
    }
    
    public void setBreadColor(String breadColor) 
    {
        this.breadColor = breadColor;
    }

	@ManyToMany
	public List<Ingredient> getIngredients() 
	{
		return ingredients;
	}
	
	public void setIngredients(List<Ingredient> ingredients) 
	{
		this.ingredients = ingredients;
	}
	
	@ManyToOne(optional = true)
	public Seller getSeller() 
	{
		return seller;
	}
	
	public void setSeller(Seller seller) 
	{
		this.seller = seller;
	}
	
	@OneToOne(optional=true, cascade= { CascadeType.DETACH })
    @JoinColumn(name="bakerId", unique=true, nullable=true, updatable=true)
    public Baker getBaker() 
	{
        return baker;
    }

    public void setBaker(Baker baker) 
    {
        this.baker = baker;
    }
}