package com.activity.service.impl;

 
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.activity.common.CheckUtil;
import com.activity.common.Contants;
import com.activity.common.ResResult;
import com.activity.mapper.FlashViewMapper;
import com.activity.mapper.GoodsInfoMapper;
import com.activity.mapper.GoodsTypeMapper;
import com.activity.pojo.FlashView;
import com.activity.pojo.GoodsInfo;
import com.activity.pojo.GoodsType;
import com.activity.service.IndexServiceI;
 
/**
 * 
 * 类: TestServiceImpl <br>
 * 描述: TODO <br>
 * 作者: szl <br>
 * 时间: 2016年8月31日 下午4:07:45
 */
@Service
public class IndexServiceImpl implements IndexServiceI{

	@Autowired
	private GoodsTypeMapper goodsTypeMapper;
	
	@Autowired
	private GoodsInfoMapper goodsInfoMapper;
	
	@Autowired
	private FlashViewMapper flashViewMapper;
	
	
	/**
	 * 查询热卖商品
	 * 
	 * @return
	 */
	public ResResult getTypeAll() {
		try {	
			List<GoodsType>	list=goodsTypeMapper.getTypeAll();
			if(CheckUtil.isNullList(list)){
				return ResResult.build(Contants.SUCCESS, "结果结果0件。");
			}
			return ResResult.build(Contants.SUCCESS, "结果正常。", list);
		} catch (Exception e) {
			e.printStackTrace();
			return ResResult.build(Contants.ERROR, "系统异常，请联系管理员。");
		}
	}

	/**
	 * 查询轮播图
	 * 
	 * @return
	 */
	public ResResult selectFlashView() {
		try {
			// 无条件查询
			List<FlashView> list=this.flashViewMapper.getFlashView();
			// 检索结果0件，提示0件信息。
			if (CheckUtil.isNullList(list)) {
				return ResResult.build(Contants.SUCCESS, "结果结果0件。");
			}

			return ResResult.build(Contants.SUCCESS, "结果正常。", list);

		} catch (Exception e) {
			e.printStackTrace();
			return ResResult.build(Contants.ERROR, "系统异常，请联系管理员。");
		}
	}
	
	/**
	 * 热卖商品
	 * @return
	 */
	public ResResult gethotGoods() {
		
		try {
			List<GoodsInfo>  list =this.goodsInfoMapper.getHotGoods();
			if(CheckUtil.isNullList(list)){
				return ResResult.build(Contants.SUCCESS_0, "没有热销商品。");
			}
			return ResResult.build(Contants.SUCCESS, "热销商品取得成功！",list);
		} catch (Exception e) {
			e.printStackTrace();
 			return ResResult.build(Contants.ERROR, "系统异常，请联系管理员");
		}
	
	}
	 
}
