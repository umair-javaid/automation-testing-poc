package com.softech.wlcms.pages.courses.webinar;

import com.softech.wlcms.actions.WaitActions;
import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by umair.javaid on 1/28/2016.
 */
public class WebinarLeftNavigationPage extends WaitActions {
        private static final Logger logger = LoggerFactory.getLogger(WebinarLeftNavigationPage.class);


    @FindBy(id ="lnkSchedule")
    private WebElementFacade webinar;

    @FindBy(id = "nav_instructor")
    private WebElementFacade instructor;

    @FindBy (id = "lnkWebinarSetup")
    private WebElementFacade webinarSetup;

    @FindBy(id = "nav_accordion_0_wb")
    private WebElementFacade overviewWebinar;


    public void clickWebinar(){
        webinar.waitUntilClickable();
        webinar.click();
        logger.info("Navigate to Webinar");
    }

    public void clickInstructor(){
        instructor.waitUntilClickable();
        instructor.click();
        logger.info("Navigate to Instructor");
    }
    public void clickWebinarSetup(){
        webinarSetup.waitUntilClickable();
        webinarSetup.click();
        logger.info("Navigate to Webinar Setup");
    }

    public void navigateToOverview() {
//        customWaitUntilUnLoaded(By.cssSelector(".alert.alert-success.alert-dismissible.fade.in"));
        waitUntilLoaded(overviewWebinar);
        overviewWebinar.click();
        logger.info("Click On Overview");
    }
}
