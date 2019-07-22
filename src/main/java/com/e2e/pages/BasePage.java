package com.e2e.pages;

import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 
 * @author rahulsahu
 *
 */
public class BasePage {
	
	@Autowired
	private WebDriver driver;

	public BasePage() {
		PageFactory.initElements(driver, this);
	}

	public void openURL(String url) {
		driver.get(url);
	}

	public String getURL() {
		return driver.getCurrentUrl();
	}

	public String getWindowHandle() {
		return driver.getWindowHandle();
	}

	public Set<String> getWindowHandles() {
		return driver.getWindowHandles();
	}

}
