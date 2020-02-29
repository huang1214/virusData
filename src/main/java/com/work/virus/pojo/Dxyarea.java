package com.work.virus.pojo;

import java.io.Serializable;
import java.util.Date;

public class Dxyarea implements Serializable {
    private String provincename;

    private String provinceenglishname;

    private String provinceZipcode;

    private String cityname;

    private String cityenglishname;

    private String cityZipcode;

    private Integer provinceConfirmedcount;

    private Integer provinceSuspectedcount;

    private Integer provinceCuredcount;

    private Integer provinceDeadcount;

    private Integer cityConfirmedcount;

    private Integer citySuspectedcount;

    private Integer cityCuredcount;

    private Integer cityDeadcount;

    private Date updatetime;

    private static final long serialVersionUID = 1L;

    @Override
    public String toString() {
        return "Dxyarea{" +
                "provincename='" + provincename + '\'' +
                ", provinceenglishname='" + provinceenglishname + '\'' +
                ", provinceZipcode='" + provinceZipcode + '\'' +
                ", cityname='" + cityname + '\'' +
                ", cityenglishname='" + cityenglishname + '\'' +
                ", cityZipcode='" + cityZipcode + '\'' +
                ", provinceConfirmedcount=" + provinceConfirmedcount +
                ", provinceSuspectedcount=" + provinceSuspectedcount +
                ", provinceCuredcount=" + provinceCuredcount +
                ", provinceDeadcount=" + provinceDeadcount +
                ", cityConfirmedcount=" + cityConfirmedcount +
                ", citySuspectedcount=" + citySuspectedcount +
                ", cityCuredcount=" + cityCuredcount +
                ", cityDeadcount=" + cityDeadcount +
                ", updatetime=" + updatetime +
                '}';
    }

    public String getProvincename() {
        return provincename;
    }

    public void setProvincename(String provincename) {
        this.provincename = provincename == null ? null : provincename.trim();
    }

    public String getProvinceenglishname() {
        return provinceenglishname;
    }

    public void setProvinceenglishname(String provinceenglishname) {
        this.provinceenglishname = provinceenglishname == null ? null : provinceenglishname.trim();
    }

    public String getProvinceZipcode() {
        return provinceZipcode;
    }

    public void setProvinceZipcode(String provinceZipcode) {
        this.provinceZipcode = provinceZipcode == null ? null : provinceZipcode.trim();
    }

    public String getCityname() {
        return cityname;
    }

    public void setCityname(String cityname) {
        this.cityname = cityname == null ? null : cityname.trim();
    }

    public String getCityenglishname() {
        return cityenglishname;
    }

    public void setCityenglishname(String cityenglishname) {
        this.cityenglishname = cityenglishname == null ? null : cityenglishname.trim();
    }

    public String getCityZipcode() {
        return cityZipcode;
    }

    public void setCityZipcode(String cityZipcode) {
        this.cityZipcode = cityZipcode == null ? null : cityZipcode.trim();
    }

    public Integer getProvinceConfirmedcount() {
        return provinceConfirmedcount;
    }

    public void setProvinceConfirmedcount(Integer provinceConfirmedcount) {
        this.provinceConfirmedcount = provinceConfirmedcount;
    }

    public Integer getProvinceSuspectedcount() {
        return provinceSuspectedcount;
    }

    public void setProvinceSuspectedcount(Integer provinceSuspectedcount) {
        this.provinceSuspectedcount = provinceSuspectedcount;
    }

    public Integer getProvinceCuredcount() {
        return provinceCuredcount;
    }

    public void setProvinceCuredcount(Integer provinceCuredcount) {
        this.provinceCuredcount = provinceCuredcount;
    }

    public Integer getProvinceDeadcount() {
        return provinceDeadcount;
    }

    public void setProvinceDeadcount(Integer provinceDeadcount) {
        this.provinceDeadcount = provinceDeadcount;
    }

    public Integer getCityConfirmedcount() {
        return cityConfirmedcount;
    }

    public void setCityConfirmedcount(Integer cityConfirmedcount) {
        this.cityConfirmedcount = cityConfirmedcount;
    }

    public Integer getCitySuspectedcount() {
        return citySuspectedcount;
    }

    public void setCitySuspectedcount(Integer citySuspectedcount) {
        this.citySuspectedcount = citySuspectedcount;
    }

    public Integer getCityCuredcount() {
        return cityCuredcount;
    }

    public void setCityCuredcount(Integer cityCuredcount) {
        this.cityCuredcount = cityCuredcount;
    }

    public Integer getCityDeadcount() {
        return cityDeadcount;
    }

    public void setCityDeadcount(Integer cityDeadcount) {
        this.cityDeadcount = cityDeadcount;
    }

    public Date getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }
}