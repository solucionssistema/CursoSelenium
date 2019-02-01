package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import helpers.Helpers;
import pages.PageLogin;

public class Tests {
	
	private WebDriver driver;
	@BeforeMethod
	public void setUp() {
		DesiredCapabilities caps = new DesiredCapabilities();//lo que esta adentro de un navegador chrome
		System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to("http://newtours.demoaut.com/");
		Helpers helper = new Helpers();
		helper.sleepSeconds(4);
	}
	
	@Test
	public void pruebaUno() {
		PageLogin pageLogin= new PageLogin(driver);
		pageLogin.login("mercury", "mercury", "Prueba Uno");
		Assert.assertTrue(driver.findElement(By.xpath("/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[3]/td/p/font/b")).getText().contains("Welcome back to"));
	}
	
	@Test
	public void pruebaDos() {
		PageLogin pageLogin= new PageLogin(driver);
		pageLogin.login("user", "user", "Prueba Dos");
		Assert.assertTrue(driver.findElement(By.xpath("/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[3]/td/font")).getText().contains("Use our Flight Finder "));
	}
	
	@AfterMethod
	public void tearDown() {
		driver.close();
	}
}
