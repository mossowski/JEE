package com.example.jeedemo.web;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.example.jeedemo.domain.Seller;
import com.example.jeedemo.domain.Sandwich;
import com.example.jeedemo.service.SandwichManager;
import com.example.jeedemo.service.SellingManager;

@SessionScoped
@Named("saleBean")
public class SaleFormBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private SellingManager sm;

	@Inject
	private SandwichManager pm;

	private Long sellerId;
	private Long sandwichId;
	
	public Long getSellerId() {
		return sellerId;
	}
	public void setSellerId(Long sellerId) {
		this.sellerId = sellerId;
	}
	public Long getSandwichId() {
		return sandwichId;
	}
	public void setSandwichId(Long sandwichId) {
		this.sandwichId = sandwichId;
	}

	public List<Seller> getAvailableSellers() {
		return sm.getAvailableSellers();
	}

	public List<Sandwich> getAllSandwiches() {
		return pm.getAllSandwiches();
	}

	public String removeSeller() {
		sm.removeSeller(sandwichId, sellerId);
		return null;
	}
}
