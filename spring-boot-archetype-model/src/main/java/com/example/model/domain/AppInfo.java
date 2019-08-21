package com.example.model.domain;

import com.example.model.AbstractModel;

/**
 * 应用示例
 * @author yejq@gmail.com
 * @date 2019-06-05
 */
public class AppInfo extends AbstractModel<Integer> {


    private Integer id;

    /**
     * 应用名称
     */
    private String name;

    public AppInfo() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
