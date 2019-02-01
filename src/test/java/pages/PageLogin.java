package pages;

import javax.swing.JOptionPane;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import helpers.Helpers;

public class PageLogin {
	
	private WebDriver driver;
	private By userField;//Un campo donde ingreso el nobmre de usuario 
	private By passwordField;
	private By loginButton;
	
	public PageLogin(WebDriver driver) {
		
		this.driver = driver;
		userField=By.name("userName");
		passwordField=By.name("password");
		loginButton=By.name("loginButton");
	}
	
	public void login(String user, String pass, String tituloPrueba) {
		JOptionPane.showMessageDialog(null, tituloPrueba);
		driver.findElement(userField).sendKeys(user);
		driver.findElement(passwordField).sendKeys(pass);
		driver.findElement(loginButton).click();
		Helpers helper = new Helpers();
		helper.sleepSeconds(4);
	}
}
