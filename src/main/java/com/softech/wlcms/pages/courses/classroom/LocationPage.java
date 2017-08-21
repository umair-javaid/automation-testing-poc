package com.softech.wlcms.pages.courses.classroom;

import com.softech.wlcms.actions.WaitActions;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.support.ui.Select;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by umair.javaid on 3/14/2016.
 */
public class LocationPage extends WaitActions {
    private static final Logger logger = LoggerFactory.getLogger(LocationPage.class);

    @FindBy(css = "#location_table_wrapper .btn-group [title='Add Location'] i")
    private WebElementFacade addLocation;

    @FindBy(id = "locationname")
    private WebElementFacade locatinName;

    @FindBy(id = "locationaddress")
    private WebElementFacade locationAddress;

    @FindBy(id = "locationcity")
    private WebElementFacade locationCity;

    @FindBy(id = "locationzip")
    private WebElementFacade locationZip;

    @FindBy(id = "country")
    private WebElementFacade locationCountry;

    @FindBy(id = "state")
    private WebElementFacade locationState;

    @FindBy(id = "locationphone")
    private WebElementFacade locationPhone;

    @FindBy(id = "locationdesc")
    private WebElementFacade locationDescreption;

    @FindBy(id = "submitLocation")
    private WebElementFacade submitButton;


    public void addLocation() {
        addLocation.waitUntilClickable();
        addLocation.click();
        logger.info("Click Add Location Button");
    }

    public void setLocationName(String locationName) {
        this.locatinName.waitUntilVisible();
        this.locatinName.clear();
        this.locatinName.sendKeys(locationName);
        logger.info("Set Location Name > " + locationName);
    }

    public void setLocationAddress(String locationAddress) {
        this.locationAddress.clear();
        this.locationAddress.sendKeys(locationAddress);
        logger.info("Set Location Address > " + locationAddress);
    }

    public void setLocationCity(String locationCity) {
        this.locationCity.clear();
        this.locationCity.sendKeys(locationCity);
        logger.info("Set Location City > " + locationCity);
    }

    public void setLocationZip(String locationZip) {
        this.locationZip.clear();
        this.locationZip.sendKeys(locationZip);
        logger.info("Set Location Zip > " + locationZip);
    }

    public void setLocationCountry() {
        locationCountry.sendKeys("");
        Select select = new Select(locationCountry);
        select.selectByIndex(2);
        logger.info("Set Location Country ");
    }

    public void setLocationState() {
        Select select = new Select(locationState);
        select.selectByIndex(2);
        logger.info("Set Location State");
    }

    public void setLocationPhone(String locationPhone) {
        this.locationPhone.clear();
        this.locationPhone.sendKeys(locationPhone);
        logger.info("Set Location Phone > " + locationPhone);
    }

    public void setLocationDescreption(String locationDescreption) {
        this.locationDescreption.clear();
        this.locationDescreption.sendKeys(locationDescreption);
        logger.info("Set Location Descreption > " + locationDescreption);
    }

    public void clickSubmitLocation() {
        logger.info("Click Submit");
        submitButton.click();
        submitButton.waitUntilNotVisible();
    }

    public boolean locationIsAdded()
    {
        return addLocation.isDisplayed();
    }
}
