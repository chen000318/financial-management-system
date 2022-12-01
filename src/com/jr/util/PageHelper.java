package com.jr.util;

import java.util.List;

public class PageHelper<T> {

    private int totalCount;//总条数
    private int pageSize;//总页数
    private int indexPage;//当前页面
    private int totalPage;//
    private List<T> pageList;

    private int startNum;

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getIndexPage() {
        return indexPage;
    }

    public void setIndexPage(int indexPage) {
        this.indexPage = indexPage;
    }

    //计算总页数：总条数    17/3  62  =
    public int getTotalPage() {
        //总计条数除以总计页数如果能整除name返回总计页数 如果不能整除那么返回 取整+1
        return totalCount%pageSize==0?
                totalCount/pageSize:
                totalCount/pageSize+1;
    }

   /* public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }
*/
    public List<T> getPageList() {
        return pageList;
    }

    public void setPageList(List<T> pageList) {
        this.pageList = pageList;
    }

    //给开始行数赋值：开始行==（当前页-1）* 每页显示的行数
    public int getStartNum() {
        return (indexPage-1)*pageSize;
    }

 /*   public void setStartNum(int startNum) {
        this.startNum = startNum;
    }*/
}
