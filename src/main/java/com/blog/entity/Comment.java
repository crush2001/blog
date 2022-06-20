package com.blog.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * (Comment)实体类
 *
 * @author makejava
 * @since 2022-06-20 19:33:35
 */
public class Comment implements Serializable {
    private static final long serialVersionUID = -17407290691498786L;
    /**
     * 评论id
     */
    private Long id;
    /**
     * 被评论的帖子id
     */
    private Long postId;
    /**
     * 发表该评论的用户id
     */
    private Long commentUserId;
    /**
     * 评论时间
     */
    private Date commentTime;
    /**
     * 评论内容
     */
    private String commentContent;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPostId() {
        return postId;
    }

    public void setPostId(Long postId) {
        this.postId = postId;
    }

    public Long getCommentUserId() {
        return commentUserId;
    }

    public void setCommentUserId(Long commentUserId) {
        this.commentUserId = commentUserId;
    }

    public Date getCommentTime() {
        return commentTime;
    }

    public void setCommentTime(Date commentTime) {
        this.commentTime = commentTime;
    }

    public String getCommentContent() {
        return commentContent;
    }

    public void setCommentContent(String commentContent) {
        this.commentContent = commentContent;
    }

}

