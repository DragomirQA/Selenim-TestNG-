package tests.repository;

import org.testng.annotations.Test;
import objects.repository.SignUpPage;
import test.data.FakerTestDataGenerator;
import test.data.ReadFakeData;
import org.testng.annotations.BeforeClass;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class SignUpPageGenerate30Users {

	WebDriver driver;
	SignUpPage sp;

	ReadFakeData rfd;
	FakerTestDataGenerator fdg;

	@BeforeClass
	public void beforeClass() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		sp = new SignUpPage(driver);
		rfd = new ReadFakeData();
		fdg = new FakerTestDataGenerator();
		driver.get(SignUpPage.SIGNUP_URL);
	}

	@Test
	public void register30newUsers() throws IOException, InterruptedException {
		fdg.generateData();
		for (int i = 0; i < 30; i++) {
			Thread.sleep(3000);

			sp.fillFirstNameField(rfd.getData(i, 0));
			sp.fillLastNameField(rfd.getData(i, 1));
			sp.fillEmailField(rfd.getData(i, 2));
			sp.fillPasswordField(rfd.getData(i, 3));
			sp.fillWebsiteField(rfd.getData(i, 4));
			sp.clickGetStartedButton();
			sp.clickDigitalProducts();
			sp.clickSalesTaxesRadioButton();
			sp.clickCreateAccountButton();

			Assert.assertTrue(sp.loginToMyAccountButton.isDisplayed());
			driver.get(SignUpPage.SIGNUP_URL);
			Thread.sleep(3000);

		}
	}

	@AfterClass
	public void afterClass() {
		driver.close();
	}

}
