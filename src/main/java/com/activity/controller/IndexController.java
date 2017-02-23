package com.activity.controller;

 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.activity.common.ResResult;
import com.activity.service.IndexServiceI;
 

/**
 * 描述: TODO <br>
 * 作者: szl <br>
 * 时间: 2016年8月31日 下午4:05:21
 */
@Controller
@RequestMapping("/index")
public class IndexController {
	
	@Autowired
	private IndexServiceI indexServiceI;
	
	/**
	 * 取得所以商品类目
	 *  
	 * 
	*/
	@ResponseBody
	@RequestMapping("getTypeAll")
	public ResResult getTypeAll() {
		
		return indexServiceI.getTypeAll();
	}
	
	/**
	 * 取得热销商品
	 * 
	*/
	@ResponseBody
	@RequestMapping("gethotGoods")
	public ResResult gethotGoods() {
		
		return indexServiceI.gethotGoods();
	}
	
	/**
	 * 取得热销商品
	 * 
	*/
	@ResponseBody
	@RequestMapping("getFlashView")
	public ResResult selectFlashView() {
		
		return indexServiceI.selectFlashView();
	}
 
}
