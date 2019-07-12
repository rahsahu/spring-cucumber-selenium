package com.e2e.flows;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;

import com.e2e.pages.HomePage;

/**
 * 
 * @author rahulsahu
 *
 */
public class BaseFlow {

	@Autowired
	HomePage homePage;

	public void openURL(String url) {
		homePage.openURL(url);
	}

	public String getURL() {
		return homePage.getURL();
	}

	public String getWindowHandle() {
		return homePage.getWindowHandle();
	}

	public Set<String> getWindowHandles() {
		return homePage.getWindowHandles();
	}

}
