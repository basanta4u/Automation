package com.my.home.test.Selenium.test;

import org.testng.annotations.Test;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(features={"src/main/resources"}
//,glue={"stepdefinations","utility"}
,plugin = {"pretty", "html:target/cucumber"}
, tags ={"@Selenium"}
)

@Test
public class TestNgIntegration extends AbstractTestNGCucumberTests{

}
