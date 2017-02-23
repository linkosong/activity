package com.activity.mapper;

import java.util.List;

import com.activity.form.SearchForm;
import com.activity.pojo.GoodsInfo;

public interface GoodsInfoMapper {
    
	/**添加商品*/
	int insert(GoodsInfo record);
	
	/**查看商品列表*/
	List<GoodsInfo> getGoodsList(SearchForm form);
	
	/**查看商品详情*/
	GoodsInfo getGoodsDetails(String goodsId);
	
	/**添加商品*/
	int addGoods(GoodsInfo record);
	
	/**更新商品信息*/
	int updateByGoodsId(GoodsInfo record);
	
	/**更新商品状态*/
	int changeGoodsStatus(GoodsInfo record);	
	
	/**取得热销商品*/
	List<GoodsInfo> getHotGoods();	
	
	  
	
}