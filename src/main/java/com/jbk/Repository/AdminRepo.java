package com.jbk.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.jbk.Entity.*;

public interface AdminRepo extends JpaRepository<Admin, Integer> {

}
