package com.work.virus.pojo;

import java.io.Serializable;
import java.util.Date;

public class Provinces implements Serializable {
    private String id;

    private String proName;

    private Integer confirmedNum;

    private Integer cureNum;

    private Integer deathNum;

    private Date fabuTime;

    private static final long serialVersionUID = 1L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getProName() {
        return proName;
    }

    public void setProName(String proName) {
        this.proName = proName == null ? null : proName.trim();
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

    public Date getFabuTime() {
        return fabuTime;
    }

    public void setFabuTime(Date fabuTime) {
        this.fabuTime = fabuTime;
    }
}