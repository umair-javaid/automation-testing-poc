package com.softech.wlcms.pages.courses.classroom;


import com.github.javafaker.Faker;
import com.softech.wlcms.actions.WaitActions;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * Created by umair.javaid on 2/9/2016.
 */

public class ProviderPage extends WaitActions {
    private static final Logger logger = LoggerFactory.getLogger(ProviderPage.class);

   

    Faker faker = new Faker();
    String firstname = faker.name().firstName();
    String lastname = faker.name().firstName();
    String emailid = faker.internet().emailAddress();
    String fullNamedata = firstname + "_" + lastname;
    String phoneNumberdata = faker.numerify("######");

    @FindBy(id = "full_name")
    private WebElement fullName;

    @FindBy(id = "email_address")
    private WebElementFacade email;

    @FindBy(id = "phone_no")
    private WebElementFacade phoneNumber;

    @FindBy(id = "presenter_firstname")
    private WebElementFacade presenter_firstname;

    @FindBy(id = "presenter_lastname")
    private WebElementFacade presenter_lastname;

    @FindBy(id = "presenter_email")
    private WebElementFacade presenter_email;

    @FindBy(id = "presenter_phonenumber")
    private WebElementFacade presenter_phonenumber;

    @FindBy(id = "btnSave")
    private WebElementFacade saveButton;

    public void setFullName(String fullName) {
        waitUntilLoaded(this.fullName);
        this.fullName.sendKeys(fullName);
        logger.info("Enter Full Name " + fullName);
    }

    public void setEmail(String email) {
        this.email.sendKeys(email);
        logger.info("Enter Email id " + email);
    }

    public void setPhonenumber(String phoneNumber) {
        this.phoneNumber.sendKeys(phoneNumber);
        logger.info("Enter Phone Number " + phoneNumber);
    }

    public void setPresenter_firstname(String firstname)
    {
        this.presenter_firstname.sendKeys(firstname);
        logger.info("Set FirstName " + firstname);
    }

    public void setPresenter_lastname(String lastname)
    {
        presenter_lastname.sendKeys(lastname);
        logger.info("Set LastName " + lastname);
    }

    public void setPresenter_email(String email)
    {
        presenter_email.sendKeys(email);
        logger.info("Set Presenter Email " + email);
    }

    public void setPresenter_phonenumber(String phonenumber)
    {
     presenter_phonenumber.sendKeys(phonenumber);
        logger.info("Set Presenter Phone Number " +phonenumber);
    }

    public void addProvider()
    {
        logger.info("Adding Provider Details");
        setFullName(fullNamedata);
        setEmail(emailid);
        setPhonenumber(phoneNumberdata);
//        setPresenter_firstname(firstname);
//        setPresenter_lastname(lastname);
//        setPresenter_email(emailid);
//        setPresenter_phonenumber(phoneNumberdata);
        saveButton.click();
        logger.info("Provider Name > " + fullNamedata);
    }

   
}
