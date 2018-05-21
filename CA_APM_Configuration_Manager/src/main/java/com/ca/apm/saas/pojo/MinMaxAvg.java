package com.ca.apm.saas.pojo;

public class MinMaxAvg {
    private String validationPoint;

    public String getValidationPoint() {
        return validationPoint;
    }

    public void setValidationPoint(String validationPoint) {
        this.validationPoint = validationPoint;
    }

    public long getResponseTimeMin() {
        return responseTimeMin;
    }

    public void setResponseTimeMin(long responseTimeMin) {
        this.responseTimeMin = responseTimeMin;
    }

    public long getResponseTimeMax() {
        return responseTimeMax;
    }

    public void setResponseTimeMax(long responseTimeMax) {
        this.responseTimeMax = responseTimeMax;
    }

    public long getResponseTimeAvg() {
        return responseTimeAvg;
    }

    public void setResponseTimeAvg(long responseTimeAvg) {
        this.responseTimeAvg = responseTimeAvg;
    }

    private long responseTimeMin = -1;
    private long responseTimeMax = -1;
    private long responseTimeAvg = -1;
}
