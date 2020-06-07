package com.ydbzs.pojo;

import javax.persistence.Id;
import javax.validation.constraints.NotNull;

public class User {
    @Id
    private Integer uid;

    @NotNull(message = "名称不能为空")
    private String username;

    @NotNull(message = "手机号不能为空")
    private String telephone;

    @NotNull(message = "密码不能为空")
    private String password;

    private String dbsalt;

    /**
     * @return uid
     */
    public Integer getUid() {
        return uid;
    }

    /**
     * @param uid
     */
    public void setUid(Integer uid) {
        this.uid = uid;
    }

    /**
     * @return username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return telephone
     */
    public String getTelephone() {
        return telephone;
    }

    public String getDbsalt() {
        return dbsalt;
    }

    public void setDbsalt(String dbsalt) {
        this.dbsalt = dbsalt;
    }

    /**
     * @param telephone
     */
    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    /**
     * @return password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }
}