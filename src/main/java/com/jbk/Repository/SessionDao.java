package com.jbk.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jbk.Entity.CurrentUserSession;


@Repository
public interface SessionDao extends JpaRepository<CurrentUserSession, Integer>{
	
	public Optional<CurrentUserSession> findById(Integer userId);
	
	public Optional<CurrentUserSession> findByUuid(String uuid);
}
