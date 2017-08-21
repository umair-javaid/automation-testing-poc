package com.softech.wlcms.steps.author_steps;

import com.github.javafaker.Faker;
import com.softech.wlcms.pages.author.SignupPage;
import com.softech.wlcms.pages.author.UserProfilePage;
import com.softech.wlcms.pages.common.WlcmsHomePage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Title;
import net.thucydides.core.steps.ScenarioSteps;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.validation.constraints.AssertTrue;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by umair.javaid on 2/24/2016.
 */
public class AuthorVerificationSteps extends ScenarioSteps {
    private static final Logger logger = LoggerFactory.getLogger(AuthorVerificationSteps.class);

    SignupPage signupPage;
    WlcmsHomePage wlcmsHomePage;
    UserProfilePage userProfilePage;


    @Step
    public void navigateToWlcmsAuthorSignUpPage() {
        logger.info("Navigating to Wlcms Author Sign up Page");
        signupPage.open();
        assertTrue(signupPage.verifySignupPage());
    }


    @Step
    @Title("Filling Author Information")
    public void fillAuthorInformation() {
        Faker faker = new Faker();
        String firstname = faker.name().firstName();
        String lastname = faker.name().firstName();
        String email = faker.internet().emailAddress();
        String username = firstname + "_" + lastname;

        logger.info("Filling Author Form");
        signupPage.fillFirstname(firstname);
        signupPage.fillLastname(lastname);
        signupPage.fillEmail(email);
        signupPage.fillReEmail(email);
        signupPage.fillPasswrod(SignupPage.UserEnum.USER_PASSWORD.getElement());
        signupPage.fillRePasswrod(SignupPage.UserEnum.USER_PASSWORD.getElement());
        signupPage.clickAcceptAgreement();

    }

    @Step
    public void submittingAuthorInformation() {
        logger.info("Submitting Author new Author Information in Wlcms");
        signupPage.clickSubmit();
    }

    @Step
    public void updateUserFirstName() {
        Faker faker = new Faker();
        String updatedFirstname = faker.name().firstName();
        signupPage.fillFirstname(updatedFirstname);
        userProfilePage.clickUserProfileSave();
        assertEquals(updatedFirstname,userProfilePage.getFirstName());

    }
}
