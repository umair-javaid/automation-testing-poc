package com.softech.wlcms.pages.publish;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import java.util.List;

//import com.ls360.wlcms.course.CoursePage;

public class PublishCoursePage extends PageObject {
    private static final Logger logger = LoggerFactory.getLogger(PublishCoursePage.class);

    @FindBy(id = "frm_publish")
    private WebElementFacade publishForm;

    @FindBy(css = "#frm_publish .blue")
    private WebElementFacade onlinePublishButton;

    @FindBy(css = "#frm_webinar_publish .btn.blue")
    private WebElementFacade publishButton;


    @FindBy(css = "#frm_publish button[type='button']")
    private WebElementFacade cancelButton;

    @FindBy(id = "publishLMS")
    private WebElementFacade publishLMSOption;

    @FindBy(id = "publishSF")
    private WebElement publishSFOption;

    @FindBy(id = "makeOfferbtn")
    private WebElementFacade makeOffer;

    @FindBy(id = "divPending")
    private WebElementFacade progressBox;

    @FindBy(id = "confirmationModal")
    private WebElementFacade makeofferForm;

    @FindBy(css = "#confirmationModal button[type='button']")
    private List<WebElementFacade> yesButton;

    @FindBy(id = "updateCouseContent")
    private WebElementFacade updateCouseContent;

    @FindBy(id = "updateLMS")
    private WebElementFacade updateLMSOption;

    @FindBy(id = "updateSF")
    private WebElementFacade updateSFOption;

    public void clickOnlinePublish() {
        onlinePublishButton.waitUntilClickable();
        onlinePublishButton.click();
        logger.info("Published the Course");
    }

    public void clickCancel() {
        cancelButton.click();
    }

    public void waitPublishToComplete() {
//        WebElementFacade updateLMSOption = getDriver().find(By.id("updateLMS")));
        updateLMSOption.waitUntilVisible();
    }

    public void clickUpdateLmsOption() {
        updateLMSOption.waitUntilClickable();
        if (!updateLMSOption.isSelected()) {
            updateLMSOption.click();
            updateLMSOption.isSelected();
        } else {
            logger.info("Select Update LMS Option");
        }
    }

    public void selectSFPublishCheckBox() {
        publishSFOption.click();
        publishSFOption.isSelected();
        logger.info("Select Publish to SF");
    }

    public void selectSFRePublishCheckBox() {
        updateSFOption.click();
        updateSFOption.isSelected();
        logger.info("Select Re-Publish to SF");
    }

    public boolean isUpdate() {
        return updateCouseContent.isDisplayed();
    }


    public void clickMakeOffer() {
        makeOffer.waitUntilClickable();
        makeOffer.click();
        logger.info("Make Offer on 360 Market Place");
    }

    public void clickYes() {
        logger.info("Click Yes");
        makeofferForm.waitUntilVisible();
        yesButton.get(1).click();
    }

    public void clickPublish() {
        publishButton.waitUntilClickable();
        publishButton.click();
        logger.info("Published the Course");
    }

    public boolean isProgressBoxVisible() {
        return progressBox.isDisplayed();
    }


}
