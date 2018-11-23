package com.xxx.model;


import com.alibaba.fastjson.annotation.JSONField;

import java.util.Date;

public class PaginationModel {

	@JSONField(serialize = false)
    private int pageIndex;

    @JSONField(serialize = false)
    private int pageSize;

    @JSONField(serialize = false)
    private String query = null;

    @JSONField(serialize = false)
    private String startTime;

    @JSONField(serialize = false)
    private String endTime;
    
    @JSONField(serialize = false)
    private String begin;
    
    @JSONField(serialize = false)
    private String end;

    public PaginationModel() {
        this.pageIndex = 1;
        this.pageSize = 20;
    }

	public int getPageIndex() {
		return pageIndex;
	}

	public void setPageIndex(int pageIndex) {
		this.pageIndex = pageIndex;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public String getQuery() {
		return query;
	}

	public void setQuery(String query) {
		this.query = query;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public String getBegin() {
		return begin;
	}

	public void setBegin(String begin) {
		this.begin = begin;
	}

	public String getEnd() {
		return end;
	}

	public void setEnd(String end) {
		this.end = end;
	}
	
}
