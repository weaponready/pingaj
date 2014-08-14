package org.pingaj.app.vo.response;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * Creator: JimmyLin
 * DateTime: 14-8-14 下午7:05
 * Summary: 新闻标题
 */
@XmlRootElement(name = "newstitle")
@XmlType(propOrder = {"id" , "position", "title", "addtime"})
public class NewsTitle {

    private int id;
    private String position;
    private String title;
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
