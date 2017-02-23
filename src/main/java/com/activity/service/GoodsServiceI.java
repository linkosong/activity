package com.activity.service;

import com.activity.common.ResResult;
import com.activity.form.SearchForm;
import com.activity.pojo.GoodsInfo;
import com.activity.pojo.GoodsType;

public interface GoodsServiceI {

	/** 取得单级类目*/
	ResResult getTypeSingle(GoodsType record);
	
	/** 添加类目*/
	ResResult addType(GoodsType record);
	
	/** 删除类目*/
	ResResult delete(Long id);
	
	/** 添加商品*/
	ResResult addGoods(GoodsInfo record) ;
	
	/** 取得商品列表*/
	ResResult getGoodsList(SearchForm form);
	
	/** 商品详情*/
	ResResult getGoodsDetails(String goodsid) ;
	
}
