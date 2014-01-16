package com.example.jeedemo.web;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.faces.model.ListDataModel;
import javax.inject.Inject;
import javax.inject.Named;

import com.example.jeedemo.domain.Seller;
import com.example.jeedemo.service.SellerManager;

@SessionScoped
@Named("sellerBean")
public class SellerFormBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Seller seller = new Seller();

	private ListDataModel<Seller> sellers = new ListDataModel<Seller>();
 
	@Inject
	private SellerManager sm;
	
	public Seller getSeller() {
		return seller;
	}
	
	public void setSeller(Seller seller) {
		this.seller = seller;
	}
	
	public ListDataModel<Seller> getAllSellers() {
        sellers.setWrappedData(sm.getAllSellers());
        return sellers;
    }

    // Actions

    public String addSeller() {
        sm.addSeller(seller);
        //return "list";
        return null;
    }
    
    public String deleteSeller() {
    	Seller sellerToDelete = sellers.getRowData();
		sm.deleteSeller(sellerToDelete);
		return null;
	}
    
    public String editSeller() {
		sm.editSeller(seller);
		return null;
	}
}
