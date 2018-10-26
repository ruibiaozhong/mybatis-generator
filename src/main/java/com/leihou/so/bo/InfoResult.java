package com.leihou.so.bo;

import com.leihou.so.constant.common.ResultConst;

public class InfoResult<T> extends Result {

	protected T info;

    public T getInfo() {
		return info;
	}

	public void setInfo(T info) {
		setStatus(ResultConst.status.TRUE);
		this.info = info;
	}


}