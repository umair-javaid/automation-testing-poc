package com.softech.wlcms.actions;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by umair.javaid on 5/24/2016.
 */
public class CommonButtonsActions extends WaitActions {
    private static final Logger logger = LoggerFactory.getLogger(CommonButtonsActions.class);

    @FindBy(id = "btnSaveUp")
    private WebElementFacade saveChanges;

    public void saveChanges() {
        saveChanges.click();
        logger.info("Click Save Changes");
    }
}
