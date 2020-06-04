package com.practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AmazonMusic {

	private WebDriver driver;

	public AmazonMusic(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//div[@class='browseSection']")
	private WebElement browseSection;

	@FindBy(xpath = "//input[@id='searchMusic']")
	private WebElement searchMusic;

	public WebElement home() {
		WebElement home = browseSection.findElement(By.linkText("Home"));
		return home;
	}

	public WebElement stations() {
		WebElement stations = browseSection.findElement(By.linkText("Stations"));
		return stations;
	}

	public WebElement searchMusic() {
		return searchMusic;
	}

}
