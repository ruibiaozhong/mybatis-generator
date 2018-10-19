package com.leihou.so.base.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.leihou.so.base.BaseMapper;
import com.leihou.so.base.BaseService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.util.List;


public class BaseServiceImpl<D extends BaseMapper<T>, T> implements BaseService<T> {

    protected Logger log = Logger.getLogger(this.getClass());

	@Autowired
	protected D dao;
	
	@Override
	public List<T> select(T t) {
		return dao.select(t);
	}

	@Override
	public List<T> selectAll() {
		return dao.selectAll();
	}

	@Override
	public int insert(T t) {
		return dao.insert(t);
	}

	@Override
	public int insertSelective(T t) {
		return dao.insertSelective(t);
	}

	@Override
	public T selectByPrimaryKey(Object id) {
		return dao.selectByPrimaryKey(id);
	}

	@Override
	public int updateByPrimaryKey(T t) {
		return dao.updateByPrimaryKey(t);
	}

	@Override
	public int deleteByPrimaryKey(Serializable id) {
		return dao.deleteByPrimaryKey(id);
	}

	public Logger getLogger() {
		return log;
	}

	public void setLogger(Logger logger) {
		this.log = logger;
	}

    @Override
	public int updateByPrimaryKeySelective(T t) {
		return dao.updateByPrimaryKeySelective(t);
	}


}