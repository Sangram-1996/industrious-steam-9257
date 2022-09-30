package com.masai.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.masai.Exception.PlantException;
import com.masai.Exception.SeedException;
import com.masai.Service.SeedServices;
import com.masai.model.Plant;
import com.masai.model.Seed;

@RestController
public class SeedController {

	@Autowired
	private SeedServices seedServices;
	
	//------------------------------------------------------------------------------------------------------------------------------	

		@PostMapping("/seeds")
		public ResponseEntity<Seed> addSeedHandler(@RequestBody Seed seed) throws SeedException{
			
			 Seed s= this.seedServices.addSeed(seed);
			
			return new ResponseEntity<Seed>(s,HttpStatus.OK);
			
			
		}
		
	//-------------------------------------------------------------------------------------------------------
		
		
		@PutMapping("/seeds")
		public ResponseEntity<Seed> updateSeedHandler(@RequestBody Seed seed) throws SeedException{
			
			Seed p= this.seedServices.updateSeed(seed);
			
			return new ResponseEntity<Seed>(p,HttpStatus.OK);
			
			
		}
		
	//-------------------------------------------------------------------------------------------------------------------
		
		@DeleteMapping("/seeds")
		public ResponseEntity<Seed> deleteSeedHandler(@RequestBody Seed seed) throws SeedException{
			
			Seed s= this.seedServices.deleteSeed(seed);
			
			return new ResponseEntity<Seed>(s,HttpStatus.OK);
			
			
		}
		
		
	//--------------------------------------------------------------------------------------------------------------------	
		
		@GetMapping("/seeds")
		public ResponseEntity<List<Seed>> getAllSeedsHandler() throws SeedException{
			
			 List<Seed> seeds= this.seedServices.getAllSeeds();
			
			return new ResponseEntity<List<Seed>>(seeds,HttpStatus.OK);
			
			
		}

	//-----------------------------------------------------------------------------------------------------------------------------------------------
		
		@GetMapping("/seeds/{pid}")
		public ResponseEntity<Seed> getSeedByIdHandler(@PathVariable("pid") Integer id) throws SeedException{
			
			
			Seed seed= this.seedServices.getSeedById(id);
			
			return new ResponseEntity<Seed>(seed,HttpStatus.OK);
			
		}
		
		
	//-------------------------------------------------------------------------------------------------------------------------------------------	
		
		@GetMapping("/getseeds/{nam}")
		public ResponseEntity<List<Seed>> getSeedByNameHandler(@PathVariable("nam") String Name) throws SeedException{
			
			
			List<Seed> seed= this.seedServices.getSeedBycommonName(Name);
			
			return new ResponseEntity<List<Seed>>(seed,HttpStatus.OK);
			
		}
		
	//--------------------------------------------------------------------------------------------------------------------	
		

		@GetMapping("/seedsList/{list}")
		public ResponseEntity<List<Seed>> getPlantBytypeOfSeedHandler(@PathVariable("list") String CName) throws SeedException{
			
			
			List<Seed> seeds= this.seedServices.getseedByTypeOfSeed(CName);
			
			return new ResponseEntity<List<Seed>>(seeds,HttpStatus.OK);
			
		}
	

}
