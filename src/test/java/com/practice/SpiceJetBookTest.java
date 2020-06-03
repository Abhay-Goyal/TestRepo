package com.practice;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import resources.DriverInitialization;

public class SpiceJetBookTest extends DriverInitialization {

	public WebDriver driver;

	public static Logger log = LogManager.getLogger(SpiceJetBookTest.class.getName());

	@Test
	public void spiceTest() throws InterruptedException {

		driver = getDriver();

		log.info("Driver is intiated");

		driver.get("https://www.spicejet.com/");

		Thread.sleep(10000);

		SpiceJetBook sjb = new SpiceJetBook(driver);

		int triptype = sjb.tripType().size();

		for (int i = 0; i < triptype; i++) {

			String trip = sjb.tripType().get(i).getAttribute("value");

			if (trip.equalsIgnoreCase("RoundTrip")) {
				sjb.tripType().get(i).click();
				log.info("Round Trip is selected");
				break;
			}

			else {
				log.error("Round is not selected selected");
			}
		}

	}

	@AfterMethod
	public void closeBrowser() {

		driver.close();

	}
}