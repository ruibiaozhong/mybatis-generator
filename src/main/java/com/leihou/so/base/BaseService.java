package com.leihou.so.base;

import com.github.pagehelper.Page;
import com.leihou.so.vo.ModelVo;

import java.io.Serializable;
import java.util.List;

public interface BaseService<T> {

	List<T> select(T t);

	List<T> selectAll();

	int insert(T t);

	int insertSelective(T t);

	T selectByPrimaryKey(Object id);

	int updateByPrimaryKey(T t);

	int deleteByPrimaryKey(Serializable id);



	List<ModelVo> listWithPagingAndFilter(Integer pageNumber, Integer pageSize,
										  String sortItem, String sortOrder,
										  String filters, String includes,
										  String refers, String relates);
}