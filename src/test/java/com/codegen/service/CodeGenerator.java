package com.codegen.service;
/**
 * 主要逻辑接口
 * Created by zhh on 2017/09/20.
 */
public interface CodeGenerator {
	
	/**
	 * 代码生成主要逻辑
	 * @param tableName 表名
	 */
	void genCode(String tableName);
}
