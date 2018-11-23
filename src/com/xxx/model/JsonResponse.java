package com.xxx.model;

public class JsonResponse {

    public static final int RESULT_CODE_SUCCESS = 0;

    public static final int ERROR_CODE = -1;

    private int code;

    private String msg;

    private long total;

    private Object rows;

    public JsonResponse() {
    }

    public void setFailed(String errorMessage){
        this.code = ERROR_CODE;
        this.msg = errorMessage;
    }

    public void setFailed(int resultCode, String errorMessage) {
        this.code = resultCode;
        this.msg = errorMessage;
    }

    public void setSuccessed() {
        this.code = RESULT_CODE_SUCCESS;
    }

    public void setSuccessed(Object object) {
        this.code = RESULT_CODE_SUCCESS;
        this.rows = object;
    }

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public long getTotal() {
		return total;
	}

	public void setTotal(long total) {
		this.total = total;
	}

	public Object getRows() {
		return rows;
	}

	public void setRows(Object rows) {
		this.rows = rows;
	}

    
    
}