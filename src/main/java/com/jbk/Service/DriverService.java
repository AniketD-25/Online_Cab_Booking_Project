package com.jbk.Service;

import java.util.List;

import com.jbk.Entity.Driver;
import com.jbk.Exception.DriverNotFoundException;
import com.jbk.Exception.InvalidId;

public interface DriverService {
	
	public Driver insertDriver(Driver driver);
	public Driver viewDriverById(Integer id) throws InvalidId, DriverNotFoundException;
	public Driver updateDriver(Integer id,Integer license, Boolean available)throws DriverNotFoundException;
	public String deleteDriverById(Integer id)throws DriverNotFoundException;
	public List<Driver> viewBestDriver()throws DriverNotFoundException;


}
