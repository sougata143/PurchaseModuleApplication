package com.aspl.org.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aspl.org.entity.CompanyMaster;

@Repository
public interface CompanyMasterDao extends JpaRepository<CompanyMaster, Integer> {
	CompanyMaster findByCompanyName(String companyName);

	
}
