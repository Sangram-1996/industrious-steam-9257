package com.masai.service;

import java.util.List;

import com.masai.exception.SeedException;
import com.masai.model.Seed;

public interface SeedServices {

    public Seed addSeed(Seed seed)throws SeedException;
	
	public Seed updateSeed(Seed seed)throws SeedException;

	public Seed deleteSeed(Seed seed)throws SeedException;

	public List<Seed> getAllSeeds()throws SeedException;

	public Seed getSeedById(Integer seedId) throws SeedException;

	public List<Seed> getSeedBycommonName(String commonName) throws SeedException;
	
	public List<Seed> getseedByTypeOfSeed(String typeOfSeeds) throws SeedException;

	
	
}
