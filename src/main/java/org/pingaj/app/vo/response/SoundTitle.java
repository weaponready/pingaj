package org.pingaj.app.vo.response;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;

/**
 * Created by Jamy on 14-8-17.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SoundTitle {

    private int id;
    private String position;
    private String title;
    private String url;
    private String content;
    private List<SoundTitle> children;

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

    public List<SoundTitle> getChildren() {
        return children;
    }

    public void setChildren(List<SoundTitle> children) {
        this.children = children;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
