package com.softech.wlcms.steps.utils;

/**
 * Created by umair.javaid on 4/12/2016.
 */
public enum WlcmsEnvironmentsEnum {
    WLCMS_URL_ENV_DEV("https://dev-wlcms.360training.com", "dev"),
    WLCMS_URL_ENV_QA("https://qa-wlcms.360training.com", "qa"),
    WLCMS_URL_ENV_UAT("https://uet-wlcms.360training.com", "uat"),
    WLCMS_URL_ENV_PROD("https://wlcms.360training.com", "prod");

    private String wlcmsUrlEnvironmentValue;
    private String wlcmsEnvironmentName;

    WlcmsEnvironmentsEnum(String wlcmsUrlEnvironmentValue, String wlcmsEnvironmentName) {
        this.wlcmsUrlEnvironmentValue = wlcmsUrlEnvironmentValue;
        this.wlcmsEnvironmentName = wlcmsEnvironmentName;
    }

    public String getWlcmsUrlEnvironmentValue() {
        return wlcmsUrlEnvironmentValue;
    }

    public String getWlcmsEnvironmentName() {
        return wlcmsEnvironmentName;
    }
}

