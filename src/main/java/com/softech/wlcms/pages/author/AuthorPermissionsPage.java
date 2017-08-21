package com.softech.wlcms.pages.author;

import com.softech.wlcms.actions.WaitActions;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * Created by umair.javaid on 5/4/2016.
 */
public class AuthorPermissionsPage extends WaitActions {
    private static final Logger logger = LoggerFactory.getLogger(AuthorPermissionsPage.class);

    @FindBy(id = "seachText")
    private WebElementFacade seachText;

    @FindBy(id = "searchButton")
    private WebElementFacade searchButton;

    @FindBy(css = ".odd td [data-target='#furtherDetailsModal']")
    private WebElementFacade fullName;

    @FindBy(css = ".green-text.icon-ok")
    private List<WebElementFacade> permissionsList;

    public String searchAuthorViaFirstName(String userName) {
        waitUntilLoaded(seachText);
        seachText.clear();
        seachText.sendKeys(userName);
        searchButton.click();
        logger.info("Search Via First Name");
        return userName;

    }

    public boolean authorFullNameisDisplayed() {

        waitUntilLoaded(fullName);
        return fullName.isDisplayed();
    }

    public boolean ratingReviewIsEnabled() {
        WebElementFacade ratingReview = permissionsList.get(2);
        logger.info("Rating Review is Enabled");
        waitUntilLoaded(ratingReview);
        return ratingReview.isDisplayed();
    }
}
