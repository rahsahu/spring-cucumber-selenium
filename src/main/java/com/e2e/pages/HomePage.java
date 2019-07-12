package com.e2e.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 
 * @author rahulsahu
 *
 */
@Component
public class HomePage extends BasePage {

	@Autowired
	private WebDriver driver;

	public HomePage() {
		PageFactory.initElements(driver, this);
	}

}
