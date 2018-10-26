package com.leihou.so.vo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: ruibiaozhong
 * @Description: TO
 * @Date: 2018/10/25 16:48
 */
public class ModelVo<T> {

    private T model;

    private Map<String, Object> includes;

    private Map<String, List<Object>> refers;

    private Map<String, List<Object>> relates;


    public ModelVo(T model) {
        this.model = model;
        this.includes = new HashMap<>();
        this.refers = new HashMap<>();
        this.relates = new HashMap<>();
    }

    public void setIncludes(Map<String, Object>includes){
        this.includes = includes;
    }

    public Map<String, Object> getIncludes(){
        return this.includes;
    }

    public void setRefers(Map<String, List<Object>> refers){
        this.refers = refers;
    }

    public Map<String, List<Object>> getRefers(){
        return this.refers;
    }

    public void setRelates(Map<String, List<Object>> relates){
        this.relates = relates;
    }

    public Map<String, List<Object>> getRelates(){
        return this.relates;
    }

    public T getModel() {
        return model;
    }

    public void setModel(T model) {
        this.model = model;
    }
}
