package com.example.jeedemo.web;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.faces.model.ListDataModel;
import javax.inject.Inject;
import javax.inject.Named;

import com.example.jeedemo.domain.Sandwich;
import com.example.jeedemo.service.SandwichManager;

@SessionScoped
@Named("sandwichBean")
public class SandwichFormBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private Sandwich sandwich = new Sandwich();
	private Long sellerId;
	private Long[] ingredientId = new Long[1];
	private Long bakerId;
	private String findName;
	
	private ListDataModel<Sandwich> sandwiches = new ListDataModel<Sandwich>();
	
	public Long[] getIngredientId() {
		return ingredientId;
	}
	
	public void setIngredientId(Long[] ingredientId) {
		this.ingredientId = ingredientId;
	}
	
	public Long getSellerId() {
        return sellerId;
    }

    public void setSellerId(Long sellerId) {
        this.sellerId = sellerId;
    }
    
    public Long getBakerId() {
        return bakerId;
    }

    public void setBakerId(Long bakerId) {
        this.bakerId = bakerId;
    }
		
	@Inject
	private SandwichManager sm;
		
	public Sandwich getSandwich() {
		return sandwich;
	}
	public void setSandwich(Sandwich sandwich) {
		this.sandwich = sandwich;
	}
	
	public String getFindName() {
        return findName;
    }

    public void setFindName(String findName) {
        this.findName = findName;
    }
	
	public ListDataModel<Sandwich> getAllSandwiches() {
		sandwiches.setWrappedData(sm.getAllSandwiches());
		return sandwiches;
	}

	// Actions
	public String addSandwich() {
		sm.addSandwich(sandwich, sellerId, ingredientId, bakerId);
		return "showSandwiches";
		//return null;
	}

	public String deleteSandwich() {
		Sandwich sandwichToDelete = sandwiches.getRowData();
		sm.deleteSandwich(sandwichToDelete);
		return null;
	}
	
	public String editSandwich() {
		sm.editSandwich(sandwich);
		return null;
	}
	
	public ListDataModel<Sandwich> findSandwichByName() {
		sandwiches.setWrappedData(sm.findSandwichByName(findName));
		return sandwiches;
	}
}
