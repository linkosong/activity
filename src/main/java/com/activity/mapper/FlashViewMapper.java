package com.activity.mapper;

import java.util.List;

import com.activity.pojo.FlashView;

public interface FlashViewMapper {
	
	List<FlashView> getFlashView();
	
	int updateStatusByflashViewId(FlashView record);
	
	int countOpenView();
	
	int insert(FlashView record);
	
	int updateByPrimaryKey(FlashView record);
}