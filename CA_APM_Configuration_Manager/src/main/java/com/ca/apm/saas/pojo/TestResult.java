package com.ca.apm.saas.pojo;

public class TestResult {


     public boolean isResult() {
        return result;
    }

    public void setResult(boolean result) {
        this.result = result;
    }

    public long getResponseTime() {
        return responseTime;
    }

    public void setResponseTime(long responseTime) {
        this.responseTime = responseTime;
    }

    public String getValidationPoint() {
        return validationPoint;
    }

    public void setValidationPoint(String validationPoint) {
        this.validationPoint = validationPoint;
    }

    private String validationPoint;
    private boolean result = false;
    private long responseTime = -1;

    @Override
    public String toString() {
        return "TestResult{" +
                "vpId=" + validationPoint +
                ", result=" + result +
                ", responseTime=" + responseTime +
                '}';
    }
}
