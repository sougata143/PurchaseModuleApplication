package com.aspl.org.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.aspl.org.entity.ServiceorderDetails;

@Repository
public interface ServiceorderDetailsDao extends JpaRepository<ServiceorderDetails, Integer> {
	List<ServiceorderDetails> findBySoid(Integer soId);

}
