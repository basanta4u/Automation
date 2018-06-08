package com.ca.apm.saas.pojo;

import java.util.List;

public class TestResultList {


    public List<TestResult> getTestResults() {
        return testResults;
    }

    public void setTestResults(List<TestResult> testResults) {
        this.testResults = testResults;
    }

    private List<TestResult> testResults;

    @Override
    public String toString() {
        return "TestResultList{" +
                "testResults=" + testResults +
                '}';
    }
}
