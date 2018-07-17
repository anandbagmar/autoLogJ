package com.eot.autoLogJ.utils;

        import java.util.Map;
        import com.fasterxml.jackson.annotation.*;

public class AfterMethod {
    private Object[] condition;
    private Object[] logLevel;

    @JsonProperty("condition")
    public Object[] getCondition() { return condition; }
    @JsonProperty("condition")
    public void setCondition(Object[] value) { this.condition = value; }

    @JsonProperty("logLevel")
    public Object[] getLogLevel() { return logLevel; }
    @JsonProperty("logLevel")
    public void setLogLevel(Object[] value) { this.logLevel = value; }
}
