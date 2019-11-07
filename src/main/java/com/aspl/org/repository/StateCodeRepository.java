package com.aspl.org.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aspl.org.entity.StateCodeMaster;

@Repository
public interface StateCodeRepository extends JpaRepository<StateCodeMaster, Integer> {

	StateCodeMaster findByStateCode(String stateCode);
	
}
