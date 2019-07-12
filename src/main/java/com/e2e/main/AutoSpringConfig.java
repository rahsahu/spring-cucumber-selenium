package com.e2e.main;

import java.net.MalformedURLException;
import java.net.URL;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

import com.e2e.base.DriverType;
import com.e2e.base.Log4JFactory;
import com.e2e.utils.ServerUtil;

/**
 * 
 * @author rahulsahu
 *
 */
@Configuration
@ComponentScan({ "com.viu" })
@PropertySource("classpath:config/globleConfig.properties")

public class AutoSpringConfig {
	public Logger logger = Log4JFactory.getLogger(this.getClass().getName());

	@Autowired
	Environment env;

	@Bean
	public String testBean() {
		System.out.println("XXXXXXXXXXXXX:" + env.getProperty("env"));
		return "Bean ban rahi hai ";
	}

	@Bean(name = "platformType")
	public String platformType() {
		if (env.getProperty("driverType") == null) {
			throw new RuntimeException("set property -DdriverType");
		} else {
			if (env.getProperty("driverType").trim().toUpperCase().startsWith("DESKTOP")) {
				return "DESKTOP";
			} else if (env.getProperty("driverType").trim().toUpperCase().startsWith("ANDROID")) {
				return "ANDROID";
			} else {
				return "IOS";
			}
		}
	}

	@Bean(name = "portNumber")
	public String portNumber() {
		if (env.getProperty("driverType") == null) {
			throw new RuntimeException("set property -DdriverType");
		} else {
			if (env.getProperty("driverType").trim().toUpperCase().startsWith("DESKTOP")) {
				return env.getProperty("selenium.port");
			} else {
				return env.getProperty("appium.port");
			}
		}
	}

	@Bean("startServer")
	@DependsOn({ "platformType", "portNumber" })
	public String startServer() {
		try {
			ServerUtil serverUtil = new ServerUtil();
			serverUtil.startServer(portNumber());
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("Not Able to Start Server");
		}
		return "true";
	}

	@Bean(name = "driverType")
	@DependsOn("startServer")
	public DriverType driverType() {

		return DriverType.valueOf(env.getProperty("driverType"));
	}

	@Bean(name = "getCapabilities")
	@DependsOn("driverType")
	public DesiredCapabilities getCapabilities() {
		return driverType().getDesiredCapabilities();
	}

	@Bean(name = "driver")
	@DependsOn({ "getCapabilities", "driverType" })
	public WebDriver driver() {
		WebDriver driver = null;
		try {
			System.out.println("Capabilities : " + getCapabilities().toString());
			driver = new RemoteWebDriver(new URL("http://localhost:" + portNumber() + "/wd/hub"), getCapabilities());
		} catch (MalformedURLException e) {
			e.printStackTrace();
			throw new RuntimeException("WebDriver Object not created");
		}
		return driver;
	}

}
