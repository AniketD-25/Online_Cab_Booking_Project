package com.jbk.Service;

import java.util.List;

import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;

import com.jbk.Entity.Cab;

public interface CabService {
	
	public Cab insertCab(Cab cab);
	
	public Cab updateCab(Integer id,String type, Integer rate) throws NotFoundException;
	
	public Cab deleteCab(Integer id) throws NotFoundException;
	
	public List<String> viewCabsOfType() throws NotFoundException;
	
	public int countCabsOfType() throws NotFoundException;

}
