package com.work.virus.pojo;

import java.io.Serializable;

public class City implements Serializable {
    private String id;

    private String cityName;

    private Integer addNum;

    private Integer confirmedNum;

    private Integer cureNum;

    private Integer deathNum;

    private static final long serialVersionUID = 1L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName == null ? null : cityName.trim();
    }

    public Integer getAddNum() {
        return addNum;
    }

    public void setAddNum(Integer addNum) {
        this.addNum = addNum;
    }

    public Integer getConfirmedNum() {
        return confirmedNum;
    }

    public void setConfirmedNum(Integer confirmedNum) {
        this.confirmedNum = confirmedNum;
    }

    public Integer getCureNum() {
        return cureNum;
    }

    public void setCureNum(Integer cureNum) {
        this.cureNum = cureNum;
    }

    public Integer getDeathNum() {
        return deathNum;
    }

    public void setDeathNum(Integer deathNum) {
        this.deathNum = deathNum;
    }
}