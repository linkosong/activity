package com.activity.service.impl;

 
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.activity.common.CheckUtil;
import com.activity.common.Contants;
import com.activity.common.IDUtils;
import com.activity.common.ResResult;
import com.activity.form.SearchForm;
import com.activity.mapper.GoodsInfoMapper;
import com.activity.mapper.GoodsTypeMapper;
import com.activity.pojo.GoodsInfo;
import com.activity.pojo.GoodsType;
import com.activity.service.GoodsServiceI;
 
/**
 * 
 * 类: GoodsServiceImpl <br>
 * 描述: 商品服务 <br>
 * 作者: szl <br>
 * 时间: 2016年8月31日 下午4:07:45
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class GoodsServiceImpl implements GoodsServiceI{


	@Autowired
	private GoodsTypeMapper goodsTypeMapper;
	
	@Autowired
	private GoodsInfoMapper goodsInfoMapper;

	/**
	 * 取得商品单级类目
	 * @param level level：1,2,3
	 * 
	*/
	public ResResult getTypeSingle(GoodsType record) {
		
		try{
			List<GoodsType> list=this.goodsTypeMapper.getTypeSingle(record);
			if(CheckUtil.isNullList(list)){
				return ResResult.build(Contants.SUCCESS_0, "检索结果无！！！！");	
			}
			return ResResult.build(Contants.SUCCESS, "成功！", list);
			
		}catch(Exception e){
			e.printStackTrace();
			return ResResult.build(Contants.ERROR, "系统异常！");
		}
	}
	
	/**
	 * 添加类目
	 * @param record level 1,2,3
	 * 
	*/
	public ResResult addType(GoodsType record) {
		
		try{
			this.goodsTypeMapper.insert(record);
			return ResResult.ok();
		}catch(Exception e){
			return ResResult.build(Contants.ERROR, "系统异常！");
		}
	}
	
	/**
	 * 删除类目
	 * @param record level 1,2,3
	 * 
	*/
	public ResResult reduceType(Long id) {
		
		try{
			this.goodsTypeMapper.delete(id);
			return ResResult.ok();
		}catch(Exception e){
			return ResResult.build(Contants.ERROR, "系统异常！");
		}
	}

	/**
	 * 添加商品
	 * @param record
	 * 
	*/
	public ResResult addGoods(GoodsInfo record) {
		
		try{
			record.setGoodsId(IDUtils.genItemIdOnly());
			record.setEditTime(new Date());
			record.setSaleNum(0l);
			this.goodsInfoMapper.insert(record);
			return ResResult.build(Contants.SUCCESS, "成功！");
		}catch(Exception e){
			e.printStackTrace();
			return ResResult.build(Contants.ERROR, "系统异常！");
		}
	}
	
	/**
	 * 商品详情
	 * @param goodsid
	 * 
	*/
	public ResResult getGoodsDetails(String goodsId) {
		
		try{
			//取得商品详情
			GoodsInfo record= this.goodsInfoMapper.getGoodsDetails(goodsId);
			if(record==null){
				return ResResult.build(Contants.SUCCESS_0, "检索结果无！！！！");	
			}
			return ResResult.build(Contants.SUCCESS, "成功！", record);
		}catch(Exception e){
			return ResResult.build(Contants.ERROR, "系统异常！");
		}
	}
	
	/** 
	 * 取得商品列表
	 * @param typeId
	 * 
	 */
	public ResResult getGoodsList(SearchForm form) {
		
		try{
			//取得商品详情
			List<GoodsInfo>  list= this.goodsInfoMapper.getGoodsList(form);
			if(CheckUtil.isNullList(list)){
				return ResResult.build(Contants.SUCCESS_0, "检索结果无！！！！");
			}
			return ResResult.build(Contants.SUCCESS, "成功！", list);
		}catch(Exception e){
			e.printStackTrace();
			return ResResult.build(Contants.ERROR, "系统异常！");
		}
	}

	public ResResult delete(Long id) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
