package com.softech.wlcms.pages.courses.classroom;

import com.softech.wlcms.actions.DatePickerActions;
import com.softech.wlcms.actions.TimeActions;
import com.softech.wlcms.actions.WaitActions;
import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import org.joda.time.LocalTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import org.openqa.selenium.support.ui.Select;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;
import java.util.List;


/**
 * Created by umair.javaid on 2/10/2016.
 */

public class AddSessionPage extends WaitActions {
    private static final Logger logger = LoggerFactory.getLogger(AddSessionPage.class);

    TimeActions timeActions = new TimeActions();

    DatePickerActions datePickerActions;
    @FindBy(css = "#contentHolder .page-content a[data-target='#addSessionModal']")
    private WebElementFacade addSesson;

    @FindBy(id = "headingDiv")
    private WebElementFacade pageHead;

    @FindBy(id = "submitSession")
    private WebElementFacade saveButton;

    @FindBy(id = "add_sess_start_time")
    private WebElementFacade sessionStartTime;

    @FindBy(id = "add_sess_end_time")
    private WebElementFacade sessionEndTime;

    @FindBy(css = "#classes_accordion [data-target='#addSessionModal']")
    private WebElementFacade addSessionList;

    @FindBy(css = "#add_sess_rPattern[value='daily']")
    private WebElementFacade dailyRadio;

    @FindBy(css = "#add_sess_rPattern[value='weekly']")
    private WebElementFacade weeklyRadio;

    @FindBy(id = "add_sess_number_days")
    private WebElementFacade sessionNumberDays;

    @FindBy(id = "chkdMonday")
    private WebElementFacade checkBoxMonday;

    @FindBy(id = "chkdTuesday")
    private WebElementFacade checkBoxTuesday;

    @FindBy(css = "#start_by_date button")
    private WebElementFacade sessionStartDate;

    public void navigateToAddSession() {
        addSessionList.waitUntilPresent();
        addSessionList.waitUntilClickable();
        addSessionList.click();
        logger.info("Click On Add Session");
    }


    public void setSessionStartTime() {
        logger.info("Set Session Start Time");
        Select select = new Select(sessionStartTime);
        select.selectByVisibleText(timeActions.getStartTime("classroom"));
    }

    public void setSessionEndTime() {
        logger.info("Set Session End Time");
        Select select = new Select(sessionEndTime);
        select.selectByVisibleText(timeActions.getEndTime("classroom"));
    }

    public void addManualClassSession() {
        saveButton.waitUntilVisible();
        saveButton.sendKeys("");
        saveButton.click();
        saveButton.waitUntilNotVisible();
        logger.info("Click Save Button");
    }

    public void setDailySession() {
        waitUntilLoaded(dailyRadio);
        dailyRadio.click();
        logger.info("Set Daily Session");
        dailyRadio.isSelected();
    }

    public void setWeeklySession() {
        waitUntilLoaded(weeklyRadio);
        weeklyRadio.click();
        logger.info("Set Weekly Session");
        weeklyRadio.isSelected();
    }

    public void setDailySessionNumber() {
        waitUntilLoaded(sessionNumberDays);
        sessionNumberDays.clear();
        sessionNumberDays.sendKeys("2");
    }

    public void setWeekDays() {
        waitUntilLoaded(checkBoxMonday);
        checkBoxMonday.click();
        checkBoxMonday.isSelected();
//        checkBoxTuesday.click();
//        checkBoxTuesday.isSelected();
        logger.info("Select Check Box");
    }

    public void setSessionStartDate() {
        logger.info("Set Session Start Date");
        sessionStartDate.waitUntilVisible();
        sessionStartDate.sendKeys("");
        sessionStartDate.click();
        datePickerActions.setSessionStartDate();

    }
}
