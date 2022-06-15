package com.blog.entity;

import java.io.Serializable;

/**
 * (Category)实体类
 *
 * @author makejava
 * @since 2022-06-15 08:45:47
 */
public class Category implements Serializable {
    private static final long serialVersionUID = -53051601679057211L;
    /**
     * 分类id
     */
    private Long id;
    /**
     * 分类名
     */
    private String name;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}

