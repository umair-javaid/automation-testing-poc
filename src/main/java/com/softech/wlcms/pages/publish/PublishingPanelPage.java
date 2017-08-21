package com.softech.wlcms.pages.publish;


import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.JavascriptExecutor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * Created by umair.javaid on 2/10/2016.
 */

public class PublishingPanelPage extends PageObject {
    private static final Logger logger = LoggerFactory.getLogger(PublishingPanelPage.class);


    @FindBy(id = "leftNavPanel")
    private WebElementFacade leftNav;

    @FindBy(id = "nav_accordion_3")
    private WebElementFacade nav_accordion_3;

    @FindBy(id = "lnkPublishing")
    private WebElementFacade lnkOnlinePublishing;

    @FindBy(id = "lnkWebinarPublishing")
    private WebElementFacade lnkClassroomPublishing;

    @FindBy(css = "#leftMenuOfferOn360Marketplace a")
    private WebElementFacade offerOn360Marketplac;

    @FindBy(css = "#lnkMarketing a")
    private WebElementFacade linkMarketing;

    public void scrollTop() {
        JavascriptExecutor jse = (JavascriptExecutor) getDriver();
        jse.executeScript("scrollTo(0,0);");
    }

    public void openPublishingPanel() {

        if (nav_accordion_3.isDisplayed()) {
            nav_accordion_3.waitUntilClickable();
            nav_accordion_3.click();
            logger.info("Open Publishing Panel");
        }
    }


    public void clickOnlinePublishing() {
        lnkOnlinePublishing.waitUntilVisible();
            lnkOnlinePublishing.click();
            logger.info("Click on Publish Course");
        }

    public void clickOffer360MarketPlace() {
        offerOn360Marketplac.waitUntilVisible();
            offerOn360Marketplac.click();
            logger.info("Click on Offer on 360 Market Place");
    }

    public void clickMarketing() {
        linkMarketing.waitUntilVisible();
            linkMarketing.click();
            logger.info("Click Set Marketing");
    }

    public void clickPublishing() {
        lnkClassroomPublishing.waitUntilVisible();
        lnkClassroomPublishing.click();
        logger.info("Click on Publish Course");
    }


}
