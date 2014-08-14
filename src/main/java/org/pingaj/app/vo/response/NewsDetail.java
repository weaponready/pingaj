package org.pingaj.app.vo.response;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * Creator: JimmyLin
 * DateTime: 14-8-14 下午8:59
 * Summary: 新闻详情
 */
@XmlRootElement(name = "newsdetail")
@XmlType(propOrder = {"id", "position", "title", "content", "author", "addtime"})
public class NewsDetail {

    private int id;
    private String position;
    private String title;
    private String content;
    private String author;
    private String addtime;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

    public String getAddtime() {
        return addtime;
    }

    public void setAddtime(String addtime) {
        this.addtime = addtime;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }
}
