package com.t3h.baovip;

public class ItemDataNew {
    private String title;
    private String content;
    private String linkImage;
    private String linkDetail;

    public ItemDataNew(String title, String content, String linkImage, String linkDetail) {
        this.title = title;
        this.content = content;
        this.linkImage = linkImage;
        this.linkDetail = linkDetail;
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

    public String getLinkImage() {
        return linkImage;
    }

    public void setLinkImage(String linkImage) {
        this.linkImage = linkImage;
    }

    public String getLinkDetail() {
        return linkDetail;
    }

    public void setLinkDetail(String linkDetail) {
        this.linkDetail = linkDetail;
    }
}
