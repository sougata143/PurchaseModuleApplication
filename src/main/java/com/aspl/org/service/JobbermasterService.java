package com.aspl.org.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.aspl.org.entity.JobberMaster;
import com.aspl.org.entity.ResponseDetails;

@Service
public interface JobbermasterService {

	
	JobberMaster jobberMasterSave(JobberMaster jobberMaster);
	
	public JobberMaster jobberMasterUpdate(JobberMaster currentJobber);
    //void itemMasterUpdate(ItemMaster currentItem);

	JobberMaster jobbermasterupdate(Optional<JobberMaster> jobberMaster1);
	JobberMaster jobbermasterupdate(JobberMaster jobberMaster);
	
	List<JobberMaster> getalljobberlist();

	
	//Optional<ItemMaster> findByItemCode(String itemCode);
    JobberMaster findByJobberCode(String jobberCode);
	

	JobberMaster findByJobberName(String jobberName);

	//int deleteItemById(Optional<ItemMaster> itemMaster);

	ResponseDetails deleteJobberMasterById(int jobberCode);
    void jobbermasterdelete(JobberMaster jobberMaster);
	
	
}
