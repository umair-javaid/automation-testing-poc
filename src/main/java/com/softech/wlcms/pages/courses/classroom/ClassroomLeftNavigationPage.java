package com.softech.wlcms.pages.courses.classroom;


import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;

import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.JavascriptExecutor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * Created by umair.javaid on 1/28/2016.
 */

public class ClassroomLeftNavigationPage extends PageObject {
    private static final Logger logger = LoggerFactory.getLogger(ClassroomLeftNavigationPage.class);


    @FindBy(id = "nav_classroomsetup")
    private WebElementFacade classroom;

    @FindBy(id = "nav_instructor")
    private WebElementFacade provider;

    @FindBy(id = "nav_locationList")
    private WebElementFacade location;



    public void navigateToClassroom() {
        classroom.waitUntilVisible();
        classroom.click();
        logger.info("Click on Classroom");
    }

    public void navigateToProvider() {

        provider.waitUntilVisible();
        provider.waitUntilClickable();
        provider.sendKeys("");
        provider.click();
        logger.info("Click on Provider");
    }

    public void navigateToLocation() {

        location.waitUntilClickable();
        location.click();
        logger.info("Click on Location");
    }

}
