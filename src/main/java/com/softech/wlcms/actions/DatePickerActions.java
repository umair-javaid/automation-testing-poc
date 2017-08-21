package com.softech.wlcms.actions;

import net.serenitybdd.core.pages.WebElementFacade;
import org.joda.time.DateTime;
import org.joda.time.LocalDate;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * Created by umair.javaid on 3/14/2016.
 */
public class DatePickerActions extends WaitActions {
    private static final Logger logger = LoggerFactory.getLogger(DatePickerActions.class);

    WaitActions waitActions;

    @FindBy(css = "#enroll_date_modal button")
    private WebElementFacade enrollmentCloseDate;

    @FindBy(css = "#start_by_date button")
    private WebElementFacade sessionStartDate;

    @FindBy(css = ".datepicker")
    private List<WebElement> datepickerList;

    @FindBy(css = "#end_by_date button")
    private WebElementFacade sessionEndDate;


    public void enrollmentCloseDate() {
        logger.info("Select Enrollment Close Date");
        enrollmentCloseDate.waitUntilVisible();
        enrollmentCloseDate.sendKeys("");
        enrollmentCloseDate.click();
        WebElement dateWidget = getDriver().findElements(By.cssSelector(".datepicker")).get(6);
        waitActions.waitUntilLoaded(dateWidget);
        if (dateWidget.getAttribute("style").startsWith("display")) {
            WebElement currentDate = dateWidget.findElement(By.cssSelector(".day.active"));
            currentDate.click();
        }
        logger.info("END Select");
    }

    public void setSessionStartDate() {
        // We set Current Date as Start Date Here
        logger.info("Set Session Start Date");
        sessionStartDate.waitUntilVisible();
        sessionStartDate.sendKeys("");
        sessionStartDate.click();
        WebElement dateWidget = getDriver().findElements(By.cssSelector(".datepicker")).get(4);
        waitActions.waitUntilLoaded(dateWidget);
        WebElement currentDate = dateWidget.findElement(By.cssSelector(".day.active"));
        ((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);", currentDate);
        currentDate.click();
    }

    public void setSessionEndDate() {
        logger.info("Set Session End Date");
        sessionEndDate.waitUntilClickable();
        sessionEndDate.sendKeys("");
        sessionEndDate.click();
        WebElement dateNew = getDriver().findElements(By.cssSelector(".datepicker")).get(5);
//        WebElement dateWidget = datepickerList.get(5);
//        waitActions.waitUntilLoaded(dateWidget);
//        WebElement currentDate = dateWidget.findElement(By.cssSelector(".day.active"));
//        ((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);", currentDate);
//        currentDate.click();
        waitUntilLoaded(dateNew);
        List<WebElement> rows = dateNew.findElements(By.cssSelector(".datepicker-days .next"));
        for (WebElement row : rows) {
            if (row.getText().equalsIgnoreCase("›")) {
                ((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);", row);
                row.click();
                break;
            }
        }
        List<WebElement> columns = dateNew.findElements(By.tagName("td"));
        for (WebElement cell : columns) {
            //Select 13th Date
            if (cell.getText().equals(getModifiedDate())) {
                ((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);", cell);
                cell.click();
                break;
            }
        }
    }

    public void setEndDate() {
        WebElement dateNew = getDriver().findElements(By.cssSelector(".datepicker")).get(0);
        waitUntilLoaded(dateNew);
        List<WebElement> rows = dateNew.findElements(By.cssSelector(".datepicker-days .next"));
        for (WebElement row : rows) {
            if (row.getText().equalsIgnoreCase("›")) {
                row.click();
                break;
            }
        }
        List<WebElement> columns = dateNew.findElements(By.tagName("td"));
        for (WebElement cell : columns) {
            //Select 13th Date
            if (cell.getText().equals(getModifiedDate())) {
                cell.click();
                break;
            }
        }

    }

    public void setStartDate() {
        WebElement dateNew1 = getDriver().findElements(By.cssSelector(".datepicker")).get(1);
        waitUntilLoaded(dateNew1);
        List<WebElement> rows = dateNew1.findElements(By.cssSelector(".datepicker-days .next"));

        for (WebElement row : rows) {
            if (row.getText().equalsIgnoreCase("›")) {
                row.click();
                break;
            }
        }
        List<WebElement> columns = dateNew1.findElements(By.tagName("td"));
        for (WebElement cell : columns) {
            //Select 13th Date
            if (cell.getText().equals(getModifiedDate())) {
                cell.click();
                break;
            }
        }
    }

    public String getModifiedDate() {

        // This Method Takes the System Current Date and Add 4 days and return
        LocalDate date = new LocalDate().now().plusDays(10);
        DateTimeFormatter formatDate = DateTimeFormat.forPattern("dd");
        String dateToString = date.toString(formatDate);
        return dateToString;
    }
}