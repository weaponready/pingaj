package org.pingaj.app.vo.response;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by Jamy on 14-8-17.
 */
@XmlRootElement(name="photo")
public class Photo {

    private int id;
    private String position;
    private String title;
    private String url;
    private String description;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
