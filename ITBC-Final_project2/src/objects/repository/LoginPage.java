package objects.repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	WebDriver driver;

	public static String LOGIN_URL = "https://sandbox.2checkout.com/sandbox";

	@FindBy(xpath = "//input[@placeholder='Username']")
	public WebElement usernameField;

	@FindBy(id = "password")
	public WebElement passwordField;

	@FindBy(xpath = "//input[@class='btn blue']")
	public WebElement logInButton;
	
	@FindBy(xpath = "//p[contains(text(),'Incorrect username or password.')]")
	public WebElement incorrectCredentialsMessage;
	
	@FindBy (xpath = "//h5[contains(text(),'Account Status')]")
	public WebElement accountStatusHomePage;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void fillUsernameField(String username) {
		usernameField.sendKeys(username);
	}

	public void fillPasswordField(String password) {
		passwordField.sendKeys(password);
	}

	public void clickLogInButton() {
		logInButton.click();
	}

}
