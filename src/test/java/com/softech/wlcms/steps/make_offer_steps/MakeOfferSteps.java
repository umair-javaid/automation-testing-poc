package com.softech.wlcms.steps.make_offer_steps;

import com.softech.wlcms.pages.publish.PublishCoursePage;
import com.softech.wlcms.pages.publish.PublishingPanelPage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static junit.framework.TestCase.assertTrue;

/**
 * Created by umair.javaid on 3/3/2016.
 */

public class MakeOfferSteps extends ScenarioSteps {
    private static final Logger logger = LoggerFactory.getLogger(MakeOfferSteps.class);

    PublishingPanelPage publishingPanelPage;
    PublishCoursePage publishCoursePage;

    @Step
    public void navigateToMakeOffer()
    {
        publishingPanelPage.clickOffer360MarketPlace();
        publishCoursePage.clickMakeOffer();

    }

    @Step
    public void performMakeOffer()
    {
        publishCoursePage.clickYes();
        assertTrue(publishCoursePage.isProgressBoxVisible());
    }
}
