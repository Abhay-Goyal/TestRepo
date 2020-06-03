package com.practice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SpicejetHomePage {

	private WebDriver driver;

	public SpicejetHomePage(WebDriver driver) {

		this.driver = driver;
	}

	private By SearchHeading = By.xpath("//div[@class='search-buttons-heading']");
	
	

	public WebElement searchHeading() {

		return driver.findElement(SearchHeading);

	}

}
