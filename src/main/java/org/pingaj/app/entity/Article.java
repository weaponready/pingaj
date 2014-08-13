package org.pingaj.app.entity;


import javax.persistence.*;
import java.util.Date;

/**
 * Creator: JimmyLin
 * DateTime: 14-8-13 下午3:48
 * Summary:
 */
@Entity
@Table(name="Ok3w_Article")
public class Article extends BaseEntity {

    @Id
    @Column(name = "ID")
    private Integer id;
    @Column(name = "ChannelId")
    private Integer channelId;
    @Column(name = "ClassId")
    private Integer classId;
    @Column(name = "SortPath")
    private String sortPath;
    @Column(name = "Title")
    private String title;
    @Column(name = "TitleColor")
    private String titleColor;
    @Column(name = "TitleURL")
    private String titleUrl;
    @Column(name = "Keywords")
    private String keywords;
    @Column(name = "Description")
    private String description;
    @Column(name = "Content")
    private String content;
    @Column(name = "Author")
    private String author;
    @Column(name = "ComeFrom")
    private String comeFrom;
    @Column(name = "AddTime")
    private Date addTime;
    @Column(name = "Inputer")
    private String inputer;
    @Column(name = "IsPic")
    private Integer isPic;
    @Column(name = "PicFile")
    private String picFile;
    @Column(name = "IsPass")
    private Integer isPass;
    @Column(name = "IsTop")
    private Integer isTop;
    @Column(name = "IsDelete")
    private Integer isDelete;
    @Column(name = "IsCommend")
    private Integer isCommend;
    @Column(name = "IsMove")
    private Integer isMove;
    @Column(name = "IsPlay")
    private Integer isPlay;
    @Column(name = "IsIndexImg")
    private Integer isIndexImg;
    @Column(name = "IsUserAdd")
    private Integer isUserAdd;
    @Column(name = "GiveJifen")
    private Integer giveJifen;
    @Column(name = "vUserGroupId")
    private Integer vUserGroupId;
    @Column(name = "vUserMore")
    private Integer vUserMore;
    @Column(name = "vUserJifen")
    private Integer vUserJifen;
    @Column(name = "pMoodStr")
    private String pMoodStr;
    @Column(name = "Hits")
    private Integer hits;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getChannelId() {
        return channelId;
    }

    public void setChannelId(Integer channelId) {
        this.channelId = channelId;
    }

    public Integer getClassId() {
        return classId;
    }

    public void setClassId(Integer classId) {
        this.classId = classId;
    }

    public String getSortPath() {
        return sortPath;
    }

    public void setSortPath(String sortPath) {
        this.sortPath = sortPath;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitleColor() {
        return titleColor;
    }

    public void setTitleColor(String titleColor) {
        this.titleColor = titleColor;
    }

    public String getTitleUrl() {
        return titleUrl;
    }

    public void setTitleUrl(String titleUrl) {
        this.titleUrl = titleUrl;
    }

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getComeFrom() {
        return comeFrom;
    }

    public void setComeFrom(String comeFrom) {
        this.comeFrom = comeFrom;
    }

    public Date getAddTime() {
        return addTime;
    }

    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }

    public String getInputer() {
        return inputer;
    }

    public void setInputer(String inputer) {
        this.inputer = inputer;
    }

    public Integer getIsPic() {
        return isPic;
    }

    public void setIsPic(Integer isPic) {
        this.isPic = isPic;
    }

    public String getPicFile() {
        return picFile;
    }

    public void setPicFile(String picFile) {
        this.picFile = picFile;
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

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

    public Integer getIsCommend() {
        return isCommend;
    }

    public void setIsCommend(Integer isCommend) {
        this.isCommend = isCommend;
    }

    public Integer getIsMove() {
        return isMove;
    }

    public void setIsMove(Integer isMove) {
        this.isMove = isMove;
    }

    public Integer getIsPlay() {
        return isPlay;
    }

    public void setIsPlay(Integer isPlay) {
        this.isPlay = isPlay;
    }

    public Integer getIsIndexImg() {
        return isIndexImg;
    }

    public void setIsIndexImg(Integer isIndexImg) {
        this.isIndexImg = isIndexImg;
    }

    public Integer getIsUserAdd() {
        return isUserAdd;
    }

    public void setIsUserAdd(Integer isUserAdd) {
        this.isUserAdd = isUserAdd;
    }

    public Integer getGiveJifen() {
        return giveJifen;
    }

    public void setGiveJifen(Integer giveJifen) {
        this.giveJifen = giveJifen;
    }

    public Integer getvUserGroupId() {
        return vUserGroupId;
    }

    public void setvUserGroupId(Integer vUserGroupId) {
        this.vUserGroupId = vUserGroupId;
    }

    public Integer getvUserMore() {
        return vUserMore;
    }

    public void setvUserMore(Integer vUserMore) {
        this.vUserMore = vUserMore;
    }

    public Integer getvUserJifen() {
        return vUserJifen;
    }

    public void setvUserJifen(Integer vUserJifen) {
        this.vUserJifen = vUserJifen;
    }

    public String getpMoodStr() {
        return pMoodStr;
    }

    public void setpMoodStr(String pMoodStr) {
        this.pMoodStr = pMoodStr;
    }

    public Integer getHits() {
        return hits;
    }

    public void setHits(Integer hits) {
        this.hits = hits;
    }
}
