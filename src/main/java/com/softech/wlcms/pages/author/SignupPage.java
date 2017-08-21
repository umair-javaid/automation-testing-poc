package com.softech.wlcms.pages.author;


import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@DefaultUrl("/lcms/signUpAuthor")
public class SignupPage extends PageObject {
    private static final Logger logger = LoggerFactory.getLogger(SignupPage.class);

    public enum UserEnum {
        FIRST_NAME("f_name"),
        LAST_NAME("Last_name"),
        EMAIL("firstlast@wlcms.com"),
        USER_PASSWORD("wlcms123456");
        private String statusCode;

        private UserEnum(String statusCode) {
            this.statusCode = statusCode;
        }

        public String getElement() {
            return statusCode;
        }
    }

    @FindBy(id = "firstName")
    private WebElementFacade firstname;

    @FindBy(id = "lastName")
    private WebElementFacade lastname;

    @FindBy(id = "email")
    private WebElementFacade email;

    @FindBy(id = "reenterEmail")
    private WebElementFacade reenterEmail;

    @FindBy(id = "passwrod")
    private WebElementFacade passwrod;

    @FindBy(id = "reenterPasswrod")
    private WebElementFacade reenterPasswrod;

    @FindBy(id = "eulaFT")
    private WebElementFacade acceptAgreement;

    @FindBy(css = "#frm_signupAuthor button[type='submit']")
    private WebElementFacade submitButton;

    @FindBy(id = "reset")
    private WebElementFacade resetButton;

    @FindBy(id = "bg-loader")
    private WebElementFacade busyIcon;

    public boolean verifySignupPage() {
        return firstname.isDisplayed();

    }


    public void fillFirstname(String fillFirstname) {
        this.firstname.clear();
        this.firstname.sendKeys(fillFirstname);
        logger.info("Set First Name");
    }

    public void fillLastname(String fillLastname) {
        lastname.clear();
        lastname.sendKeys(fillLastname);
        logger.info("Set Last Name");
    }

    public void fillEmail(String fillemail) {
        email.clear();
        email.sendKeys(fillemail);
        logger.info("Set Email");
    }

    public void fillReEmail(String fillRerEmail) {
        reenterEmail.clear();
        reenterEmail.sendKeys(fillRerEmail);
        logger.info("Set RE-Email");

    }

    public void fillPasswrod(String fillpassword) {
        passwrod.clear();
        passwrod.sendKeys(fillpassword);
        logger.info("Set Password");
    }

    public void fillRePasswrod(String fillRepassword) {
        reenterPasswrod.clear();
        reenterPasswrod.sendKeys(fillRepassword);
        logger.info("Set Re-Password");
    }

    public void clickAcceptAgreement() {
        logger.info("Click Accept Agreement");
        acceptAgreement.click();
    }

    public void clickSubmit() {
        logger.info("Click Submit");
        submitButton.click();
        submitButton.waitUntilNotVisible();
    }


    public void clickReSetButton() {
        logger.info("Click Re-Set");
        resetButton.click();
    }


}
