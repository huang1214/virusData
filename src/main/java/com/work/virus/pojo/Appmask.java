package com.work.virus.pojo;

import java.io.Serializable;

public class Appmask implements Serializable {
    private String id;

    private String shopname;

    private String appname;

    private String masktype;

    private String buytype;

    private String price;

    private String time;

    private String notice;

    private String coverPath;

    private static final long serialVersionUID = 1L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getShopname() {
        return shopname;
    }

    public void setShopname(String shopname) {
        this.shopname = shopname == null ? null : shopname.trim();
    }

    public String getAppname() {
        return appname;
    }

    public void setAppname(String appname) {
        this.appname = appname == null ? null : appname.trim();
    }

    public String getMasktype() {
        return masktype;
    }

    public void setMasktype(String masktype) {
        this.masktype = masktype == null ? null : masktype.trim();
    }

    public String getBuytype() {
        return buytype;
    }

    public void setBuytype(String buytype) {
        this.buytype = buytype == null ? null : buytype.trim();
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price == null ? null : price.trim();
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time == null ? null : time.trim();
    }

    public String getNotice() {
        return notice;
    }

    public void setNotice(String notice) {
        this.notice = notice == null ? null : notice.trim();
    }

    public String getCoverPath() {
        return coverPath;
    }

    public void setCoverPath(String coverPath) {
        this.coverPath = coverPath == null ? null : coverPath.trim();
    }

    @Override
    public String toString() {
        return "Appmask{" +
                "id='" + id + '\'' +
                ", shopname='" + shopname + '\'' +
                ", appname='" + appname + '\'' +
                ", masktype='" + masktype + '\'' +
                ", buytype='" + buytype + '\'' +
                ", price='" + price + '\'' +
                ", time='" + time + '\'' +
                ", notice='" + notice + '\'' +
                ", coverPath='" + coverPath + '\'' +
                '}';
    }
}