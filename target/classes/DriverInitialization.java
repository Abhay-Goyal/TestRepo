package resources;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverInitialization {

	private WebDriver driver;

	public WebDriver getDriver() {

		String browser = System.getProperty("browser");

		if (browser.contains("chrome")) {

			//ChromeOptions c = new ChromeOptions();
			//c.addArguments("--headless");
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}

		else if (browser.contains("firefox")) {

			WebDriverManager.firefoxdriver().setup();

			driver = new FirefoxDriver();
		}

		else if (browser.contains("IE")) {

			WebDriverManager.iedriver().setup();

			driver = new InternetExplorerDriver();
		}

		else if (browser.contains("edge")) {
			WebDriverManager.edgedriver().setup();

			driver = new EdgeDriver();
		}

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		return driver;

	}

	public String takeScreenShot(WebDriver driver, String methodname) throws IOException {

		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		String pathname = System.getProperty("user.dir") + "//reports//" + methodname + ".png";

		File dest = new File(pathname);

		FileUtils.copyFile(src, dest);

		return pathname;

	}

}
