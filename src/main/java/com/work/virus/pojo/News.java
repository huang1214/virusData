package com.work.virus.pojo;

import java.io.Serializable;
import java.util.Date;

public class News implements Serializable {
    private String id;

    private Date pubdate;

    private String pubdatestr;

    private String title;

    private String summary;

    private String infosource;

    private String sourceurl;

    private String provincename;

    private Date createtime;

    private Date modifytime;

    private static final long serialVersionUID = 1L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public Date getPubdate() {
        return pubdate;
    }

    public void setPubdate(Date pubdate) {
        this.pubdate = pubdate;
    }

    public String getPubdatestr() {
        return pubdatestr;
    }

    public void setPubdatestr(String pubdatestr) {
        this.pubdatestr = pubdatestr == null ? null : pubdatestr.trim();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary == null ? null : summary.trim();
    }

    public String getInfosource() {
        return infosource;
    }

    public void setInfosource(String infosource) {
        this.infosource = infosource == null ? null : infosource.trim();
    }

    public String getSourceurl() {
        return sourceurl;
    }

    public void setSourceurl(String sourceurl) {
        this.sourceurl = sourceurl == null ? null : sourceurl.trim();
    }

    public String getProvincename() {
        return provincename;
    }

    public void setProvincename(String provincename) {
        this.provincename = provincename == null ? null : provincename.trim();
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Date getModifytime() {
        return modifytime;
    }

    public void setModifytime(Date modifytime) {
        this.modifytime = modifytime;
    }
}