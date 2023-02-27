package com.jbk.Service;

import java.util.List;

import com.jbk.Entity.TripBooking;
import com.jbk.Exception.DriverNotFoundException;
import com.jbk.Exception.InvalidId;

public interface TripService {
	
	public TripBooking AddTrip(TripBooking tb) throws InvalidId, DriverNotFoundException;
	public List<TripBooking> alltrip();
	public TripBooking updateTrip(TripBooking tb,Integer id)throws InvalidId;
	public String deletetrip(Integer id) throws InvalidId;
	public TripBooking tripEnd(Integer id)throws InvalidId;

}
