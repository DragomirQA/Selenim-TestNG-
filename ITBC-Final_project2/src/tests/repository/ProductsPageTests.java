package tests.repository;

import org.testng.annotations.Test;

import objects.repository.LoginPage;
import objects.repository.ProductsPage;

import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class ProductsPageTests {

	ProductsPage pp;
	LoginPage lp;

	@BeforeClass
	public void beforeClass() {
		WebDriver driver = LoginPageTests.driver;
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		pp = new ProductsPage(driver);
		lp = new LoginPage(driver);
		driver.get(ProductsPage.PRODUCTS_PAGE);
	}

	@Test(priority = 0)
	public void loginSuccessful() {
		lp.fillUsernameField("Prasence");
		lp.fillPasswordField("Papkar8982");
		lp.clickLogInButton();
		Assert.assertTrue(lp.accountStatusHomePage.isDisplayed());
	}

	@Test(priority = 1)
	public void addProduct() {
		for (int i = 0; i < 5; i++) {
			pp.clickProductsButton();
			pp.clickAddNewProductLink();
			pp.fillNameField("banana");
			pp.fillYourProductIdField("00735");
			pp.fillShortDescriptionField("This is fruit");
			pp.fillLongDescriptionField("Buy this fruit, eat it every day and be strong and happy.");
			pp.fillPriceField("120");
			pp.fillApprovedUrlField("www.bananasareus.com");
			pp.clickSaveChangesButton();
			Assert.assertTrue(pp.updateSuccessfulMessage.isDisplayed());
		}
	}

	@Test(priority = 2)
	public void editProductPriceBy100() {
		pp.clickProductsButton();
		pp.clickEditButton();
		for (int i = 0; i < 2; i++) {
			String currentPrice = pp.lPrice.get(i).getAttribute("value");
			double icurrentPrice = Double.parseDouble(currentPrice);
			double updatedPrice = icurrentPrice + 100;
			pp.lPrice.get(i).clear();
			String supdatedPrice = Double.toString(updatedPrice);
			pp.lPrice.get(i).sendKeys(supdatedPrice);

		}
		pp.clickSaveProductChangesLink();
		Assert.assertTrue(pp.allUpdatesSucceeededMessage.isDisplayed());

	}

//	@AfterClass
//	public void afterClass() {
//		driver.quit();
//	}

}
