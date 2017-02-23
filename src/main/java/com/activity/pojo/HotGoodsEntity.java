package com.activity.pojo;

import java.math.BigDecimal;

public class HotGoodsEntity {
	
	private String goodsId;
	
	private String goodsName;
	
	private Integer saleNum;
	
	private String goodsMainPicUrl;

	private BigDecimal price;

	public String getGoodsId() {
		return goodsId;
	}

	public void setGoodsId(String goodsId) {
		this.goodsId = goodsId;
	}

	public String getGoodsName() {
		return goodsName;
	}

	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}

	public Integer getSaleNum() {
		return saleNum;
	}

	public void setSaleNum(Integer saleNum) {
		this.saleNum = saleNum;
	}

	public String getGoodsMainPicUrl() {
		return goodsMainPicUrl;
	}

	public void setGoodsMainPicUrl(String goodsMainPicUrl) {
		this.goodsMainPicUrl = goodsMainPicUrl;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

}