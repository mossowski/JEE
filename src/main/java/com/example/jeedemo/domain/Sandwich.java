package com.example.jeedemo.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@NamedQueries({ 
	@NamedQuery(name = "sandwich.all", query = "Select s from Sandwich s")
})
public class Sandwich {

	private Long id;

	private String name = "";
    private int amount;
    private Date productionDate;
    private double price;
    private boolean vegetarian;
    private String breadColor;

	private List<Car> cars = new ArrayList<Car>();

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	@Size(min = 3, max = 25)
    public String getName() {
            return name;
    }
	
    public void setName(String name) {
            this.name = name;
    }
    
    @Min(1) @Max(250)
    public int getAmount() {
            return amount;
    }
    public void setAmount(int amount) {
            this.amount = amount;
    }
    
    @Min(1) @Max(10) 
    public double getPrice() {
            return price;
    }
    public void setPrice(double price) {
            this.price = price;
    }
    public boolean getVegetarian() {
            return vegetarian;
    }
    public void setVegetarian(boolean vegetarian) {
            this.vegetarian = vegetarian;
    }


	@Temporal(TemporalType.DATE)
	public Date getProductionDate() {
        return productionDate;
    }
	
    public void setProductionDate(Date productionDate) {
        this.productionDate = productionDate;
    }
    
    @NotNull
    public String getBreadColor() {
            return breadColor;
    }
    public void setBreadColor(String breadColor) {
            this.breadColor = breadColor;
    }

	// Be careful here, both with lazy and eager fetch type
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	public List<Car> getCars() {
		return cars;
	}
	public void setCars(List<Car> cars) {
		this.cars = cars;
	}
}
