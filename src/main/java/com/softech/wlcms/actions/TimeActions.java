package com.softech.wlcms.actions;

import org.joda.time.LocalTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by umair.javaid on 4/21/2016.
 */
public class TimeActions extends AbstractPageAction {
    private static final Logger logger = LoggerFactory.getLogger(TimeActions.class);

    public String getStartTime(String type) {
        LocalTime time = LocalTime.now().plusHours(1);
        DateTimeFormatter dateFormat = DateTimeFormat.forPattern("h:00 a");
        String timeToString = time.toString(dateFormat);
        if (type.equalsIgnoreCase("classroom")) {
            String timeFormat = timeToString.replace("AM", "am").replace("PM", "pm");
            logger.info("Session Start Time " + String.valueOf(timeFormat));
            return timeFormat;
        } else {
            logger.info("Session Start Time " + String.valueOf(timeToString));
            return timeToString;
        }
    }

    public String getEndTime(String type) {
        LocalTime time = LocalTime.now().plusHours(2);
        DateTimeFormatter dateFormat = DateTimeFormat.forPattern("h:00 a");
        String timeToString = time.toString(dateFormat);
        if (type.equalsIgnoreCase("classroom")) {
            String timeFormat = timeToString.replace("AM", "am").replace("PM", "pm");
            logger.info("Session End Time" + String.valueOf(timeFormat));
            return timeFormat;
        } else {
            logger.info("Session End Time" + String.valueOf(timeToString));
            return timeToString;
        }
    }

}
