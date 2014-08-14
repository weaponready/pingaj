package org.pingaj.app.vo.response;

/**
 * Creator: JimmyLin
 * DateTime: 14-8-14 下午7:05
 * Summary: 新闻标题
 */
public class NewsTitle {

    private int id;
    private String position;
    private String title;
    private String addTime;

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

    public String getAddTime() {
        return addTime;
    }

    public void setAddTime(String addTime) {
        this.addTime = addTime;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }
}
