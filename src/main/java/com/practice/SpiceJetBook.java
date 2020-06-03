package com.practice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class SpiceJetBook {

	private WebDriver driver;

	public SpiceJetBook(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	private By Triptype = By.xpath("//input[contains(@id,'ctl00_mainContent_rbtnl_Trip')]");

	public List<WebElement> tripType() {
		return driver.findElements(Triptype);
	
	}

}
