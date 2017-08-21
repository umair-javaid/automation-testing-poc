package com.softech.wlcms.steps.content_deletion_steps;

import com.softech.wlcms.pages.courses.classroom.AddClassPage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.steps.ScenarioSteps;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static junit.framework.Assert.assertFalse;
import static junit.framework.TestCase.assertTrue;

/**
 * Created by umair.javaid on 5/3/2016.
 */
public class ClassroomContentDeletionSteps extends ScenarioSteps {
    private static final Logger logger = LoggerFactory.getLogger(ClassroomContentDeletionSteps.class);

    AddClassPage addClassPage;

    @Step
    public void deleteClassFromClassroomCourse() {
        addClassPage.deleteClass();
        addClassPage.confirmRemovalofClass();
        assertFalse(addClassPage.classIsRemoved());
    }

    @Step
    public void deleteManualSessionFromClass() {
        addClassPage.deleteSession();
        addClassPage.confirmRemovalofClass();
        assertFalse(addClassPage.sessionIsRemoved());
    }
}
