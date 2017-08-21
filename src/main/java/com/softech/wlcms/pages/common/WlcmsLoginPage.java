package com.softech.wlcms.pages.common;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.support.FindBys;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by umair.javaid on 2/24/2016.
 */

@DefaultUrl("/lcms")
public class WlcmsLoginPage  extends PageObject {
    private static final Logger logger = LoggerFactory.getLogger(WlcmsLoginPage.class);

    @FindBy(id = "username")
    private WebElementFacade username;

    @FindBy(id = "password")
    private WebElementFacade password;

    @FindBy(css= "#frm_login [type='submit']")
    private WebElementFacade loginButton;

    @FindBy(css= ".container-fluid ul.top-right-nav [data-toggle='dropdown']")
    private WebElementFacade profileManu;
//
//    private static final By DISPLAY_SELECTOR = By.id("frm_login");

    @FindBy(css= ".container-fluid ul.top-right-nav a[href='j_spring_security_logout']")

    private WebElementFacade logoutButton;

    public void clickUserName(){
        username.clear();
        username.click();

    }

    public void clickPassword(){
        password.clear();
        password.click();
    }

    public void setUserNamePassword(String username,String password){
        this.username.clear();
        this.username.click();
        this.username.sendKeys(username);
        this.password.sendKeys(password);
    }

    public void clickLogin(){
        logger.info("Click at Login");
        loginButton.click();
    }

    public void clicklogOut(){
        profileManu.click();
        logoutButton.click();
    }

    public String wlcmsGetCurrentUrl()
    {

        return getDriver().getCurrentUrl();
    }

}
