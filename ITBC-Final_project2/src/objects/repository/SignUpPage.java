package objects.repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignUpPage {

	WebDriver driver;

	public static String SIGNUP_URL = "https://www.2checkout.com/pricing/2sell/";

	@FindBy(id = "first_name")
	public WebElement usernameField;

	@FindBy(id = "last_name")
	public WebElement lastNameField;

	@FindBy(id = "email")
	public WebElement emailField;

	@FindBy(id = "password")
	public WebElement passwordField;

	@FindBy(id = "website")
	public WebElement websiteField;

	@FindBy(xpath = "//a[@class='btn large green buffer10 nextBtn ga_1']")
	public WebElement getStartedButton;

	@FindBy(xpath = "//span[contains(text(),'Please fill in this field')]")
	public WebElement emptyFieldErrorMessage;

	@FindBy(xpath = "//div[@class='stepTwoItemAll stepTwoItem1 active']//img[@class='img-responsive center-block activeView']")
	public WebElement digitalProducts;

	@FindBy(xpath = "//div[@class='taxesMyOwn stepTwoAllQuestions active']//span[@class='stepTwoOptionSelect']")
	public WebElement salesTaxesRadioButton;

	@FindBy(xpath = "//a[@id='nextBtn']")
	public WebElement createAccountButton;

	@FindBy(xpath = "//a[@id='loginUrl']")
	public WebElement loginToMyAccountButton;

	public SignUpPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void fillFirstNameField(String username) {
		usernameField.sendKeys(username);
	}

	public void fillLastNameField(String lastname) {
		lastNameField.sendKeys(lastname);
	}

	public void fillEmailField(String email) {
		emailField.sendKeys(email);
	}

	public void fillPasswordField(String password) {
		passwordField.sendKeys(password);
	}

	public void fillWebsiteField(String website) {
		websiteField.sendKeys(website);
	}

	public void clickGetStartedButton() {
		getStartedButton.click();
	}

	public void clickDigitalProducts() {
		digitalProducts.click();
	}

	public void clickSalesTaxesRadioButton() {
		salesTaxesRadioButton.click();
	}

	public void clickCreateAccountButton() {
		createAccountButton.click();
	}

}
