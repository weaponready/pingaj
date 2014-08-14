package org.pingaj.app.vo.response;

import javax.xml.bind.annotation.*;
import java.util.List;

/**
 * Created by Jamy on 14-8-14.
 */
@XmlRootElement(name = "response")
@XmlAccessorType(XmlAccessType.FIELD)
public class Pagination {

    private String first;
    private String pre;
    private String next;
    private String last;
    private int total;
    private int size;
    private int page;
    private int pages;

    @XmlElementRefs({
            @XmlElementRef(type=NewsTitle.class)
    })
    private List items;

    public Pagination(List items, int page, int size, int total) {
        this.items = items;
        this.page = page;
        this.size = size;
        this.total = total;
        this.pages = total % size == 0 ? total / size : total / size + 1;
    }

    public Pagination() {

    }

    public String getFirst() {
        return first;
    }

    public void setFirst(String first) {
        this.first = first;
    }

    public String getPre() {
        return pre;
    }

    public void setPre(String pre) {
        this.pre = pre;
    }

    public String getNext() {
        return next;
    }

    public void setNext(String next) {
        this.next = next;
    }

    public String getLast() {
        return last;
    }

    public void setLast(String last) {
        this.last = last;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public List getItems() {
        return items;
    }

    public void setItems(List items) {
        this.items = items;
    }

    public void ready(String url) {

    }
}
