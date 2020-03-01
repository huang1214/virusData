package com.work.virus.pojo;

import java.io.Serializable;

public class Store implements Serializable {
    private Integer storeId;

    private String province;

    private String city;

    private String area;

    private String storename;

    private String location;

    private static final long serialVersionUID = 1L;

    public Integer getStoreId() {
        return storeId;
    }

    public void setStoreId(Integer storeId) {
        this.storeId = storeId;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province == null ? null : province.trim();
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city == null ? null : city.trim();
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area == null ? null : area.trim();
    }

    public String getStorename() {
        return storename;
    }

    public void setStorename(String storename) {
        this.storename = storename == null ? null : storename.trim();
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location == null ? null : location.trim();
    }

    @Override
    public String toString() {
        return "Store{" +
                "storeId=" + storeId +
                ", province='" + province + '\'' +
                ", city='" + city + '\'' +
                ", area='" + area + '\'' +
                ", storename='" + storename + '\'' +
                ", location='" + location + '\'' +
                '}';
    }
}