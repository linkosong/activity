package com.activity.service;

import org.springframework.web.multipart.MultipartFile;

import com.activity.common.ResResult;
import com.activity.pojo.FlashView;

public interface ManageServiceI {

	// 新增轮播图
	ResResult addFlashView(FlashView record);
	// 编辑轮播图
	ResResult editFlashView(MultipartFile uploadFile,FlashView record);
	// 开启或关闭轮播图
	ResResult controlFlashView(FlashView record);
	
}
