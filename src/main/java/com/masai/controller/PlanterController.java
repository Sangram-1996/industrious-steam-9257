package com.masai.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.masai.exception.PlanterException;
import com.masai.model.Planter;
import com.masai.service.PlanterService;

@RestController
public class PlanterController {
	
	@Autowired
	private PlanterService planterService;
	
		// Working: 
		/* POST: Add/Save Planter */
		@PostMapping("planter")
		public ResponseEntity<Planter> addPlanter(@Valid @RequestBody Planter planter) {
			Planter plant = planterService.addPlanter(planter);
					
			return new ResponseEntity<Planter>(plant, HttpStatus.CREATED);
		}
		
		// Working: 
		/* PUT: Update Planter */
		@PutMapping("/planter")
		public ResponseEntity<Planter> updatePlanter(@Valid @RequestBody Planter planter) throws PlanterException {
			
			Planter updatedPlant = planterService.updatePlanter(planter);
					
			return new ResponseEntity<Planter>(updatedPlant, HttpStatus.OK);
		}
		
		// Working: 
		/* DELETE: Delete Planter */
		@DeleteMapping("/planter")
		public ResponseEntity<Planter> deletePlanterHandler(@Valid @RequestBody Planter planter) throws PlanterException {
			
			Planter deletedPlanter = planterService.deletePlanter(planter);
					
			return new ResponseEntity<Planter>(deletedPlanter, HttpStatus.OK);
		}
		
		// Working:
		/* GET: PLANTERS by planterId */
		@GetMapping("/planters/id/{id}")               /* doubt: planterId has been declared with int, should it be changed to Integer */
		public ResponseEntity<Planter> viewPlanterHandler(@Valid @PathVariable("id") int planterId) throws PlanterException {
			
			Planter obtainedPlanter = planterService.viewPlanter(planterId);
					
			return new ResponseEntity<Planter>(obtainedPlanter, HttpStatus.OK);
		}
		
		// NOT Working:
		/* GET: PLANTERS by planterShape */
		@GetMapping("/planters/shape/{shape}")               /* doubt: planterId has been declared with int, should it be changed to Integer */
		public ResponseEntity<Planter> viewPlanterByShape(@Valid @PathVariable("shape") String planterShape) throws PlanterException {
			
			Planter planter = planterService.viewPlanter(planterShape);
					
			return new ResponseEntity<Planter>(planter, HttpStatus.OK);
		}
		
		// Working:
		/* GET: Find ALL PLANTERS */
		@GetMapping("/planters")              
		public ResponseEntity<List<Planter>> findAllPlanters() throws PlanterException {
			
			List<Planter> planterList = planterService.viewAllPlanters();
					
			return new ResponseEntity<List<Planter>>(planterList, HttpStatus.OK);
		}
		
		// Working:
		/* GET: Find PLANTERS by COST RANGE */
		@GetMapping("/planters/{minCost}/{maxCost}")   
		public ResponseEntity<List<Planter>> viewPlantersByCostRange(@Valid @PathVariable("minCost") Integer minCost, @PathVariable("maxCost") Integer maxCost) throws PlanterException {
			
			List<Planter> planterList = planterService.viewAllPlanters(minCost, maxCost);
			
			return new ResponseEntity<List<Planter>>(planterList, HttpStatus.OK);
		}
		

}
