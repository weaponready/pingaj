package org.pingaj.app.util.persistent;

import java.util.List;

/**
 * Creator: JimmyLin
 * DateTime: 14-8-14 下午12:03
 * Summary:
 */
public class Page {

    private int total;
    private List items;

    public Page() {
    }

    public Page(int total, List items) {
        this.total = total;
        this.items = items;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List getItems() {
        return items;
    }

    public void setItems(List items) {
        this.items = items;
    }

    public int totalPages(int size) {
        int count = total % size == 0 ? total / size : total / size + 1;
        return count;
    }

}
