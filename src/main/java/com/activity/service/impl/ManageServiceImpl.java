package com.activity.service.impl;

 
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.activity.common.Contants;
import com.activity.common.ExceptionUtil;
import com.activity.common.ResResult;
import com.activity.mapper.FlashViewMapper;
import com.activity.pojo.FlashView;
import com.activity.service.ManageServiceI;
 
/**
 * 
 * 类: GoodsServiceImpl <br>
 * 描述: 商品服务 <br>
 * 作者: szl <br>
 * 时间: 2016年8月31日 下午4:07:45
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class ManageServiceImpl implements ManageServiceI{


	@Autowired
	private FlashViewMapper flashViewMapper;

	// FTP的地址
	@Value("${FTP_ADDRESS}")
	private String FTP_ADDRESS;

	// 端口号
	@Value("${FTP_PORT}")
	private int FTP_PORT;

	// 用户名
	@Value("${FTP_USERNAME}")
	private String FTP_USERNAME;

	// 密码
	@Value("${FTP_PASSWORD}")
	private String FTP_PASSWORD;

	// ftp的存放的地址
	@Value("${FTP_BASE_PATH}")
	private String FTP_BASE_PATH;

	// ftp的下载的地址
	@Value("${IMAGE_BASE_URL}")
	private String IMAGE_BASE_URL;
	 
	
	/**
	 * 新增轮播图
	 * 
	 * @param record
	 * @return
	 */
	public ResResult addFlashView(FlashView record) {
		try {
			int countOpen = flashViewMapper.countOpenView();
			// 新增
			record.setCreateTime(new Date());
			record.setOperationTime(new Date());
			if(countOpen>=8){
				record.setDeleteFlag("1");
			}else{
				record.setDeleteFlag("0");
			}
			int count = flashViewMapper.insert(record);
			if (count != 1) {
				return ResResult.build(Contants.ERROR, "轮播图新增失败。");
			}
			return ResResult.build(Contants.SUCCESS, "轮播图添加成功！ ");

		} catch (Exception e) {
			ExceptionUtil.getStackTrace(e);
			return ResResult.build(Contants.ERROR, "系统异常，请联系管理员。");
		}

	}
	
	/**
	 * 编辑轮播图
	 * 
	 * @param flashViewId
	 *            轮播图索引ID
	 * @return
	 */
	public ResResult editFlashView(MultipartFile uploadFile,FlashView record) {
		try {
			
			record.setOperationTime(new Date());
			int count = flashViewMapper.updateByPrimaryKey(record);
			if (count == 0) {
				return ResResult.build(Contants.ERROR, "轮播图编辑失败。");
			}
			return ResResult.build(Contants.SUCCESS, "轮播图修改成功！ ");
			
		} catch (Exception e) {
			e.printStackTrace();
			return ResResult.build(Contants.ERROR, "系统异常 请稍后再试");

		}
	 
	}

	/**
	 * 
	 * 开启或关闭轮播图
	 * 
	 * @param record
	 *            轮播图索引ID 主键，开启或关闭状态码
	 * @return
	 */
	public ResResult controlFlashView(FlashView record) {
		try {
			// 1:关闭 0:开启
			record.setOperationTime(new Date());
			int count = flashViewMapper.updateStatusByflashViewId(record);
			// 更新失败，提示错误信息
			if (count == 0) {
				return ResResult.build(Contants.ERROR, "轮播图更新失败。");
			}
			return ResResult.build(Contants.SUCCESS, "轮播图更新成功！ ");

		} catch (Exception e) {
			e.printStackTrace();
			return ResResult.build(Contants.ERROR, "系统异常，请联系管理员。");
		}
	}

	
	
}
