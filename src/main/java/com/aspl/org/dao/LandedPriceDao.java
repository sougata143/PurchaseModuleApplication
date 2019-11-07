package com.aspl.org.dao;

import com.aspl.org.entity.LandedPrice;
import com.aspl.org.entity.StoreDetails;

public interface LandedPriceDao {
	LandedPrice findByItemCode(StoreDetails storeDetails);
	

}
