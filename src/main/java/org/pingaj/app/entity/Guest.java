package org.pingaj.app.entity;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Jamy on 14-8-14.
 */
@Entity
@Table(name = "Ok3w_Guest")
public class Guest extends BaseEntity {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "pID")
    private Integer pId;
    @Column(name = "Title")
    private String title;
    @Column(name = "UserName")
    private String userName;
    @Column(name = "Mail")
    private String mail;
    @Column(name = "Homepage")
    private String homepage;
    @Column(name = "Content")
    private String content;
    @Column(name = "QQ")
    private String qq;
    @Column(name = "TypeID")
    private Integer typeId;
    @Column(name = "TableID")
    private Integer tableId;
    @Column(name = "AddTime")
    private Date addTime;
    @Column(name = "Ip")
    private String ip;
    @Column(name = "IsPass")
    private Integer isPass;
    @Column(name = "IsTop")
    private Integer isTop;
    @Column(name = "ReTime")
    private Date reTime;
    @Column(name = "ReUser")
    private String reUser;
    @Column(name = "Ad_Ask")
    private String adAsk;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getpId() {
        return pId;
    }

    public void setpId(Integer pId) {
        this.pId = pId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getHomepage() {
        return homepage;
    }

    public void setHomepage(String homepage) {
        this.homepage = homepage;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public Integer getTableId() {
        return tableId;
    }

    public void setTableId(Integer tableId) {
        this.tableId = tableId;
    }

    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public Integer getIsPass() {
        return isPass;
    }

    public void setIsPass(Integer isPass) {
        this.isPass = isPass;
    }

    public Integer getIsTop() {
        return isTop;
    }

    public void setIsTop(Integer isTop) {
        this.isTop = isTop;
    }

    public Date getReTime() {
        return reTime;
    }

    public void setReTime(Date reTime) {
        this.reTime = reTime;
    }

    public String getReUser() {
        return reUser;
    }

    public void setReUser(String reUser) {
        this.reUser = reUser;
    }

    public String getAdAsk() {
        return adAsk;
    }

    public void setAdAsk(String adAsk) {
        this.adAsk = adAsk;
    }
}
