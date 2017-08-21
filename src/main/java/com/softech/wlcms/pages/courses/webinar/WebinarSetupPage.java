package com.softech.wlcms.pages.courses.webinar;

import com.github.javafaker.Faker;
import com.softech.wlcms.actions.WaitActions;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by shariq.muhammad on 3/29/2016.
 */
public class WebinarSetupPage extends WaitActions {
    private static final Logger logger = LoggerFactory.getLogger(AddScehdulePage.class);



    @FindBy(id = "WEBINAR_SERVICE_PROVIDER")
    private WebElementFacade webinarServiceProvider;

    @FindBy(id = "MEETINGURL")
    private WebElementFacade meetingURL;

    @FindBy(id = "DIAL_IN_NUMBER")
    private WebElementFacade dialInNumber;

    @FindBy(id = "MEETINGPASSCODE")
    private WebElementFacade accessCode;

    @FindBy(id = "ADDITIONAL_INFORMATION")
    private WebElementFacade additionalInformation;


    @FindBy(id = "saveBtn")
    private WebElementFacade saveWebinarSetup;

    @FindBy(css = "#confirmationModal .btn.blue")
    private WebElementFacade confirmButton;

    public void select360TrainingAsWebinarServiceProvider() {
        waitUntilLoaded(webinarServiceProvider);
        Select select = new Select(webinarServiceProvider);
        select.selectByValue("360training");
        logger.info("Webinar service Provider is selected");
    }

    public void selectOtherAsWebinarServiceProvider() {
        waitUntilLoaded(webinarServiceProvider);
        Select select = new Select(webinarServiceProvider);
        select.selectByValue("Others");
        logger.info("Webinar service Provider is selected");
    }

    public void setMeetingURL(String url) {
        meetingURL.clear();
        meetingURL.sendKeys(url);
        logger.info(url);
        logger.info("Meeting URL has been defined");
    }

    public void setdialInNumber(String phoneNumberdata) {
        dialInNumber.clear();
        dialInNumber.sendKeys(phoneNumberdata);
        logger.info("Dialled number has been defined");
    }

    public void setaccessCode(String accessCode) {
        this.accessCode.clear();
        this.accessCode.sendKeys(accessCode);
        logger.info("Meeting Access code has been defined");
    }


    public void setadditionalInformation(String additionalInformation) {
        this.additionalInformation.clear();
        this.additionalInformation.sendKeys(additionalInformation);
        logger.info("Meeting Access code has been defined");
        logger.info("Additional Information > " + additionalInformation);
    }


    public void saveWebinarSetup() {
        saveWebinarSetup.waitUntilClickable();
        saveWebinarSetup.click();
        logger.info("Webinar Setup page is saved");

    }

    public void confirmationModel() {

        confirmButton.waitUntilClickable();
        confirmButton.click();
        confirmButton.waitUntilNotVisible();
        logger.info("Continue to Save");

    }

    public String getadditionalInformation() {
        return additionalInformation.getText();
    }
}
