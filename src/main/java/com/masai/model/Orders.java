package com.masai.model;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
public class Orders {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer orderId;
	private LocalDate localDate;
	
	@NotNull(message="Transaction Mode Can't be null")
	private String TransactionMode;
	
	@Min(value=1,message="Quantity greater than 1")
	private Integer quantity;
	
	@Min(value = 1, message = "Cost should be greater than 1")
	private Integer totalCost;
	
	@OneToOne(cascade = CascadeType.ALL)
	private @Valid Planter planters;
	
	public Orders(Integer orderId, LocalDate localDate, String transactionMode, Integer quantity, Integer totalCost,
			Planter planters) {
		super();
		this.orderId = orderId;
		this.localDate = localDate;
		this.TransactionMode = transactionMode;
		this.quantity = quantity;
		this.totalCost = totalCost;
		this.planters = planters;
	}
	public Orders() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String toString() {
		return "Orders [orderId=" + orderId + ", localDate=" + localDate + ", TransactionMode=" + TransactionMode
				+ ", quantity=" + quantity + ", totalCost=" + totalCost + ", planters=" + planters + "]";
	}
	public Integer getOrderId() {
		return orderId;
	}
	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}
	public LocalDate getLocalDate() {
		return localDate;
	}
	public void setLocalDate(LocalDate localDate) {
		this.localDate = localDate;
	}
	public String getTransactionMode() {
		return TransactionMode;
	}
	public void setTransactionMode(String transactionMode) {
		TransactionMode = transactionMode;
	}
	
	public Integer getQuantity() {
		return quantity;
	}
	
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public Integer getTotalCost() {
		return totalCost;
	}
	public void setTotalCost(Integer totalCost) {
		this.totalCost = totalCost;
	}
	public Planter getPlanters() {
		return planters;
	}
	public void setPlanters(Planter planters) {
		this.planters = planters;
	}
	
	
	
}
