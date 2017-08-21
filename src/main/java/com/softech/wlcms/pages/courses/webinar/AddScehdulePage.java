package com.softech.wlcms.pages.courses.webinar;

import com.softech.wlcms.actions.DatePickerActions;
import com.softech.wlcms.actions.TimeActions;
import com.softech.wlcms.actions.WaitActions;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * Created by shariq.muhammad on 3/10/2016.
 */
public class AddScehdulePage extends WaitActions {
    private static final Logger logger = LoggerFactory.getLogger(AddScehdulePage.class);

    TimeActions timeActions = new TimeActions();
    DatePickerActions datePickerActions = new DatePickerActions();


    @FindBy(id = "timezome")
    private WebElementFacade timezome;

    @FindBy(css = "#enrollDate .btn")
    private WebElementFacade enrollmentCloseDate;

    @FindBy(css = "#startDate .btn")
    private WebElementFacade courseStartDate;

    @FindBy(id = "start_time")
    private WebElementFacade courseStartTime;

    @FindBy(id = "end_time")
    private WebElementFacade courseEndTime;

    @FindBy(css = ".datepicker")
    private List<WebElementFacade> datepicker;

    @FindBy(css = ".day.active")
    private WebElementFacade currentDate;

    @FindBy(css = "#btnSave")
    private WebElementFacade saveSchedule;


    public void selectTimezone() {
        logger.info("Select Class Time Zone");
        //waitForRenderedElements(By.id("timezone"));
        Select select = new Select(timezome);
        select.selectByValue("8");
    }

    public void setEnrollmentCloseDate() {
        logger.info("Select Enrollment Close Date");
        enrollmentCloseDate.waitUntilVisible();
        enrollmentCloseDate.sendKeys("");
        enrollmentCloseDate.click();
        datePickerActions .setEndDate();

    }

    public void setCourseStartDate() {
        logger.info("Set Session Start Date");
        courseStartDate.waitUntilVisible();
        courseStartDate.sendKeys("");
        courseStartDate.click();
        datePickerActions .setStartDate();

//        if (dateNew1.getAttribute("style").startsWith("display")) {
//            waitUntilLoaded(dateNew1);
//            logger.info(dateNew1.getAttribute("style"));
//            WebElement currentDate = dateNew1.findElement(By.cssSelector(".day.active"));
//            currentDate.click();
//        }
    }


    public void setCourseStartTime() {

        logger.info("Set Session Start Time");
        Select select = new Select(courseStartTime);
        select.selectByValue(timeActions.getStartTime("webinar"));
    }


    public void setCourseEndTime() {
        logger.info("Set Course End Time");
        Select select = new Select(courseEndTime);
        select.selectByValue(timeActions.getEndTime("webinar"));

    }

    public void saveSchedule() {
        logger.info("Saving Scdule of Webinar");
        saveSchedule.waitUntilClickable();
        saveSchedule.click();

    }
}


