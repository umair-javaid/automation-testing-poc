package com.softech.wlcms.pages.courses.online;


import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by umair.javaid on 1/27/2016.
 */


public class OnlineLeftNavigationPage extends PageObject {
    private static final Logger logger = LoggerFactory.getLogger(OnlineLeftNavigationPage.class);

    @FindBy(id = "nav_accordion_0")
    private WebElementFacade overview;

    @FindBy(id = "leftNavPanel")
    private WebElementFacade leftNav;

    @FindBy(id = "nav_accordion_1")
    private WebElementFacade content;

    public void clickContent() {
        content.waitUntilClickable();
        content.click();
        logger.info("click Content");
    }

    public void clickOvervew()
    {
        overview.waitUntilClickable();
        overview.click();
        logger.info("Click Overvew");
    }

}
