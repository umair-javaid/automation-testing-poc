package com.softech.wlcms.steps.common;


import com.softech.wlcms.pages.common.WlcmsLoginPage;
import com.softech.wlcms.steps.utils.WlcmsEnvironmentsEnum;
import com.softech.wlcms.steps.utils.WlcmsUserCredentialsFromProperties;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Title;
import net.thucydides.core.steps.ScenarioSteps;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by umair.javaid on 2/22/2016.
 */
public class WlcmsLoginSteps extends ScenarioSteps {
    private static final Logger logger = LoggerFactory.getLogger(WlcmsLoginSteps.class);
    public String currentURL = "";

    private WlcmsUserCredentialsFromProperties wlcmsUserProps = new WlcmsUserCredentialsFromProperties();

    WlcmsLoginPage wlcmsLoginPage;
    WlcmsHomePageSteps homePageSteps;


    @Step
    public String LogIntoWlcms() {
        wlcmsLoginPage.open();
        String currentWlcmsEnvironment = setWlcmsCurrentEnvironment(wlcmsLoginPage.wlcmsGetCurrentUrl());
        wlcmsLoginPage.setUserNamePassword(wlcmsUserProps.getWlcmsUserProperty(currentWlcmsEnvironment ,"UserName"),
                wlcmsUserProps.getWlcmsUserProperty(currentWlcmsEnvironment,"Password"));
        wlcmsLoginPage.clickLogin();
        return currentWlcmsEnvironment;
    }

    private String setWlcmsCurrentEnvironment(String currentUrl) {
        String wlcmsCurrentEnvironment = null;
        if (currentUrl.startsWith(WlcmsEnvironmentsEnum.WLCMS_URL_ENV_DEV.getWlcmsUrlEnvironmentValue())) {
            wlcmsCurrentEnvironment = WlcmsEnvironmentsEnum.WLCMS_URL_ENV_DEV.getWlcmsEnvironmentName();
        } else if (currentUrl.startsWith(WlcmsEnvironmentsEnum.WLCMS_URL_ENV_QA.getWlcmsUrlEnvironmentValue())) {
            wlcmsCurrentEnvironment = WlcmsEnvironmentsEnum.WLCMS_URL_ENV_QA.getWlcmsEnvironmentName();
        } else if (currentUrl.startsWith(WlcmsEnvironmentsEnum.WLCMS_URL_ENV_UAT.getWlcmsUrlEnvironmentValue())) {
            wlcmsCurrentEnvironment = WlcmsEnvironmentsEnum.WLCMS_URL_ENV_UAT.getWlcmsEnvironmentName();
        } else if (currentUrl.startsWith(WlcmsEnvironmentsEnum.WLCMS_URL_ENV_PROD.getWlcmsUrlEnvironmentValue())) {
            wlcmsCurrentEnvironment = WlcmsEnvironmentsEnum.WLCMS_URL_ENV_PROD.getWlcmsEnvironmentName();
        } else {
            wlcmsCurrentEnvironment = "invalid-env";
        }

        logger.info("Current LMS Environment: \"" + wlcmsCurrentEnvironment + "\"");
        return wlcmsCurrentEnvironment;
    }

}
