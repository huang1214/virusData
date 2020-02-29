package com.work.virus.pojo;

/**
 * Description:
 * User:曹文杰
 * Date:2020-02-24 10:53
 */
public class Page {
    // select * from   videos  limit 5   5
    private Integer page;   // 页数
    private Integer pageTotal;// 每页多少条

    public Page(Integer page, Integer pageTotal) {
        this.page = (page-1)*pageTotal;// 计算出 从第几条开始分页
        this.pageTotal = pageTotal;
    }
    public Page() {

    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getPageTotal() {
        return pageTotal;
    }

    public void setPageTotal(Integer pageTotal) {
        this.pageTotal = pageTotal;
    }

    @Override
    public String toString() {
        return "Page{" +
                "page=" + page +
                ", pageTotal=" + pageTotal +
                '}';
    }
}
