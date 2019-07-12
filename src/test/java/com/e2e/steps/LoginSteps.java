package com.e2e.steps;

import org.apache.log4j.Logger;
import org.springframework.context.annotation.Scope;

import com.e2e.base.Log4JFactory;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

/**
 * 
 * @author rahulsahu
 *
 */
@Scope("cucumber-glue")
public class LoginSteps extends BaseSteps {

	private Logger logger = Log4JFactory.getLogger(this.getClass().getName());

	@Given("^user open browser and enter application url$")
	public void oepnapplication() throws Throwable {
		logger.info("open url");
		loginFlow.openURL("https://www.netflix.com/in/");

	}

	@When("^user login with email and password$")
	public void loginWithEmail() {

	}

	@When("^verify user is a basic user$")
	public void vefifyUserIsBasic() throws Throwable {
	}

	@Then("^user do subscribe$")
	public void doSubscription(int statusCode) throws Throwable {
		System.out.println("asdf");
	}

	@And("^verify user is premium user")
	public void vefiryUserIsPremium(String version) throws Throwable {
	}
}