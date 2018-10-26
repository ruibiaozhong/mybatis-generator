package com.leihou.so.bo;

import com.leihou.so.constant.common.ResultConst;

/**
 * ajax 返回的结果成功与否
 * @author ruibiao_z
 *
 */
public class Result {

    private String status;
	
	private String code;
	
	private String msg;

	public Result() {
		this.status = ResultConst.status.TRUE;
		this.code = ResultConst.code.SUCCESS;
	}

	public Result(String status, String code) {
		this.status = status;
		this.code = code;
	}
	
	
	public Result(String status, String code, String msg) {
		this.status = status;
		this.code = code;
		this.msg = msg;
	}
	
	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public void setExceptionStatus() {
		this.status = ResultConst.status.FALSE;
		this.code = ResultConst.code.EXCEPTION;
	}
	
	
	public void setExceptionMsg(String msg) {
		this.status = ResultConst.status.FALSE;
		this.code = ResultConst.code.EXCEPTION;
		this.msg = msg;
	}
	
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setInvalidMsg(String msg) {
		this.status = ResultConst.status.FALSE;
		this.code = ResultConst.code.INVALID;
		this.msg = msg;
	}
	
	public void setTokenExpiried() {
		this.status = ResultConst.status.FALSE;
		this.code = ResultConst.code.UNAUTHORIZED;
		this.msg = "token已失效";
	}
	
	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	
	public void setCustomCode(String code) {
		this.status = ResultConst.status.FALSE;
		this.code = code;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
		
	
	
	
	
}