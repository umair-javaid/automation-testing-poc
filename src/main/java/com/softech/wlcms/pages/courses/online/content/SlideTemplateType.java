package com.softech.wlcms.pages.courses.online.content;

/**
 * Copyright (c) 12/28/15, CreditCards.com. All Rights Reserved.
 * User: jeffreyhynes
 * Date: 12/28/15
 * com.ls360.wlcms
 */
public enum SlideTemplateType{
    PRESENTATION("PresentationTemplate","Presentation Templates"),
    ACTIVITY("ActivityTemplate","Activity Templates");

    private String id;
    private String title;

    SlideTemplateType(final String id,final String title){
        this.id = id;
        this.title = title;
    }

    public String getId(){
        return id;
    }

    public String getTitle(){
        return title;
    }
}
