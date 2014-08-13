package org.pingaj.app.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by Jamy on 14-8-14.
 */
@Entity
@Table(name = "Ok3w_Class")
public class Item extends BaseEntity {

    @Id
    @Column(name = "ID")
    private Integer id;
    @Column(name = "SortName")
    private String sortName;
    @Column(name = "ChannelID")
    private Integer channelId;
    @Column(name = "ParentID")
    private Integer parenteId;
    @Column(name = "SortPath")
    private String sortPath;
    @Column(name = "OrderID")
    private Integer orderId;
    @Column(name = "IsPic")
    private Integer isPic;
    @Column(name = "PageSize")
    private Integer pageSize;
    @Column(name = "IsNav")
    private Integer isNav;
    @Column(name = "gotoURL")
    private String gotoUrl;
    @Column(name = "picURL")
    private String picUrl;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSortName() {
        return sortName;
    }

    public void setSortName(String sortName) {
        this.sortName = sortName;
    }

    public Integer getChannelId() {
        return channelId;
    }

    public void setChannelId(Integer channelId) {
        this.channelId = channelId;
    }

    public Integer getParenteId() {
        return parenteId;
    }

    public void setParenteId(Integer parenteId) {
        this.parenteId = parenteId;
    }

    public String getSortPath() {
        return sortPath;
    }

    public void setSortPath(String sortPath) {
        this.sortPath = sortPath;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Integer getIsPic() {
        return isPic;
    }

    public void setIsPic(Integer isPic) {
        this.isPic = isPic;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getIsNav() {
        return isNav;
    }

    public void setIsNav(Integer isNav) {
        this.isNav = isNav;
    }

    public String getGotoUrl() {
        return gotoUrl;
    }

    public void setGotoUrl(String gotoUrl) {
        this.gotoUrl = gotoUrl;
    }

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }
}
