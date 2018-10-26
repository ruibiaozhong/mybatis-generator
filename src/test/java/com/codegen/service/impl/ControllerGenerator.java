package com.codegen.service.impl;

import java.io.File;
import java.io.FileWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.codegen.service.CodeGenerator;
import com.codegen.service.CodeGeneratorConfig;
import com.codegen.service.CodeGeneratorManager;
import com.codegen.util.StringUtils;
import com.google.common.base.CaseFormat;

import com.google.gson.internal.LinkedTreeMap;
import freemarker.template.Configuration;
import org.mybatis.generator.api.dom.java.Field;

import javax.persistence.Id;

/**
 * Controller层 代码生成器
 * Created by zhh on 2017/09/20.
 */
public class ControllerGenerator extends CodeGeneratorManager implements CodeGenerator {

	@Override
	public void genCode(String tableName) {
		String modelName = StringUtils.getModelName(tableName);

		Configuration cfg = getFreemarkerConfiguration();
		String modelNameUpperCamel = StringUtils.isNullOrEmpty(modelName) ? tableNameConvertUpperCamel(tableName) : modelName;
		
		Map<String, Object> data = getDataMapInit(tableName, modelName, modelNameUpperCamel);
		try {
			File controllerFile = new File(PROJECT_PATH + JAVA_PATH + PACKAGE_PATH_CONTROLLER + modelNameUpperCamel + "Controller.java");
	        if (!controllerFile.getParentFile().exists()) {
	        	controllerFile.getParentFile().mkdirs();
	        }
			cfg.getTemplate("controller.ftl").process(data, new FileWriter(controllerFile));
			logger.info(modelNameUpperCamel + "Controller.java 生成成功!");
		} catch (Exception e) {
			throw new RuntimeException("Controller 生成失败!", e);
		}
	}

	public static void main(String[] args) {
		System.out.println(CaseFormat.LOWER_CAMEL.to(CaseFormat.LOWER_HYPHEN, "helloWorld"));
	}
	
	/**
	 * 预置页面所需数据
	 * @param tableName 表名
	 * @param modelName 自定义实体类名, 为null则默认将表名下划线转成大驼峰形式
	 * @param modelNameUpperCamel 首字为大写的实体类名
	 * @return
	 */
	private Map<String, Object> getDataMapInit(String tableName, String modelName, String modelNameUpperCamel) {
		Map<String, Object> data = new HashMap<>();
		data.put("date", DATE);
        data.put("author", AUTHOR);
        data.put("baseRequestMapping", StringUtils.toLowerCaseFirstOne(modelNameUpperCamel));
        data.put("modelNameUpperCamel", modelNameUpperCamel);
        data.put("modelNameLowerCamel", CaseFormat.UPPER_CAMEL.to(CaseFormat.LOWER_CAMEL, modelNameUpperCamel));
        data.put("basePackage", BASE_PACKAGE);
		data.put("tableName", tableName);


		List<Field> fieldList = ModelAndMapperGenerator.map.get(modelName);


		LinkedTreeMap<String, String> map = new LinkedTreeMap<>();
		fieldList.stream().forEach(field -> {
			field.getAnnotations().stream().filter(item -> "@Id".equals(item)).findFirst().ifPresent(item -> data.put("id", field.getName()));

			map.put(field.getName(), field.getType().getShortName());
		});

		data.put("attribute", map);

		return data;
	}
}
























