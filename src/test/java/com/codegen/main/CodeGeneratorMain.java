package com.codegen.main;

import com.codegen.service.CodeGeneratorManager;
import com.codegen.service.impl.ControllerGenerator;
import com.codegen.service.impl.ModelAndMapperGenerator;
import com.codegen.service.impl.ServiceGenerator;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;


/**
 * 代码生成器启动项
 * Created by zhh on 2017/09/20.
 */
public class CodeGeneratorMain {

	private static final String[] TABLES = {"t_user", "t_order"};


	public static void main(String[] args) {
		new CodeGeneratorManager().genCodeWithSimpleName(TABLES);

	}



}
