package cn.com.sandi.qywx.base.myBatis.criteria;

public class PageQueryCriteria implements QueryCriteria {
	  private int index = 0;

	  private int currentPage = 1;

	  private int rows = 20;
	  private int pageCount;
	  private String sort = null;

	  private String order = null;
	  
	  

	  public PageQueryCriteria() {
		  super();
	  }

	public int getIndex() {
	    return this.index;
	  }

	  public void setIndex(int index){
	    this.index = index;
	  }

	  public int getRows() {
	    return this.rows;
	  }

	  public void setRows(int rows) {
	    this.rows = rows;
	  }

	  public String getSort() {
	    return this.sort;
	  }

	  public void setSort(String sort) {
	    this.sort = sort;
	  }

	  public String getOrder() {
	    return this.order;
	  }

	  public void setOrder(String order) {
	    this.order = order;
	  }

	  public int getCurrentPage() {
	     return this.currentPage;
	  }

	  public void setCurrentPage(int currentPage) {
	     this.currentPage = currentPage;
	  }

	  public int getPageCount() {
	    return this.pageCount;
	  }

	  public void setPageCount(int _pageCount){
	    this.pageCount = _pageCount;
	  }
}
