package com.aspl.org.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aspl.org.entity.ContactsDetails;

@Repository
public interface ContactsDetailsDao extends JpaRepository<ContactsDetails, Integer> {
	List<ContactsDetails> findByVendorId(Integer vendorId);
	List<ContactsDetails> findByCustomerId(Integer customerId);
}
