package com.project;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.mail.EmailException;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Amazon {
	static WebDriver driver;
	
	@BeforeClass
	public void loadUrl() {
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	public static void color(WebElement element,String ColorName) {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].setAttribute('style','background:yellow;border:solid 5px "+ColorName+";')", element);
	}
	
	@Test
	public void facebook() throws WebDriverException, IOException, InterruptedException {
		driver.get("https://www.amazon.in/");
		/*WebElement sign = driver.findElement(By.xpath("//*[text()='Hello, sign in']"));
		sign.click();
		
		WebElement username = driver.findElement(By.id("ap_email"));
		color(username, "green");
		Thread.sleep(2000);
		username.sendKeys("jackie.raj8@gmail.com");
		WebElement contin = driver.findElement(By.id("continue"));
		color(contin, "green");
		Thread.sleep(2000);
		contin.click();
		WebElement pass = driver.findElement(By.id("ap_password"));
		color(pass, "green");
		Thread.sleep(2000);
		pass.sendKeys("72993321");
		
		WebElement signbt = driver.findElement(By.id("signInSubmit"));
		color(signbt, "green");
		signbt.click();*/
		
		WebElement search = driver.findElement(By.id("twotabsearchtextbox"));
		color(search, "blue");
		Thread.sleep(2000);
		search.sendKeys("iphone");
		WebElement spress = driver.findElement(By.id("nav-search-submit-button"));
		color(spress, "green");
		Thread.sleep(2000);
		spress.submit();
		
		WebDriverWait wait = new WebDriverWait(driver, 20);
		WebElement profile=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@class='a-size-medium a-color-base a-text-normal']")));
		color(profile, "blue");
		profile.click();

		
		Set<String> windowHandles = driver.getWindowHandles();
		for (String string : windowHandles) {
			driver.switchTo().window(string);
			
		}

		WebElement addtocart = driver.findElement(By.id("add-to-cart-button"));
		color(addtocart, "blue");
		Thread.sleep(2000);
		addtocart.click();
		
		WebElement proceedto = driver.findElement(By.id("attach-sidesheet-checkout-button"));
		color(proceedto, "blue");
		proceedto.click();
		WebElement address = driver.findElement(By.partialLinkText("Deliver to this address"));
		address.click();
	}
	
	@AfterClass
	public void browserClose() throws EmailException, MalformedURLException {
		//driver.quit();
	}

}
