package com.activity.mapper;

import java.util.List;

import com.activity.pojo.GoodsType;

public interface GoodsTypeMapper {
	
	
	//**取得商品所有类目
	public List<GoodsType> getTypeAll();
	//**取得商品单级类目
	List<GoodsType> getTypeSingle(GoodsType record);
	//**添加类目
	int insert(GoodsType record);
	//**删除类目
	int delete(Long id);
	
	
	
}