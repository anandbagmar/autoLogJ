package com.eot.autoLogJ.utils;

import java.util.Map;
import com.fasterxml.jackson.annotation.*;

public class AutoLogJ {
    private boolean enabled;
    private Allure allure;
    private BeforeMethod beforeMethod;
    private AfterMethod afterMethod;

    @JsonProperty("enabled")
    public boolean getEnabled() { return enabled; }
    @JsonProperty("enabled")
    public void setEnabled(boolean value) { this.enabled = value; }

    @JsonProperty("allure")
    public Allure getAllure() { return allure; }
    @JsonProperty("allure")
    public void setAllure(Allure value) { this.allure = value; }

    @JsonProperty("beforeMethod")
    public BeforeMethod getBeforeMethod() { return beforeMethod; }
    @JsonProperty("beforeMethod")
    public void setBeforeMethod(BeforeMethod value) { this.beforeMethod = value; }

    @JsonProperty("afterMethod")
    public AfterMethod getAfterMethod() { return afterMethod; }
    @JsonProperty("afterMethod")
    public void setAfterMethod(AfterMethod value) { this.afterMethod = value; }
}