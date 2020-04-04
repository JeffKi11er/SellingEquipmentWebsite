package com.example.thitbvsinh.item;

public class ContactLink {
    private String linkTitle;
    private String phoneTitle;
    private String mediaTitle;
    private String websiteTitle;
    private String phone1;
    private String phone2;
    private String phone3;
    private String nameWebsite;
    private String contact1;
    private String contact2;
    private String contact3;
    private String email;

    public ContactLink(String linkTitle, String phoneTitle, String mediaTitle, String websiteTitle, String phone1, String phone2, String phone3, String nameWebsite,String email, String contact1, String contact2, String contact3) {
        this.linkTitle = linkTitle;
        this.phoneTitle = phoneTitle;
        this.mediaTitle = mediaTitle;
        this.websiteTitle = websiteTitle;
        this.phone1 = phone1;
        this.phone2 = phone2;
        this.phone3 = phone3;
        this.nameWebsite = nameWebsite;
        this.email = email;
        this.contact1 = contact1;
        this.contact2 = contact2;
        this.contact3 = contact3;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLinkTitle() {
        return linkTitle;
    }

    public void setLinkTitle(String linkTitle) {
        this.linkTitle = linkTitle;
    }

    public String getPhoneTitle() {
        return phoneTitle;
    }

    public void setPhoneTitle(String phoneTitle) {
        this.phoneTitle = phoneTitle;
    }

    public String getMediaTitle() {
        return mediaTitle;
    }

    public void setMediaTitle(String mediaTitle) {
        this.mediaTitle = mediaTitle;
    }

    public String getWebsiteTitle() {
        return websiteTitle;
    }

    public void setWebsiteTitle(String websiteTitle) {
        this.websiteTitle = websiteTitle;
    }

    public String getPhone1() {
        return phone1;
    }

    public void setPhone1(String phone1) {
        this.phone1 = phone1;
    }

    public String getPhone2() {
        return phone2;
    }

    public void setPhone2(String phone2) {
        this.phone2 = phone2;
    }

    public String getPhone3() {
        return phone3;
    }

    public void setPhone3(String phone3) {
        this.phone3 = phone3;
    }

    public String getNameWebsite() {
        return nameWebsite;
    }

    public void setNameWebsite(String nameWebsite) {
        this.nameWebsite = nameWebsite;
    }

    public String getContact1() {
        return contact1;
    }

    public void setContact1(String contact1) {
        this.contact1 = contact1;
    }

    public String getContact2() {
        return contact2;
    }

    public void setContact2(String contact2) {
        this.contact2 = contact2;
    }

    public String getContact3() {
        return contact3;
    }

    public void setContact3(String contact3) {
        this.contact3 = contact3;
    }
}
