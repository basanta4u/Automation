package com.my.home.test.firstBDD;

import org.testng.annotations.Test;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(features={"src/test/resources"}
//,glue={"stepdefinations","utility"}
,plugin = {"pretty", "html:target/cucumber"}
, tags ={"@Selenium"}
)

@Test
public class TestNgIntegration extends AbstractTestNGCucumberTests{

}
