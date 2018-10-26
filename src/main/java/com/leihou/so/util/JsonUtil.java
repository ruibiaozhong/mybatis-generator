package com.leihou.so.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import lombok.extern.slf4j.Slf4j;


@Slf4j
public class JsonUtil {



    /**
	 * 把对象转换成json
	 * @param object
	 * @return
	 */
	public static String toJson(Object object) {
		Gson gson = new Gson();
		return gson.toJson(object);
	}
	
	/**
	 * 转换成对象
	 * @param json
	 * @param classOfT
	 * @return
	 */
	public static <T> T fromJson(String json, Class<T> classOfT) {
		Gson gson = new Gson();
		return gson.fromJson(json, classOfT);
	}


	public static String toJson(Object object, String dateFormat) {
		Gson gson = new GsonBuilder()
				.setDateFormat(dateFormat)
				.create();
		return gson.toJson(object);
	}



}