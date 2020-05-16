package tests.repository;

import org.testng.annotations.Test;

import objects.repository.LoginPage;
import objects.repository.SignUpPage;

import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;

public class SignUpPageTests {

	WebDriver driver;
	SignUpPage sp;
	LoginPage lp;

	@BeforeClass
	public void beforeClass() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		sp = new SignUpPage(driver);
		lp = new LoginPage(driver);
		driver.get(SignUpPage.SIGNUP_URL);

	}

	@Test(priority = 0)
	public void registrationEmptyFirstName() {
		sp.usernameField.clear();
		sp.fillLastNameField("bWonder Pig");
		sp.fillEmailField("bester@thepig.com");
		sp.fillPasswordField("bPickle8982");
		sp.fillWebsiteField("wwww.grokoink.com");
		sp.clickGetStartedButton();
		Assert.assertTrue(sp.emptyFieldErrorMessage.isDisplayed());
	}

	@Test(priority = 1)
	public void registrationEmptyLastName() {
		sp.fillFirstNameField("bEster");
		sp.lastNameField.clear();
		sp.fillEmailField("bester@thepig.com");
		sp.fillPasswordField("bPickle8982");
		sp.fillWebsiteField("wwww.grokoink.com");
		sp.clickGetStartedButton();
		Assert.assertTrue(lp.accountStatusHomePage.isDisplayed());
	}

	@Test(priority = 2)
	public void registrationEmptyEmail() {
		sp.fillFirstNameField("bEster");
		sp.fillLastNameField("bWonder Pig");
		sp.emailField.clear();
		sp.fillPasswordField("bPickle8982");
		sp.fillWebsiteField("wwww.grokoink.com");
		sp.clickGetStartedButton();
		Assert.assertTrue(sp.emptyFieldErrorMessage.isDisplayed());
	}

	@Test(priority = 3)
	public void registrationEmptyPassword() {
		sp.fillFirstNameField("bEster");
		sp.fillLastNameField("bWonder Pig");
		sp.fillEmailField("bester@thepig.com");
		sp.passwordField.clear();
		sp.fillWebsiteField("wwww.grokoink.com");
		sp.clickGetStartedButton();
		Assert.assertTrue(sp.emptyFieldErrorMessage.isDisplayed());
	}

	@Test(priority = 4)
	public void registrationEmptyWebSite() {
		sp.fillFirstNameField("bEster");
		sp.fillLastNameField("bWonder Pig");
		sp.fillEmailField("bester@thepig.com");
		sp.fillPasswordField("bPickle8982");
		sp.websiteField.clear();
		sp.clickGetStartedButton();
		Assert.assertTrue(lp.accountStatusHomePage.isDisplayed());
	}

	@Test(priority = 5)
	public void registrationSuccessful() {
		sp.fillFirstNameField("Ester");
		sp.fillLastNameField("Wonder Pig");
		sp.fillEmailField("ester@thepig.com");
		sp.fillPasswordField("Pickle8982");
		sp.fillWebsiteField("wwww.grokoink.com");

//		WebElement iFrame = driver.findElement(By.xpath("//*[@id=\"signUpFormBox\"]/div[1]/div/div[1]/div/div/div/div/div[11]/div[1]/div/div/iframe"));
//		driver.switchTo().frame(iFrame);
//		WebElement iFrameCheckbox = driver.findElement(By.xpath("//span[@id='recaptcha-anchor']"));
//		iFrameCheckbox.click();

		sp.clickGetStartedButton();
		sp.clickDigitalProducts();
		sp.clickSalesTaxesRadioButton();
		sp.clickCreateAccountButton();
		Assert.assertTrue(lp.accountStatusHomePage.isDisplayed());
	}

	@AfterMethod
	public void cleanUp() {
		sp.usernameField.clear();
		sp.lastNameField.clear();
		sp.emailField.clear();
		sp.passwordField.clear();
		sp.websiteField.clear();

	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
