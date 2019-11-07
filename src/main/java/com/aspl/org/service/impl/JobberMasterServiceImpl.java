package com.aspl.org.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aspl.org.entity.JobberMaster;
import com.aspl.org.entity.ResponseDetails;
import com.aspl.org.repository.JobberMasterDao;
import com.aspl.org.service.JobbermasterService;

@Service
@Transactional
public class JobberMasterServiceImpl implements JobbermasterService {

	
	@Autowired 
	JobberMasterDao jobberMasterDao;
	
	

	@Override
	public JobberMaster jobbermasterupdate(Optional<JobberMaster> jobberMaster1) {

		return jobberMasterDao.save(jobberMaster1);
	}

	@Override
	public JobberMaster jobbermasterupdate(JobberMaster jobberMaster) {
		return jobberMasterDao.save(jobberMaster);
	}
	
	@Override
	public void jobbermasterdelete(JobberMaster jobberMaster) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<JobberMaster> getalljobberlist() {
		return jobberMasterDao.findAll();
	}

	@Override
	public JobberMaster findByJobberName(String jobberName) {
		
		//int item_code=Integer.parseInt(itemName);
		  JobberMaster jobberMaster = jobberMasterDao.findByJobberName(jobberName);
		
		return jobberMaster;

	}
	
	
	/*
	 * @Override public Optional<ItemMaster> findByItemCode(String itemCode) {
	 * ("itemCode: "+itemCode); //int
	 * item_code=Integer.parseInt(itemCode); //Optional<ItemMaster>
	 * itemMaster=itemMasterDao.findByItemCode(itemCode); Optional<ItemMaster>
	 * itemMaster=itemMasterDao.findByItemCode(itemCode); //ItemMaster
	 * itemMaster=itemMasterDao.findById(item_code); return itemMaster;
	 * 
	 * }
	 */
	  @Override
	  public JobberMaster findByJobberCode(String jobberCode) {
	  
	  //int item_code=Integer.parseInt(itemCode);
	  //Optional<ItemMaster> itemMaster=itemMasterDao.findByItemCode(itemCode);
	  JobberMaster jobberMaster=jobberMasterDao.findByJobberCode(jobberCode);
	  //ItemMaster itemMaster=itemMasterDao.findById(item_code);
	  return jobberMaster;
	  
	  }
	

	@Override
	public JobberMaster jobberMasterSave(JobberMaster jobberMaster) {
	
		return jobberMasterDao.save(jobberMaster);
	}
	
	@Override
	public JobberMaster jobberMasterUpdate(JobberMaster currentJobber) {

		return jobberMasterSave(currentJobber);
	}

	@Override
	public ResponseDetails deleteJobberMasterById(int jobberCode) {
		jobberMasterDao.deleteById(jobberCode);
		return new ResponseDetails(new Date(), "Deleted" , null);
	}


	/*
	 * public void deleteUserById(Long id){ userRepository.delete(id); }
	 */
}
