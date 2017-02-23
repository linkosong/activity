package com.activity.controller;

 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.activity.common.ResResult;
import com.activity.form.SearchForm;
import com.activity.pojo.GoodsInfo;
import com.activity.pojo.GoodsType;
import com.activity.service.GoodsServiceI;
 

/**
 * 描述: 商品 <br>
 * 作者: szl <br>
 * 时间: 2016年8月31日 下午4:05:21
 */
@Controller
@RequestMapping("/goods")
public class GoodsController {
	
	@Autowired
	private GoodsServiceI goodsService;
	
	
	
	/**
	 * 取得商品列表
	 * @param 
	 * 
	*/
	@ResponseBody
	@RequestMapping("getGoodsList")
	public ResResult getGoodsList(SearchForm form) {
		
		return this.goodsService.getGoodsList(form);
	}
	
	/**
	 * 添加类目
	 * @param record level 1,2,3
	 * 
	*/
	@ResponseBody
	@RequestMapping("addType")
	public ResResult addType(GoodsType record) {
		
		return goodsService.addType(record);
	}
	
	/**
	 * 删除类目
	 * @param record level 1,2,3
	 * 
	*/
	@ResponseBody
	@RequestMapping("deleteType")
	public ResResult deleteType(Long id) {
		return goodsService.delete(id);
	}
	
	/**
	 * 取得单级类目
	 * @param record level 1,2,3
	 * 
	*/
	@ResponseBody
	@RequestMapping("getTypeSingle")
	public ResResult getTypeSingle(GoodsType record) {
		
		return goodsService.getTypeSingle(record);
	}

	/**
	 * 添加商品
	 * @param record
	 * 
	*/
	@ResponseBody
	@RequestMapping("addGoods")
	public ResResult addGoods(GoodsInfo record) {
		
		return goodsService.addGoods(record);
	}
	
	/**
	 * 商品详情
	 * @param goodsid
	 * 
	*/
	@ResponseBody
	@RequestMapping("getGoodsDetails")
	public ResResult getGoodsDetails(String goodsId) {
		
		return goodsService.getGoodsDetails(goodsId);
	}
	
 
}
