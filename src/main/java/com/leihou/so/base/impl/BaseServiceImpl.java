package com.leihou.so.base.impl;

import com.github.pagehelper.PageHelper;
import com.google.common.base.CaseFormat;
import com.leihou.so.base.BaseMapper;
import com.leihou.so.base.BaseService;
import com.leihou.so.constant.common.DatePattern;
import com.leihou.so.util.ApplicationContextUtil;
import com.leihou.so.util.DateUtils;
import com.leihou.so.util.JsonUtil;
import com.leihou.so.vo.ModelVo;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;
import tk.mybatis.mapper.entity.Example;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class BaseServiceImpl<D extends BaseMapper<T>, T> implements BaseService<T> {

	protected Logger log = LoggerFactory.getLogger(this.getClass());

	@Autowired
	protected D dao;

	private Class clazz;

	public BaseServiceImpl() {
		//使用反射技术得到T的真实类型
		//获取当前new的对象的泛型的父类
		ParameterizedType pt =(ParameterizedType) this.getClass().getGenericSuperclass();
		//获取第一个类型参数的真实类型
		this.clazz = (Class<T>) pt.getActualTypeArguments()[1];

	}

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


	/**
	 * 单表，多对一，搜索及分页
	 * @param pageNumber 页码
	 * @param pageSize 一页多少条数据
	 * @param sortItem 排序的字段名称
	 * @param sortOrder 正序还是倒叙
	 * @param filters  过滤条件
	 * @param includes  多对一
	 * @param refers
	 * @param relates
	 * @return
	 */
	@Override
	public List<ModelVo> listWithPagingAndFilter(Integer pageNumber, Integer pageSize,
												 String sortItem, String sortOrder,
												 String filters, String includes,
												 String refers, String relates) {
		Example example = new Example(clazz);
		Example.Criteria criteria = example.createCriteria();
		Example.OrderBy orderBy = example.orderBy(sortItem);
		if ("desc".equals(sortOrder)) {
			orderBy.desc();
		} else {
			orderBy.asc();
		}

		assignFilter(criteria, filters, clazz);

		if (null != pageNumber && null != pageSize) {
			PageHelper.startPage(pageNumber, pageSize, true, false, null);
		}
		List<T> list = dao.selectByExample(example);

		List<ModelVo> modelVoList = list.stream().map(item -> new ModelVo(item)).collect(Collectors.toList());

		if (StringUtils.isNotBlank(includes) || StringUtils.isNotBlank(refers)) {
			if (CollectionUtils.isNotEmpty(list)) {
				modelVoList.stream().forEach(item -> {
					assignIncludes(item, includes);
				});
			}
		}
		return modelVoList;
	}


	/**
	 * 获取includes相关的信息
	 * @param modelVo
	 * @param includes
	 */
	public void assignIncludes(ModelVo<T> modelVo, String includes) {
		Map map = JsonUtil.fromJson(includes, Map.class);
		Set<Map.Entry> set = map.entrySet();
		for (Map.Entry entry : set) {
			String key = (String) entry.getKey();
			WebApplicationContext webApplicationContext = ContextLoader.getCurrentWebApplicationContext();
			//获取includes对应的Mapper
			BaseMapper baseMapper = null;
			try {
				baseMapper = (BaseMapper) ApplicationContextUtil.getBean(Class.forName("com.leihou.so.mapper." + CaseFormat.LOWER_CAMEL.to(CaseFormat.UPPER_CAMEL, key) + "Mapper"));
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			Map valueMap = (Map) entry.getValue();
			List<String> includesList = (List<String>)valueMap.get("includes");
			for (String property : includesList) {
				Object model = modelVo.getModel();
				try {
					Field field = model.getClass().getDeclaredField(property);
					field.setAccessible(true);
					//获取外键表对应id的值
					Object value = field.get(model);
					modelVo.getIncludes().put(key, baseMapper.selectByPrimaryKey(value));
				} catch (NoSuchFieldException e) {
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				}
			}
		}
	}


	public void assignCondition(Example.Criteria criteria, String condition, Class propertyType, String property, Object value) {
		switch (condition) {
			case "like":
				criteria.andLike(property, value.toString());
				break;
			case "notLike":
				criteria.andNotLike(property, value.toString());
			case "between":
				if (propertyType == Date.class) {
					criteria.andBetween(property,
							DateUtils.parse((String)((List<String>) value).get(0), DatePattern.LONG_DASH),
							DateUtils.parse((String) ((List<String>) value).get(1), DatePattern.LONG_DASH));
				} else {
					criteria.andBetween(property, ((List<String>) value).get(0), ((List<String>) value).get(1));
				}
				break;
			case "notBetween":
				if (propertyType == Date.class) {
					criteria.andNotBetween(property,
							DateUtils.parse((String)((List<String>) value).get(0), DatePattern.LONG_DASH),
							DateUtils.parse((String) ((List<String>) value).get(1), DatePattern.LONG_DASH));
				} else {
					criteria.andNotBetween(property, ((List<String>) value).get(0), ((List<String>) value).get(1));
				}
				break;
			case "equalTo":
				criteria.andEqualTo(property, value);
				break;
			case "notEqualTo":
				criteria.andNotEqualTo(property, value);
				break;
			case "greaterThan":
				criteria.andGreaterThan(property, value);
				break;
			case "greaterThanOrEqualTo":
				criteria.andGreaterThanOrEqualTo(property, value);
				break;
			case "lessThan":
				criteria.andLessThan(property, value);
				break;
			case "in":
				criteria.andIn(property, (List)value);
				break;
			case "notIn":
				criteria.andNotIn(property, (List)value);
				break;
			default:
				break;
		}

	}


	public void assignFilter(Example.Criteria criteria, String filter, Class clazz) {
		if (StringUtils.isBlank(filter)) {
			return ;
		}
		Map map = JsonUtil.fromJson(filter, Map.class);
		Set<Map.Entry> set = map.entrySet();
		for (Map.Entry<String, Object> entry : set) {
			String property = entry.getKey();
			Map<String, Object> valueMap = (Map)entry.getValue();
			for (Map.Entry<String, Object> valueEntry : valueMap.entrySet()) {
				Object value = valueEntry.getValue();
				if (null == value) {
					continue;
				}
				try {
					Field field = clazz.getDeclaredField(property);
					assignCondition(criteria, valueEntry.getKey(), field.getType(), property, valueEntry.getValue());
				} catch (NoSuchFieldException e) {
					e.printStackTrace();
				}

			}
		}
	}


}











