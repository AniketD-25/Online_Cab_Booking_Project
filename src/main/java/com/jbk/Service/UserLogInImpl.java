package com.jbk.Service;

import java.time.LocalDateTime;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jbk.Entity.CurrentUserSession;
import com.jbk.Entity.Customer;
import com.jbk.Entity.CustomerDTO;
import com.jbk.Exception.AdminExceptions;
import com.jbk.Exception.InvalidPasswordException;
import com.jbk.Exception.NotFoundException;
import com.jbk.Exception.UserAlreadyExistWithuserId;
import com.jbk.Repository.AdminRepo;
import com.jbk.Repository.CustomerDao;
import com.jbk.Repository.DriverDao;
import com.jbk.Repository.SessionDao;

import net.bytebuddy.utility.RandomString;

@Service
public class UserLogInImpl implements UserLogIn {
	@Autowired
	private AdminRepo adminDao;

	@Autowired
	private DriverDao driverDao;

	@Autowired
	private CustomerDao customerDao;

	@Autowired
	private SessionDao sessionDao;

	@Override
	public String logIntoAccount(CustomerDTO userDto) {
		Optional<Customer> opt_customer = customerDao.findById(userDto.getUserId());

		Integer userId = opt_customer.get().getUserId();

		Optional<CurrentUserSession> currentUserOptional = sessionDao.findById(userId);

		if (!opt_customer.isPresent()) {
			throw new AdminExceptions("user not found");
		}
		if (currentUserOptional.isPresent()) {
			throw new UserAlreadyExistWithuserId("User already logged in with this number");
		}
		if (opt_customer.get().getPassword().equals(userDto.getPassword())) {
			String key = RandomString.make(6);
			CurrentUserSession currentUserSession = new CurrentUserSession(opt_customer.get().getUserId(), key,
					LocalDateTime.now());
			sessionDao.save(currentUserSession);

			return currentUserSession.toString();
		} else {
			throw new InvalidPasswordException("Please Enter Valid Password");
		}

	}

	@Override
	public String logOutFromAccount(String key) {
		Optional<CurrentUserSession> currentUserOptional = sessionDao.findByUuid(key);

		if (!currentUserOptional.isPresent()) {
			throw new NotFoundException("User is not logged in with this number");
		}

		CurrentUserSession currentUserSession = currentUserOptional.get();
		sessionDao.delete(currentUserSession);

		return "Logged Out...";
	}

}
