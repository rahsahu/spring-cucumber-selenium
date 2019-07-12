package com.e2e.spring;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

/**
 * 
 * @author rahulsahu
 *
 */
@RunWith(Cucumber.class)
@CucumberOptions(plugin = { "pretty", "json:target/cucumber-reports/Cucumber.json",
		"junit:target/cucumber-reports/Cucumber.xml", "html:target/cucumber-reports",
		"com.vimalselvam.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports/report.html" }, features = "src/test/resources/features", glue = {
				"com.e2e.steps", "com.e2e.base" })
public class CucumberCukeTest {

}