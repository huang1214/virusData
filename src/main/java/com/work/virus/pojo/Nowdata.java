package com.work.virus.pojo;

import java.io.Serializable;

public class Nowdata implements Serializable {
    private String id;

    private String confirmedcount;

    private String confirmedcountYesterday;

    private String suspectedcount;

    private String suspectedcountYesterday;

    private String curedcount;

    private String curedcountYesterday;

    private String deadcount;

    private String deadcountYesterday;

    private String nowconfirmed;

    private String nowconfirmedYesterday;

    private String heavy;

    private String heavyYesterday;

    private static final long serialVersionUID = 1L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getConfirmedcount() {
        return confirmedcount;
    }

    public void setConfirmedcount(String confirmedcount) {
        this.confirmedcount = confirmedcount == null ? null : confirmedcount.trim();
    }

    public String getConfirmedcountYesterday() {
        return confirmedcountYesterday;
    }

    public void setConfirmedcountYesterday(String confirmedcountYesterday) {
        this.confirmedcountYesterday = confirmedcountYesterday == null ? null : confirmedcountYesterday.trim();
    }

    public String getSuspectedcount() {
        return suspectedcount;
    }

    public void setSuspectedcount(String suspectedcount) {
        this.suspectedcount = suspectedcount == null ? null : suspectedcount.trim();
    }

    public String getSuspectedcountYesterday() {
        return suspectedcountYesterday;
    }

    public void setSuspectedcountYesterday(String suspectedcountYesterday) {
        this.suspectedcountYesterday = suspectedcountYesterday == null ? null : suspectedcountYesterday.trim();
    }

    public String getCuredcount() {
        return curedcount;
    }

    public void setCuredcount(String curedcount) {
        this.curedcount = curedcount == null ? null : curedcount.trim();
    }

    public String getCuredcountYesterday() {
        return curedcountYesterday;
    }

    public void setCuredcountYesterday(String curedcountYesterday) {
        this.curedcountYesterday = curedcountYesterday == null ? null : curedcountYesterday.trim();
    }

    public String getDeadcount() {
        return deadcount;
    }

    public void setDeadcount(String deadcount) {
        this.deadcount = deadcount == null ? null : deadcount.trim();
    }

    public String getDeadcountYesterday() {
        return deadcountYesterday;
    }

    public void setDeadcountYesterday(String deadcountYesterday) {
        this.deadcountYesterday = deadcountYesterday == null ? null : deadcountYesterday.trim();
    }

    public String getNowconfirmed() {
        return nowconfirmed;
    }

    public void setNowconfirmed(String nowconfirmed) {
        this.nowconfirmed = nowconfirmed == null ? null : nowconfirmed.trim();
    }

    public String getNowconfirmedYesterday() {
        return nowconfirmedYesterday;
    }

    public void setNowconfirmedYesterday(String nowconfirmedYesterday) {
        this.nowconfirmedYesterday = nowconfirmedYesterday == null ? null : nowconfirmedYesterday.trim();
    }

    public String getHeavy() {
        return heavy;
    }

    public void setHeavy(String heavy) {
        this.heavy = heavy == null ? null : heavy.trim();
    }

    public String getHeavyYesterday() {
        return heavyYesterday;
    }

    public void setHeavyYesterday(String heavyYesterday) {
        this.heavyYesterday = heavyYesterday == null ? null : heavyYesterday.trim();
    }
}