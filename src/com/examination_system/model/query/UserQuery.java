package com.examination_system.model.query;

/**
 * @program examination-system
 * @description: user query entity
 * @author: yao
 * @create: 2020/11/14 13:23
 */
public class UserQuery extends BaseParam<UserQuery> {
    /**
     * 主键id
     */
    private Long id;

    /**
     * 用户名
     */
    private String name;

    /**
     * 工号/学号
     */
    private String userNo;

    /**
     * 用户类型: 0 学生 1老师
     */
    private Integer userType;

    /**
     * 用户密码
     */
    private String password;

    /**
     * 是否删除 0是 1否
     */
    private Integer isDelete;

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

    public String getUserNo() {
        return userNo;
    }

    public void setUserNo(String userNo) {
        this.userNo = userNo;
    }

    public Integer getUserType() {
        return userType;
    }

    public void setUserType(Integer userType) {
        this.userType = userType;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

    @Override
    public String toString() {
        return "UserQuery{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", userNo='" + userNo + '\'' +
                ", userType=" + userType +
                ", isDelete=" + isDelete +
                '}';
    }
}
