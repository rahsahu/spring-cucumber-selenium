package com.e2e.utils;

import java.io.File;
import java.util.Date;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;

import com.e2e.base.Log4JFactory;

import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;

/**
 * 
 * @author rahulsahu
 *
 */
public class ServerUtil {

	public Logger logger = Log4JFactory.getLogger(this.getClass().getName());

	public void startServer(String port) throws InterruptedException {
		System.out.println("Driver_Type: " + System.getProperty("driverType"));
		checkAndKillServers();
		if (System.getProperty("driverType").trim().toUpperCase().startsWith("DESKTOP")) {
			System.out.println("user.dir: " + System.getProperty("user.dir"));
			String cmd[] = { "src/test/resources/driver/startSeleniumServer.sh", System.getProperty("user.dir")
					+ "/src/test/resources/driver/selenium-server-standalone-3.141.59.jar ", port };
			runShellCommandAndExitImmediately(cmd, "Running Selenium server");
			System.out.println(" Selenium Server started on port - " + port);

		} else {
			System.out.println("ANDROID_HOME: " + System.getProperty("ANDROID_HOME"));
			System.setProperty("ANDROID_HOME", System.getProperty("ANDROID_HOME"));
			AppiumDriverLocalService service = null;

			HashMap<String, String> osPaths = getOSSpecificPaths(System.getProperty("os.name").toLowerCase());
			System.out.println("Starting Appium Server on port - " + port + " from - " + osPaths.toString());
			if (osPaths.get("appiumPath") != null) {
				service = AppiumDriverLocalService.buildService(new AppiumServiceBuilder()
						.usingDriverExecutable(new File(osPaths.get("nodePath"))).withIPAddress("0.0.0.0")
						.usingPort(Integer.parseInt(port.trim()))
						.withArgument(GeneralServerFlag.LOG_LEVEL, "error:debug")
						.withAppiumJS(new File(osPaths.get("appiumPath")))
						.withLogFile(new File("target/appiumLogs.txt")).withStartUpTimeOut(1, TimeUnit.MINUTES));
				service.start();
				System.out.println(" Appium Server started on port - " + port);
			} else {
				throw new RuntimeException("ERROR - Appium path not provided");
			}
		}
	}

	public HashMap<String, String> getOSSpecificPaths(String osName) {
		HashMap<String, String> osPaths = new HashMap<String, String>();
		if (osName.contains("mac")) {
			osPaths.put("nodePath", "/usr/local/bin/node");
			osPaths.put("appiumPath", "/usr/local/lib/node_modules/appium/build/lib/main.js");
		} else if (osName.contains("linux")) {
			osPaths.put("nodePath", "/opt/node/bin/node");
			osPaths.put("appiumPath", "/opt/node/lib/node_modules/appium/build/lib/main.js");
		}
		System.out.println("osPaths - " + osPaths);
		return osPaths;
	}

	public void checkAndKillServers() throws InterruptedException {

		String killCommand = System.getProperty("user.dir") + "/src/test/resources/driver/clearServer.sh";
		String killMessage = "kill existing Selenium Server using command - " + killCommand;
		runShellCommandAndWaitTillExecute(killCommand, killMessage);
		Thread.sleep(100);
	}

	public void runShellCommandAndWaitTillExecute(String command, String message) {
		System.out.println("[COMMAND] Started: " + new Date());
		System.out.println("[COMMAND] Message:" + message + " - Command: " + command + "");
		Runtime run = Runtime.getRuntime();
		try {
			Process pr = run.exec(command);
			pr.waitFor();
			Thread.sleep(200);
			System.out.println("[COMMAND] EXIT_VALUE: " + pr.exitValue());
		} catch (Exception e) {
			throw new RuntimeException("Failed to execute sh command");
		}
		System.out.println("[COMMAND] Finished: " + new Date());

	}

	public void runShellCommandAndExitImmediately(String[] command, String message) {
		System.out.println("[COMMAND] Started: " + new Date());
		System.out.println("[COMMAND] Message:" + message + " - Command: " + command.toString() + "");
		Runtime run = Runtime.getRuntime();
		try {
			Process pr = run.exec((command));
			pr.waitFor();
			Thread.sleep(200);
			System.out.println("[COMMAND] EXIT_VALUE: " + pr.exitValue());
		} catch (Exception e) {
			throw new RuntimeException("Failed to execute sh command");
		}
		System.out.println("[COMMAND] Finished: " + new Date());

	}

}
