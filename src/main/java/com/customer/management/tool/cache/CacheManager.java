package com.customer.management.tool.cache;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.customer.management.tool.impl.CMTImpl;
import com.customer.management.tool.pojo.Category;

@Component
public class CacheManager {

	@Autowired
	private CMTImpl cmtImpl;
	
	public static final Map<Integer, String> categoryMap = new HashMap<>();
	
	public void insertInCategoryMap(){
		
		List<Category> response = cmtImpl.getAllCategories();
		if(!StringUtils.isEmpty(response) && !response.isEmpty()){
			for(Category cmtCategory : response){
				categoryMap.put(cmtCategory.getId(), cmtCategory.getName());
			}
		}
	}
}
