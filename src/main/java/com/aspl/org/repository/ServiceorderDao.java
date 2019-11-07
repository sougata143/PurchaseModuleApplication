package com.aspl.org.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.aspl.org.entity.Serviceorder;


@Repository
public interface ServiceorderDao extends JpaRepository<Serviceorder, Integer> {
	
	@Query("Select ai from Serviceorder ai where ai.accepted=0 and ai.serviceCode=?1")
	Serviceorder findByServiceCode(String serviceCode);
	
	List<Serviceorder> findByAccepted(Integer accepted);
	List<Serviceorder> findByIsActive(Integer isActive);

}
