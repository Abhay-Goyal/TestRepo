package com.practice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import resources.DriverInitialization;

public class AmzonmusicTest extends DriverInitialization {

	public WebDriver driver;

	@Test(dataProvider = "getData")
	public void searchMusic(String Uname, String pwd) throws InterruptedException {

		driver = getDriver();

		driver.get("https://music.amazon.in/home?ref=dm_ws_lnd_pm_listn_pm_f82420aa-88c3-44d8-940f-fd4a1f8b5d04");

		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

		AmazonMusicHomePage hp = new AmazonMusicHomePage(driver);
		hp.SignIn().click();

		Amazon_Login_Page lp = new Amazon_Login_Page(driver);

		// Opening the legal policies on another tab
		int numberofpolicices = lp.policies().findElements(By.tagName("a")).size();
		for (int i = 0; i < numberofpolicices; i++) {
			lp.policies().findElements(By.tagName("a")).get(i).sendKeys(Keys.chord(Keys.CONTROL, Keys.ENTER));
		}

		lp.email().sendKeys(Uname);
		lp.password().sendKeys(pwd);
		lp.Login().click();

		if (driver.getTitle().contains("Authentication")) {

			System.out.println("Authentication required in order to login");
			System.out.println("New Change Commit");
			
		} else {
			AmazonMusic am = new AmazonMusic(driver);
			am.searchMusic().sendKeys("SidhuMooseWala");
			am.searchMusic().sendKeys(Keys.chord(Keys.CONTROL, Keys.ENTER));

		}
	}

	@DataProvider
	private Object[][] getData() {
		Object[][] data = new Object[1][2];
		data[0][0] = "abc@yopmail.com";
		data[0][1] = "test123";
		return data;

	}

}
