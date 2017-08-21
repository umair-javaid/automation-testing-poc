package com.softech.wlcms.steps.author_steps;

import com.softech.wlcms.pages.author.AuthorPermissionsPage;
import com.softech.wlcms.steps.utils.WlcmsTestDataFromProperties;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;

/**
 * Created by umair.javaid on 5/4/2016.
 */
public class AuthorPermissionSteps extends ScenarioSteps {
    private static final Logger logger = LoggerFactory.getLogger(AuthorPermissionSteps.class);

    private WlcmsTestDataFromProperties testdata = new WlcmsTestDataFromProperties();
    AuthorPermissionsPage authorPermissionsPage;

    @Step
    public void searchAuthorViaFirstName(String currentUrl) {
        String name =
                authorPermissionsPage.searchAuthorViaFirstName(testdata.getWlcmsTestDataFromProperty(currentUrl, "firstName"));
        assertTrue(authorPermissionsPage.authorFullNameisDisplayed());

    }


    @Step
    public void verifyRatingReviewPermissions() {
        assertTrue(authorPermissionsPage.ratingReviewIsEnabled());
    }
}
