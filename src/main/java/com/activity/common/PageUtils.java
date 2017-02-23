package com.activity.common;
public class PageUtils {
	private Integer sum;
	private Integer size=5;
	private Integer nowPage;
	private Integer prevPage;
	private Integer nextPage;
	private Integer lastPage;
	private Integer begin;
	
	public PageUtils(String nowPage,Integer Sum, Integer pageSize){
		
		initCurrentPage(nowPage);
		initPrevPage();
		this.sum = Sum;
		this.size = pageSize;
		initPageCount();
		initNextPage();
		initStartRecord();
		
	}

	private void initStartRecord() {
		 
			begin=(nowPage-1)*size;
	 
	}

	private void initNextPage() {
		if (nowPage==lastPage) {
			nextPage=lastPage;
		}else {
			nextPage=nowPage+1;
		}
		
	}

	private void initPageCount(){
		if(sum!=null){
			lastPage=sum/size;
			if (sum%size!=0) {
				lastPage++;
			}
			if (nowPage>lastPage) {
				nowPage=lastPage;
			} 
			if (nowPage<1) {
				nowPage=1;
			}
		}
		
	}

	public PageUtils() {
		initCurrentPage();
		initPrevPage();
		initPageCount();
		initNextPage();
		//initStartRecord();
	}

	private void initPrevPage() {
        if (this.nowPage==1) {
			this.prevPage=1;
		}else {
			this.prevPage=this.nowPage-1;
		}		
	}

	private void initCurrentPage(String nowPage) {
		 
		if (nowPage==null || nowPage.trim().equals("")) {
			nowPage="1";
		}
		this.nowPage=Integer.parseInt(nowPage);
	}
	
	private void initCurrentPage() {
		
		if (nowPage==null) {
			nowPage=1;
		}
	}

	public Integer getSum() {
		return sum;
	}

	public void setSum(Integer sum) {
		this.sum = sum;
	}

	public Integer getSize() {
		return size;
	}

	public void setSize(Integer size) {
		this.size = size;
	}

	public Integer getNowPage() {
		return nowPage;
	}

	public void setNowPage(Integer nowPage) {
		this.nowPage = nowPage;
	}

	public Integer getPrevPage() {
		return prevPage;
	}

	public void setPrevPage(Integer prevPage) {
		this.prevPage = prevPage;
	}

	public Integer getNextPage() {
		return nextPage;
	}

	public void setNextPage(Integer nextPage) {
		this.nextPage = nextPage;
	}

	public Integer getLastPage() {
		return lastPage;
	}

	public void setLastPage(Integer lastPage) {
		this.lastPage = lastPage;
	}

	public Integer getBegin() {
		return (nowPage-1)*size;
	}

	public void setBegin(Integer begin) {
		this.begin = begin;
	}
}
