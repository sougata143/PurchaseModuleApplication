package com.aspl.org.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aspl.org.entity.JobberMaster;


@Repository
public interface JobberMasterDao extends JpaRepository<JobberMaster, Integer> {

	JobberMaster findByJobberName(String jobberName);
	
	JobberMaster findByJobberCode(String jobberCode);
	//Optional<ItemMaster> findByItemCode(String itemCode);

	JobberMaster save(Optional<JobberMaster> jobberMaster1);

	//Optional<ItemMaster> load(Class<ItemMaster> class1, int item_code);

	//Optional<ItemMaster> findById(String itemCode);
	//ItemMaster findById(int item_code);

	int deleteById(int jobberCode);
}
