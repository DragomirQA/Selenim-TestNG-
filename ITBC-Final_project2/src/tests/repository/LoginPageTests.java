package tests.repository;

import org.testng.annotations.Test;

import objects.repository.LoginPage;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;

public class LoginPageTests {

	public static WebDriver driver;
	LoginPage lp;

	@BeforeSuite
	public void beforeClass() {

		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		lp = new LoginPage(driver);
		driver.get(LoginPage.LOGIN_URL);

	}

	@Test(priority = 0)
	public void loginUnregisteredUser() {
		lp.fillUsernameField("Snackday");
		lp.fillPasswordField("sweetchili");
		lp.clickLogInButton();
		Assert.assertTrue(lp.incorrectCredentialsMessage.isDisplayed());
	}

	@Test(priority = 1)
	public void loginIncorrectUsername() {
		lp.fillUsernameField("Test123");
		lp.fillPasswordField("Papkar8982");
		lp.clickLogInButton();
		Assert.assertTrue(lp.incorrectCredentialsMessage.isDisplayed());
	}

	@Test(priority = 2)
	public void loginIncorrectPassword() {
		lp.fillUsernameField("Prasence");
		lp.fillPasswordField("Test123");
		lp.clickLogInButton();
		Assert.assertTrue(lp.incorrectCredentialsMessage.isDisplayed());
	}

	@Test(priority = 3)
	public void loginSuccessful() {
		lp.fillUsernameField("Prasence");
		lp.fillPasswordField("Papkar8982");
		lp.clickLogInButton();
		Assert.assertTrue(lp.accountStatusHomePage.isDisplayed());
	}

	@AfterSuite
	public void afterClass() {
		driver.quit();
	}

}
