package com.leihou.so.util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class ApplicationContextUtil implements ApplicationContextAware {

	private static ApplicationContext applicationContext;
	
	
	/**
	 * 获取spring上下问对象
	 * @return
	 */
	public static ApplicationContext getApplicationContext() {
		return ApplicationContextUtil.applicationContext;
	}
	
	public static Object getBean(String name) {
		return applicationContext.getBean(name);
	}

	public static<T> T getBean(Class<T> requiredType) {
		return applicationContext.getBean(requiredType);
	}
	
	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		ApplicationContextUtil.applicationContext = applicationContext;
	}

}
