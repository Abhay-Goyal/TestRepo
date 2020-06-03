package com.practice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SpiceJetHotelBook {

	private WebDriver driver;

	public SpiceJetHotelBook(WebDriver driver) {

		this.driver = driver;
	}

	private By destination = By.xpath("//input[@id='ctl00_mainContent_txtOriginStation1_MST']");

	private By checkIn = By.xpath("//input[@id='ctl00$mainContent$txt_Fromdate_MST']");

	private By checkInDate = By.xpath("//a[@class='ui-state-default']");

	public WebElement destination() {
		return driver.findElement(destination);
	}

	public WebElement checkIn() {
		return driver.findElement(checkIn);
	}

	public List<WebElement> checkInDate() {
		return driver.findElements(checkInDate);

	}

}
