package com.RunnerClass;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
	    features="Feature/APIFeatureFile.feature",
	    glue="com.RestAssignments",
	   plugin= {"pretty","html:HTML-Reports"},
	    monochrome=true
	    )
	public class RunnerClass extends AbstractTestNGCucumberTests{
	}
