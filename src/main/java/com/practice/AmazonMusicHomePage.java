package com.practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AmazonMusicHomePage {

	private WebDriver driver;

	public AmazonMusicHomePage(WebDriver driver) {
		this.driver = driver;
	}

	private By Hello = By.xpath("//div[text()='Hello, Sign In']");
	private By SignIn = By.linkText("Sign In");

	public WebElement Hello() {

		return driver.findElement(Hello);
	}

	public WebElement SignIn() {

		return driver.findElement(SignIn);
	}
}
