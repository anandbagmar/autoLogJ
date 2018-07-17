package com.eot.autoLogJ.utils;

import java.util.Map;
import com.fasterxml.jackson.annotation.*;

public class BeforeMethod {
    private Object[] condition;
    private String logLevel;

    @JsonProperty("condition")
    public Object[] getCondition() { return condition; }
    @JsonProperty("condition")
    public void setCondition(Object[] value) { this.condition = value; }

    @JsonProperty("logLevel")
    public String getLogLevel() { return logLevel; }
    @JsonProperty("logLevel")
    public void setLogLevel(String value) { this.logLevel = value; }
}
