package com.practice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Amazon_Login_Page {

	private WebDriver driver;

	public Amazon_Login_Page(WebDriver driver) {
		this.driver = driver;
	}

	private By email = By.id("ap_email");
	private By password = By.id("ap_password");
	private By Login = By.id("signInSubmit");
	private By policies = By.id("legalTextRow");



	public WebElement email() {

		return driver.findElement(email);

	}

	public WebElement password() {

		return driver.findElement(password);

	}

	public WebElement Login() {

		return driver.findElement(Login);

	}

	public WebElement policies() {

		return driver.findElement(policies);
	}

}
