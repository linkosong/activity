package com.activity.service;

import com.activity.common.ResResult;

public interface IndexServiceI {

	/** 取得所有类目 */
	public ResResult getTypeAll();
	
	/** 查询轮播图 */
	ResResult selectFlashView();
		
	/** 热卖商品 */
	ResResult gethotGoods();

}
