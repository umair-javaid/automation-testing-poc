package com.softech.wlcms.pages.courses.online.content;

/**
 * Copyright (c) 12/28/15, CreditCards.com. All Rights Reserved.
 * User: jeffreyhynes
 * Date: 12/28/15
 * com.ls360.wlcms
 */
public enum PresentationTemplateEnum implements TemplateEnum {
    VISUAL_LEFT("Template_Visual_Left_ID","Visual Left",0),
    VISUAL_RIGHT("Template_Visual_Right_ID","Visual Right",1),
    VISUAL_TOP("Template_Visual_Top_ID","Visual Top",2),
    VISUAL_BOTTOM("Template_Visual_Bottom_ID","Visual Bottom",3),
    VISUAL_STREAMING("Template_Visual_Streaming_Center_ID","Streaming Video",10);

    private String internalID;
    private String title;
    private int iconIndex;
    private String iconClass;

    PresentationTemplateEnum(final String internalID,String title,final int iconIndex){
        this.internalID = internalID;
        this.title = title;
        this.iconIndex = iconIndex;
        this.iconClass = "temp-icon-" + iconIndex;
    }

    public String getIconClass(){
        return iconClass;
    }

    public int getIconIndex(){
        return iconIndex;
    }

    public String getInternalID(){
        return internalID;
    }

    public String getTitle(){
        return title;
    }
}
