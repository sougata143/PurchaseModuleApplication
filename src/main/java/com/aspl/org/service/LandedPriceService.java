package com.aspl.org.service;

import java.util.List;

import com.aspl.org.dto.LandedPriceDTO;
import com.aspl.org.entity.ResponseDetails;

public interface LandedPriceService {
	
	LandedPriceDTO landedPriceSave(LandedPriceDTO landedPrice);
	public LandedPriceDTO landedPriceUpdate(LandedPriceDTO currentItem);
    List<LandedPriceDTO> getallitemlist();
	LandedPriceDTO getLandedPriceById(Integer id);
	List<LandedPriceDTO> getLandedPriceForItem(Integer itemID);
	ResponseDetails permDeleteLandedPriceById(int landedPriceId);
    String softDeleteLandedPrice(Integer id);
    List<LandedPriceDTO> getLandedPriceByCategoryId(Integer categoryId);
    List<LandedPriceDTO> getLandedPriceBySubCategoryId(Integer subCategoryId);

}
