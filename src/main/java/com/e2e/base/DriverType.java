package com.e2e.base;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;

public enum DriverType implements CapabilitiesSetup {

	DESKTOP_CHROME {

		public DesiredCapabilities getDesiredCapabilities() {
			System.setProperty("webdriver.chrome.driver",
					System.getProperty("user.dir") + "/src/main/resources/driver/chromedriver");
			final DesiredCapabilities capabilities = new DesiredCapabilities();
			capabilities.setCapability(CapabilityType.BROWSER_NAME, BrowserType.CHROME);
			return capabilities;
		}

	},

	ANDROID_WAP_CHROME {
		@Autowired
		Environment env;

		public DesiredCapabilities getDesiredCapabilities() {

			try {
				DesiredCapabilities capabilities = new DesiredCapabilities();
				capabilities.setCapability("automationName", "Appium");
				capabilities.setCapability("platformName", "Android");
				capabilities.setCapability("deviceName", "real device");
				capabilities.setCapability("udid", env.getProperty("udid"));
				capabilities.setCapability("newCommandTimeout", 2000);
				capabilities.setCapability("javascriptEnabled", true);
				ChromeOptions chromeOptions = new ChromeOptions();
				chromeOptions.addArguments("--disable-notifications");
				capabilities.setCapability("chromeOptions", chromeOptions);

				return capabilities;
			} catch (Exception ex) {
				ex.printStackTrace();
				return null;
			}
		}

	},

	BROWSER_STACK {
		@Autowired
		Environment env;

		public DesiredCapabilities getDesiredCapabilities() {
			try {
				DesiredCapabilities caps = new DesiredCapabilities();
				caps.setCapability("os", env.getProperty("osType").toString());
				caps.setCapability("os_version", env.getProperty("osVersion").toString());
				caps.setCapability("browser", env.getProperty("browserName").toString());
				caps.setCapability("browser_version", env.getProperty("browserVersion").toString());
				caps.setCapability("browserstack.debug", "true");
				caps.setCapability("build", env.getProperty("buildName").toString());
				caps.setCapability("browserstack.local", "false");
				return caps;
			} catch (Exception ex) {
				ex.printStackTrace();
				return null;
			}
		}

	};
}