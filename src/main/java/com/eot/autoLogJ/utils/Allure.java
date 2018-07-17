package com.eot.autoLogJ.utils;

import java.util.Map;
import com.fasterxml.jackson.annotation.*;

public class Allure {
    private boolean createStepsInAllure;
    private Object[] condition;

    @JsonProperty("createStepsInAllure")
    public boolean getCreateStepsInAllure() { return createStepsInAllure; }
    @JsonProperty("createStepsInAllure")
    public void setCreateStepsInAllure(boolean value) { this.createStepsInAllure = value; }

    @JsonProperty("condition")
    public Object[] getCondition() { return condition; }
    @JsonProperty("condition")
    public void setCondition(Object[] value) { this.condition = value; }
}