package com.masai.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.support.DaoSupport;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.masai.exception.PlantException;
import com.masai.model.Plant;
import com.masai.service.PlantServices;



@RestController
public class PlantController {

	@Autowired
	private PlantServices plantServices;
//------------------------------------------------------------------------------------------------------------------------------	

	@PostMapping("/plants")
	public ResponseEntity<Plant> addPlantHandler(@RequestBody Plant plant) throws PlantException{
		
		Plant p= plantServices.addPlant(plant);
		
		return new ResponseEntity<Plant>(p,HttpStatus.OK);
		
		
	}
	
//-------------------------------------------------------------------------------------------------------
	
	
	@PutMapping("/plants")
	public ResponseEntity<Plant> updatePlantHandler(@RequestBody Plant plant) throws PlantException{
		
		Plant p= plantServices.updatePlant(plant);
		
		return new ResponseEntity<Plant>(p,HttpStatus.OK);
		
		
	}
	
//-------------------------------------------------------------------------------------------------------------------
	
	@DeleteMapping("/plants")
	public ResponseEntity<Plant> deletePlantHandler(@RequestBody Plant plant) throws PlantException{
		
		Plant p= plantServices.deletePlant(plant);
		
		return new ResponseEntity<Plant>(p,HttpStatus.OK);
		
		
	}
	
	
//--------------------------------------------------------------------------------------------------------------------	
	
	@GetMapping("/plants")
	public ResponseEntity<List<Plant>> getAllPlantsHandler() throws PlantException{
		
		 List<Plant> plants= plantServices.getAllPlants();
		
		return new ResponseEntity<List<Plant>>(plants,HttpStatus.OK);
		
		
	}

//-----------------------------------------------------------------------------------------------------------------------------------------------
	
	@GetMapping("/plants/{pid}")
	public ResponseEntity<Plant> getPlantByIdHandler(@PathVariable("pid") Integer id) throws PlantException{
		
		
		Plant plant= plantServices.getPlantById(id);
		
		return new ResponseEntity<Plant>(plant,HttpStatus.OK);
		
	}
	
	
//-------------------------------------------------------------------------------------------------------------------------------------------	
	
	@GetMapping("/getplant/{nam}")
	public ResponseEntity<List<Plant>> getPlantByNameHandler(@PathVariable("nam") String Name) throws PlantException{
		
		
		List<Plant> plant= plantServices.getPlantBycommonName(Name);
		
		return new ResponseEntity<List<Plant>>(plant,HttpStatus.OK);
		
	}
	
//--------------------------------------------------------------------------------------------------------------------	
	

	@GetMapping("/plantsList/{list}")
	public ResponseEntity<List<Plant>> getPlantBytypeOfPlantHandler(@PathVariable("list") String CName) throws PlantException{
		
		
		List<Plant> plant= plantServices.getplantByTypeOfPlant(CName);
		
		return new ResponseEntity<List<Plant>>(plant,HttpStatus.OK);
		
	}
	
	
}
