package com.masai.service;

import java.util.List;


import com.masai.exception.PlantException;
import com.masai.model.Plant;


public interface PlantServices {

	public Plant addPlant(Plant plant)throws PlantException;
	
	public Plant updatePlant(Plant plant)throws PlantException;

	public Plant deletePlant(Plant plant)throws PlantException;

	public List<Plant> getAllPlants()throws PlantException;

	public Plant getPlantById(Integer id) throws PlantException;

	public List<Plant> getPlantBycommonName(String commonName) throws PlantException;
	
	public List<Plant> getplantByTypeOfPlant(String typeOfPlant) throws PlantException;

	
}
