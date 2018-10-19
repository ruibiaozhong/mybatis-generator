package com.codegen.main;

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
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CodeGeneratorMain {

	private static final String TABLES = "t_user";


	@Test
	public void test1generateEntityAndMapper() {
		new ModelAndMapperGenerator().genCode(TABLES);
	}


	@Test
	public void test2generateService() {
		new ServiceGenerator().genCode(TABLES);
	}

	@Test
	public void test3generateController() {
		try {
			System.out.println(Class.forName("com.leihou.so.entity.User"));
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		new ControllerGenerator().genCode(TABLES);
	}


}
