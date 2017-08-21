package com.softech.wlcms.pages.courses.online.content;

/**
 * Copyright (c) 12/28/15, CreditCards.com. All Rights Reserved.
 * User: jeffreyhynes
 * Date: 12/28/15
 * com.ls360.wlcms
 */
public enum ActivityTemplateEnum implements TemplateEnum {
    MC_SCENARIO("Template_MC_Template_A","MC Scenario",11),
    DND_MATCHING("Template_DND_Matching_Template_A","Drag and Drop Matching",14),
    DND_IMAGE("Template_DND_Image_Template_A)","Drag and Drop Image",25),
    DND_CATEGORY("Template_DND_Category_Template_A","Drag and Drop Category",15),
    CHAR_COLUMN("Template_CharColumn_Template_A","Chart",13);

    private String internalID;
    private int iconIndex;
    private String title;
    private String iconClass;

    ActivityTemplateEnum(final String internalID,String title,final int iconIndex){
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

    @Override
    public String getTitle(){
        return title;
    }
}
