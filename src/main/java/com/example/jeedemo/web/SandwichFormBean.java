package com.example.jeedemo.web;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.faces.model.ListDataModel;
import javax.inject.Inject;
import javax.inject.Named;

<<<<<<< HEAD
=======
import com.example.jeedemo.domain.Seller;
>>>>>>> c8f944735c8885c53dfbc33f62636dba43e98556
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
	
<<<<<<< HEAD
	public Long[] getIngredientId() {
		return ingredientId;
	}
	
	public void setIngredientId(Long[] ingredientId) {
		this.ingredientId = ingredientId;
	}
	
	public Long getSellerId() {
        return sellerId;
    }
=======
	private Sandwich sandwichToShow = new Sandwich();
	private ListDataModel<Seller> ownedSellers = new ListDataModel<Seller>();
>>>>>>> c8f944735c8885c53dfbc33f62636dba43e98556

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

<<<<<<< HEAD
=======
	public ListDataModel<Seller> getOwnedSellers() {
		ownedSellers.setWrappedData(pm.getOwnedSellers(sandwichToShow));
		return ownedSellers;
	}
	
>>>>>>> c8f944735c8885c53dfbc33f62636dba43e98556
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
	
<<<<<<< HEAD
	public ListDataModel<Sandwich> findSandwichByName() {
		sandwiches.setWrappedData(sm.findSandwichByName(findName));
		return sandwiches;
=======
	public String disposeSeller(){
		Seller sellerToDispose = ownedSellers.getRowData();
		sm.disposeSeller(sandwichToShow, sellerToDispose);
		return null;
>>>>>>> c8f944735c8885c53dfbc33f62636dba43e98556
	}
}
