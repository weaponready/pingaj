package org.pingaj.app.vo.request;

/**
 * Creator: JimmyLin
 * DateTime: 14-8-14 下午9:09
 * Summary:
 */
public class PaginationRequest {
    private int page = 1;
    private int size = 10;
    private String position;

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }
}
