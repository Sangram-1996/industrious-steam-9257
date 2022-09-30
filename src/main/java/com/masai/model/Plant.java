package com.masai.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Data
@NoArgsConstructor
@ToString
@AllArgsConstructor
@Entity
public class Plant {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer plantId;
	
	@NotNull
	private Integer plantHeight;

	@NotNull
	private String plantSpread;
	
	private String commonName;
	
	private String bloomTime;
	
	private String medicinalUse;
	
	@NotNull
	private String difficultyLevel;
	
	private String temperature;
	
	@NotNull
	private String typeOfPlant;
	
	private String plantDescription;
	
	@NotNull
	private Integer plantsStock;
	
	@NotNull
	private Integer plantsCost;

	public Plant() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Plant(Integer plantId, Integer plantHeight, String plantSpread, String commonName, String bloomTime,
			String medicinalUse, String difficultyLevel, String temperature, String typeOfPlant,
			String plantDescription, Integer plantsStock, Integer plantsCost) {
		super();
		this.plantId = plantId;
		this.plantHeight = plantHeight;
		this.plantSpread = plantSpread;
		this.commonName = commonName;
		this.bloomTime = bloomTime;
		this.medicinalUse = medicinalUse;
		this.difficultyLevel = difficultyLevel;
		this.temperature = temperature;
		this.typeOfPlant = typeOfPlant;
		this.plantDescription = plantDescription;
		this.plantsStock = plantsStock;
		this.plantsCost = plantsCost;
	}

	public Integer getPlantId() {
		return plantId;
	}

	public void setPlantId(Integer plantId) {
		this.plantId = plantId;
	}

	public Integer getPlantHeight() {
		return plantHeight;
	}

	public void setPlantHeight(Integer plantHeight) {
		this.plantHeight = plantHeight;
	}

	public String getPlantSpread() {
		return plantSpread;
	}

	public void setPlantSpread(String plantSpread) {
		this.plantSpread = plantSpread;
	}

	public String getCommonName() {
		return commonName;
	}

	public void setCommonName(String commonName) {
		this.commonName = commonName;
	}

	public String getBloomTime() {
		return bloomTime;
	}

	public void setBloomTime(String bloomTime) {
		this.bloomTime = bloomTime;
	}

	public String getMedicinalUse() {
		return medicinalUse;
	}

	public void setMedicinalUse(String medicinalUse) {
		this.medicinalUse = medicinalUse;
	}

	public String getDifficultyLevel() {
		return difficultyLevel;
	}

	public void setDifficultyLevel(String difficultyLevel) {
		this.difficultyLevel = difficultyLevel;
	}

	public String getTemperature() {
		return temperature;
	}

	public void setTemperature(String temperature) {
		this.temperature = temperature;
	}

	public String getTypeOfPlant() {
		return typeOfPlant;
	}

	public void setTypeOfPlant(String typeOfPlant) {
		this.typeOfPlant = typeOfPlant;
	}

	public String getPlantDescription() {
		return plantDescription;
	}

	public void setPlantDescription(String plantDescription) {
		this.plantDescription = plantDescription;
	}

	public Integer getPlantsStock() {
		return plantsStock;
	}

	public void setPlantsStock(Integer plantsStock) {
		this.plantsStock = plantsStock;
	}

	public double getPlantsCost() {
		return plantsCost;
	}

	public void setPlantsCost(Integer plantsCost) {
		this.plantsCost = plantsCost;
	}


	
}
