package org.pingaj.app.vo.response;

import com.fasterxml.jackson.annotation.JsonInclude;

import javax.xml.bind.annotation.*;
import java.util.List;

/**
 * Created by Jamy on 14-8-15.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@XmlRootElement(name = "work")
@XmlAccessorType(XmlAccessType.FIELD)
public class WorkTitle {

    private int id;
    private String position;
    private String title;
    @XmlElementWrapper(name = "links")
    @XmlElement(name="link")
    private List<WorkTitle> children;

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

    public List<WorkTitle> getChildren() {
        return children;
    }

    public void setChildren(List<WorkTitle> children) {
        this.children = children;
    }
}
