package com.omg.entity;

import java.util.Date;

/**
 * Created by admin on 2016/10/24.
 */
public class GoodsCategory {
    private Integer goodsCategoryId;
    private String goodsCategoryName;
    private Date createTime;
    private Date updateTime;
    private String createPerson;
    public Integer getGoodsCategoryId() {
        return goodsCategoryId;
    }

    public void setGoodsCategoryId(Integer goodsCategoryId) {
        this.goodsCategoryId = goodsCategoryId;
    }

    public String getGoodsCategoryName() {
        return goodsCategoryName;
    }

    public void setGoodsCategoryName(String goodsCategoryName) {
        this.goodsCategoryName = goodsCategoryName;
    }

    public String getCreatePerson() {
        return createPerson;
    }

    public void setCreatePerson(String  createPerson) {
        this.createPerson = createPerson;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        return "GoodsCategory{" +
                "goodsCategoryId=" + goodsCategoryId +
                ", goodsCategoryName='" + goodsCategoryName + '\'' +
                ", createPerson=" + createPerson +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }
}
