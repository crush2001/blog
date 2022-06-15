package com.blog.entity;

import java.io.Serializable;

/**
 * (Collections)实体类
 *
 * @author makejava
 * @since 2022-06-15 10:41:39
 */
public class Collections implements Serializable {
    private static final long serialVersionUID = -75575769352216048L;
    /**
     * 收藏id
     */
    private Long id;
    /**
     * 当前用户id
     */
    private Long currentUserId;
    /**
     * 收藏的帖子id
     */
    private Long postId;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCurrentUserId() {
        return currentUserId;
    }

    public void setCurrentUserId(Long currentUserId) {
        this.currentUserId = currentUserId;
    }

    public Long getPostId() {
        return postId;
    }

    public void setPostId(Long postId) {
        this.postId = postId;
    }

}

