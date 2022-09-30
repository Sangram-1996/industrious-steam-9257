package com.masai.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Planter {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer planterId;
	
	@Min(value = 1, message = "Planter's Height can't be 0")
	private Float planterheight;
	
	@Min(value = 1, message = "Planter's Capacity can't be 0")
	private Integer planterCapacity;
	
	@Min(value = 1, message = "Planter's Drinage Hole can't be 0")
	private Integer drinageHoles;
	
	@NotBlank(message = "Planter's color can't be blank")
	private String planterColor;
	
	@NotBlank(message = "Planter's shape can't be blank")
	private String planterShape;
	
	@Min(value = 0, message = "Planter's stock can't be negative")
	private Integer planterStock;
	
	@Min(value = 1, message = "Planter's cost can't be 0")
	private Integer planterCost;
	
	/*
	// Assuming that each Planter object is mapped to One Plant object

	@OneToOne(cascade = CascadeType.ALL)
	@Valid private Plant plants;   
	
	// Assuming that each Planter object is mapped to One Seed object
	@OneToOne(cascade = CascadeType.ALL)
	@Valid private Seed seeds;
	
	*/
	
	
	/* ------------------------------Default Constructor--------------------*/
	public Planter() {
		
	}

	/* ------------------------------Parameterised Constructor--------------------*/
	public Planter(Integer planterId, @Min(value = 1, message = "Planter's Height can't be 0") Float planterheight,
			@Min(value = 1, message = "Planter's Capacity can't be 0") Integer planterCapacity,
			@Min(value = 1, message = "Planter's Drinage Hole can't be 0") Integer drinageHoles,
			@NotBlank(message = "Planter's color can't be blank") String planterColor,
			@NotBlank(message = "Planter's shape can't be blank") String planterShape,
			@Min(value = 0, message = "Planter's stock can't be negative") Integer planterStock,
			@Min(value = 1, message = "Planter's cost can't be 0") Integer planterCost) {
		super();
		this.planterId = planterId;
		this.planterheight = planterheight;
		this.planterCapacity = planterCapacity;
		this.drinageHoles = drinageHoles;
		this.planterColor = planterColor;
		this.planterShape = planterShape;
		this.planterStock = planterStock;
		this.planterCost = planterCost;
	}

	
	/* ----------------------------------toString------------------------------------------*/
	@Override
	public String toString() {
		return "Planter [planterId=" + planterId + ", planterheight=" + planterheight + ", planterCapacity="
				+ planterCapacity + ", drinageHoles=" + drinageHoles + ", planterColor=" + planterColor
				+ ", planterShape=" + planterShape + ", planterStock=" + planterStock + ", planterCost=" + planterCost
				+ "]";
	}

	
	/* ------------------------------Getters & Setters--------------------*/
	public Integer getPlanterId() {
		return planterId;
	}

	public void setPlanterId(Integer planterId) {
		this.planterId = planterId;
	}

	public Float getPlanterheight() {
		return planterheight;
	}

	public void setPlanterheight(Float planterheight) {
		this.planterheight = planterheight;
	}

	public Integer getPlanterCapacity() {
		return planterCapacity;
	}

	public void setPlanterCapacity(Integer planterCapacity) {
		this.planterCapacity = planterCapacity;
	}

	public Integer getDrinageHoles() {
		return drinageHoles;
	}

	public void setDrinageHoles(Integer drinageHoles) {
		this.drinageHoles = drinageHoles;
	}

	public String getPlanterColor() {
		return planterColor;
	}

	public void setPlanterColor(String planterColor) {
		this.planterColor = planterColor;
	}

	public String getPlanterShape() {
		return planterShape;
	}

	public void setPlanterShape(String planterShape) {
		this.planterShape = planterShape;
	}

	public Integer getPlanterStock() {
		return planterStock;
	}

	public void setPlanterStock(Integer planterStock) {
		this.planterStock = planterStock;
	}

	public Integer getPlanterCost() {
		return planterCost;
	}

	public void setPlanterCost(Integer planterCost) {
		this.planterCost = planterCost;
	}
	
	
}
