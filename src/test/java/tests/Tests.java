package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Tests {
	
	private WebDriver driver;
	@BeforeMethod
	public void setUp() {
		DesiredCapabilities caps = new DesiredCapabilities();//lo que esta adentro de un navegador chrome
		System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to("http://newtours.demoaut.com/");
		try {
			Thread.sleep(5000);
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void pruebaUno() {
		driver.findElement(By.name("userName")).sendKeys("user");
		driver.findElement(By.name("password")).sendKeys("user");
		driver.findElement(By.name("login")).click();
		try {
			Thread.sleep(5000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		Assert.assertTrue(driver.findElement(By.xpath("/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[3]/td/p/font/b")).getText().contains("Welcome back to"));
	}
	
	@AfterMethod
	public void tearDown() {
		driver.close();
	}
}
