package com.blog.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * (Post)实体类
 *
 * @author makejava
 * @since 2022-06-15 08:45:47
 */
public class Post implements Serializable {
    private static final long serialVersionUID = 655845048404610241L;
    /**
     * 帖子id
     */
    private Long id;
    /**
     * 作者id
     */
    private Long authorId;
    /**
     * 分类id
     */
    private Long catId;
    /**
     * 标题
     */
    private String title;
    /**
     * 内容
     */
    private String content;
    /**
     * 发帖时间
     */
    private Date postTime;
    /**
     * 标签
     */
    private Object tags;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Long authorId) {
        this.authorId = authorId;
    }

    public Long getCatId() {
        return catId;
    }

    public void setCatId(Long catId) {
        this.catId = catId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getPostTime() {
        return postTime;
    }

    public void setPostTime(Date postTime) {
        this.postTime = postTime;
    }

    public Object getTags() {
        return tags;
    }

    public void setTags(Object tags) {
        this.tags = tags;
    }

}

