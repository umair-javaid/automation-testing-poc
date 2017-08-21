package com.softech.wlcms.util;

public class Course {
    private String id;
    private String title;
    private String type;
    private String lastModified;
    private String status;

    public String getId(){
        return id;
    }

    public String getLastModified(){
        return lastModified;
    }

    public String getStatus(){
        return status;
    }

    public String getTitle(){
        return title;
    }

    public String getType(){
        return type;
    }

    public void setId(final String id){
        this.id = id;
    }

    public void setLastModified(final String lastModified){
        this.lastModified = lastModified;
    }

    public void setStatus(final String status){
        this.status = status;
    }

    public void setTitle(final String title){
        this.title = title;
    }

    public void setType(final String type){
        this.type = type;
    }
}
