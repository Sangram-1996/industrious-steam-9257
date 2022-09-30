package com.masai.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.masai.exception.PlanterException;
import com.masai.model.Planter;


public interface PlanterService {
	
	Planter addPlanter(Planter planter);

	Planter updatePlanter(Planter planter) throws PlanterException;

	Planter deletePlanter(Planter planter) throws PlanterException;

	Planter viewPlanter(Integer planterId) throws PlanterException;

	Planter viewPlanter(String planterShape) throws PlanterException;
	
	List<Planter> viewAllPlanters() throws PlanterException;

	List<Planter> viewAllPlanters(Integer minCost, Integer maxCost) throws PlanterException;
	
}
