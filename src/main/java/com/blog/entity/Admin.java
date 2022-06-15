package com.blog.entity;

import java.io.Serializable;

/**
 * (Admin)实体类
 *
 * @author makejava
 * @since 2022-06-15 08:45:46
 */
public class Admin implements Serializable {
    private static final long serialVersionUID = 415086129345708401L;
    /**
     * 管理员id
     */
    private Long id;
    /**
     * 管理员账号
     */
    private String adminName;
    /**
     * 管理员密码
     */
    private String adminPassword;
    /**
     * 管理员邮箱
     */
    private String adminEmail;
    /**
     * 管理员手机
     */
    private String adminPhone;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }

    public String getAdminPassword() {
        return adminPassword;
    }

    public void setAdminPassword(String adminPassword) {
        this.adminPassword = adminPassword;
    }

    public String getAdminEmail() {
        return adminEmail;
    }

    public void setAdminEmail(String adminEmail) {
        this.adminEmail = adminEmail;
    }

    public String getAdminPhone() {
        return adminPhone;
    }

    public void setAdminPhone(String adminPhone) {
        this.adminPhone = adminPhone;
    }

}

