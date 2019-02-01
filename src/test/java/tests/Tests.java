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
import pages.PageLogon;
import pages.PageReservation;

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
		PageLogon pageLogon= new PageLogon(driver);
		pageLogin.login("user", "user", "Prueba Uno");
		pageLogon.assertLogonPage();
	}
	
	@Test
	public void pruebaDos() {
		PageLogin pageLogin= new PageLogin(driver);
		PageReservation pageReservation = new PageReservation(driver);
		pageLogin.login("mercury", "mercury", "Prueba Dos");
		pageReservation.assertPage();
	}
	
	@AfterMethod
	public void tearDown() {
		driver.close();
	}
}
