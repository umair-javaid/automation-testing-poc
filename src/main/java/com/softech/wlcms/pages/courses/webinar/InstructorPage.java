package com.softech.wlcms.pages.courses.webinar;

import com.github.javafaker.Faker;
import com.softech.wlcms.actions.AbstractPageAction;
import com.softech.wlcms.actions.WaitActions;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.List;
import net.serenitybdd.junit.runners.SerenityRunner;

/**
 * Created by shariq.muhammad on 3/28/2016.
 */
public class InstructorPage extends WaitActions {
    private static final Logger logger = LoggerFactory.getLogger(AddScehdulePage.class);


    Faker faker = new Faker();
    String firstname = faker.name().firstName();
    String lastname = faker.name().firstName();
    String emailid = faker.internet().emailAddress();
    String fullNamedata = firstname + "_" + lastname;
    String phoneNumberdata = faker.numerify("######");


    @FindBy(id = "presenter_firstname")
    private WebElementFacade firstName;

    @FindBy(id = "presenter_lastname")
    private WebElementFacade lastName;

    @FindBy(id = "presenter_email")
    private WebElementFacade email;

    @FindBy(id = "presenter_phonenumber")
    private WebElementFacade phoneNumber;

    @FindBy(id = "btnSave")
    private WebElementFacade saveInstructor;


    public void addInstructorFirstName() {
        logger.info("add Instructor First Name");
        this.firstName.waitUntilClickable();
        this.firstName.clear();
        this.firstName.sendKeys(firstname);
    }


    public void addInstructorLastName() {
        logger.info("add Instructor Last Name");
        this.lastName.waitUntilClickable();
        this.lastName.clear();
        this.lastName.sendKeys(lastname);
    }


    public void addInstructorEmail() {
        logger.info("add Instructor Email Address");
        this.email.waitUntilClickable();
        this.email.clear();
        this.email.sendKeys(emailid);
    }


    public void addInstructorPhoneNumber() {
        logger.info("add Instructor Phone Number");
        this.phoneNumber.waitUntilClickable();
        this.phoneNumber.clear();
        this.phoneNumber.sendKeys(phoneNumberdata);
        saveInstructor.click();
    }


    public void saveInstructorInformation() {
        logger.info("Save Instructor Information");
        saveInstructor.waitUntilClickable();
        saveInstructor.click();

    }
}