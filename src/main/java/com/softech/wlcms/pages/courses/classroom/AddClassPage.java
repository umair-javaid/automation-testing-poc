package com.softech.wlcms.pages.courses.classroom;


import com.softech.wlcms.actions.DatePickerActions;
import com.softech.wlcms.actions.WaitActions;
import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;


/**
 * Created by umair.javaid on 2/4/2016.
 */

public class AddClassPage extends WaitActions {

    private static final Logger logger = LoggerFactory.getLogger(AddClassPage.class);

    DatePickerActions datePickerActions;

    @FindBy(css = "#contentHolder [data-target='#addClassModal']")
    private WebElementFacade addClass;

    @FindBy(id = "classTitle")
    private WebElementFacade classTitle;

    @FindBy(id = "classSize")
    private WebElementFacade classSize;

    @FindBy(id = "classTimezome")
    private WebElementFacade classTimezome;

    @FindBy(css = "#enroll_date_modal button")
    private WebElementFacade enrollmentCloseDate;

    @FindBy(id = "classLocation")
    private WebElementFacade classLocation;

    @FindBy(id = "submitClass")
    private WebElementFacade submitClass;

    @FindBy(css = ".datepicker.dropdown-menu")
    private List<WebElementFacade> datepicker;

    @FindBy(css = ".day.active")
    private WebElementFacade currentDate;

    @FindBy(css = "#classes_accordion #class_panel_title_")
    private List<WebElementFacade> getclassTitle;

    @FindBy(id = "classInstructor")
    private WebElementFacade classInstructor;

    @FindBy(css = "#classes_accordion .icon-remove")
    private WebElementFacade removeClassIcon;

    @FindBy(css = "#confirmationModal .btn.blue")
    private WebElementFacade removeClassConfermation;

    @FindBy(css = "#classes_accordion .checker")
    private WebElementFacade sessionCheckBox;

    @FindBy(css = "#classes_accordion .btn.btn-default.del-session")
    private WebElementFacade removeSessionIcon;


    public void clickAddClass() {
        addClass.waitUntilVisible();
        addClass.click();
        logger.info("Click Add Class");
    }

    public void setTitle(String title) {
        waitUntilLoaded(classTitle);
        classTitle.waitUntilClickable();
        classTitle.clear();
        classTitle.sendKeys(title);
        logger.info("Set Classroom Title ");
    }

    public void addClass(String title) {
        logger.info("Add Class");
        clickAddClass();
        setTitle(title);
        setNumberOfSeat("2");
        selectClassTimezome();
        datePickerActions.enrollmentCloseDate();
        selectClassLocation();
        selectInstructor();
        submitClass();
        submitClass.waitUntilNotVisible();
        logger.info("Add Class completed");
    }

    private void selectInstructor() {
        logger.info("Select Instructor");
        waitUntilLoaded(classInstructor);
        Select select = new Select(classInstructor);
        select.selectByIndex(1);

    }

    public void setNumberOfSeat(String number) {
        classSize.clear();
        classSize.sendKeys(number);
        logger.info("Set Number of Seat");
    }

    public void selectClassTimezome() {
        logger.info("Select Class Time Zone");
        Select select = new Select(classTimezome);
        select.selectByIndex(1);
    }

//    public void enrollmentCloseDate() {
//        logger.info("Select Enrollment Close Date");
//        enrollmentCloseDate.waitUntilVisible();
//        enrollmentCloseDate.sendKeys("");
//        enrollmentCloseDate.click();
//
//        WebElement dateWidget = getDriver().findElements(By.cssSelector(".datepicker")).get(6);
//        waitUntilLoaded(dateWidget);
////        new WebDriverWait(getDriver(),60)
////                .until((ExpectedConditions.visibilityOf(dateWidget)));
//            if (dateWidget.getAttribute("style").startsWith("display")) {
////            logger.info(dateWidget.getAttribute("style"));
//                WebElement currentDate = dateWidget.findElement(By.cssSelector(".day.active"));
//                currentDate.click();
//            }
//            logger.info("END Select");
//        }


    public void selectClassLocation() {
        logger.info("Select Class location");
        waitUntilLoaded(classLocation);
        Select select = new Select(classLocation);
        select.selectByIndex(1);
        logger.info("End");
    }

    public void submitClass() {
        submitClass.waitUntilClickable();
        submitClass.sendKeys("");
        submitClass.click();
        logger.info("Click Save");
    }

    public String getClassTitle() {
        WebElement classTitle = getclassTitle.get(0);
        return classTitle.getText();
    }

    public String getSecondClassTitle() {
        WebElement classTitle = getclassTitle.get(1);
        return classTitle.getText();
    }

    public void deleteClass() {
        waitUntilLoaded(removeClassIcon);
        removeClassIcon.click();
        logger.info("Click on Remove Class Icon");
    }

    public void confirmRemovalofClass() {
        waitUntilLoaded(removeClassConfermation);
        removeClassConfermation.click();
        logger.info("Click Confirm Removal of Class");
    }

    public boolean classIsRemoved() {
        logger.info("Verify if Class is Removed");
        try {
            removeClassIcon.isDisplayed();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public void deleteSession() {
        waitUntilLoaded(sessionCheckBox);
        sessionCheckBox.click();
        sessionCheckBox.isSelected();
        waitUntilLoaded(removeSessionIcon);
        removeSessionIcon.click();
        logger.info("Delete Session From Class");
    }

    public boolean sessionIsRemoved()
    {
        logger.info("Verify if Session is Removed");
        try {
            removeSessionIcon.isDisplayed();
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
