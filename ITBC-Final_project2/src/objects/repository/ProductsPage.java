package objects.repository;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductsPage {

	WebDriver driver;

	public static String PRODUCTS_PAGE = "https://sandbox.2checkout.com/sandbox/home/dashboard";

	@FindBy(xpath = "//a[contains(text(),'Products')]")
	public WebElement productsButton;

	@FindBy(xpath = "//a[contains(text(),'Add New Product')]")
	public WebElement addNewProductLink;

	@FindBy(xpath = "//input[@name='name']")
	public WebElement nameField;

	@FindBy(xpath = "//input[@name='vendor_product_id']")
	public WebElement yourProductIdField;

	@FindBy(xpath = "//input[@name='description']")
	public WebElement shortDescriptionField;

	@FindBy(xpath = "//textarea[@name='long_description']")
	public WebElement longDescriptionField;

	@FindBy(xpath = "//input[@name='price']")
	public WebElement priceField;

	@FindBy(xpath = "//input[@name='approved_url']")
	public WebElement approvedUrlField;

	@FindBy(xpath = "//input[@name='submit']")
	public WebElement saveChangesButton;

	@FindBy(xpath = "//a[contains(text(),'View')]")
	public WebElement viewButton;

	@FindBy(xpath = "//a[contains(text(),'Edit')]")
	public WebElement editButton;

	@FindBy(xpath = "//input[@name='price_9093754056090']")
	public WebElement editPriceField;

	@FindBy(xpath = "//span[@class='form_valid large']")
	public WebElement updateSuccessfulMessage;

	@FindBy(xpath = "//html[1]/body[1]/div//form[1]/table[1]/tbody[1]//tr/td[6]/input")
	public List<WebElement> lPrice;

	@FindBy(xpath = "//input[@class='context-btn save']")
	public WebElement saveProductChangesLink;

	@FindBy(xpath = "//span[@class='form_valid']")
	public WebElement allUpdatesSucceeededMessage;

	public ProductsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void clickProductsButton() {
		productsButton.click();
	}

	public void clickAddNewProductLink() {
		addNewProductLink.click();
	}

	public void fillNameField(String name) {
		nameField.sendKeys(name);
	}

	public void fillYourProductIdField(String product) {
		yourProductIdField.sendKeys(product);
	}

	public void fillShortDescriptionField(String shortDescription) {
		nameField.sendKeys(shortDescription);
	}

	public void fillLongDescriptionField(String longDescription) {
		longDescriptionField.sendKeys(longDescription);
	}

	public void fillPriceField(String price) {
		priceField.sendKeys(price);
	}

	public void fillApprovedUrlField(String url) {
		approvedUrlField.sendKeys(url);
	}

	public void clickSaveChangesButton() {
		saveChangesButton.click();
	}

	public void clickViewButton() {
		viewButton.click();
	}

	public void clickEditButton() {
		editButton.click();
	}

	public void fillEditPriceField(String price) {
		editPriceField.sendKeys(price);
	}

	public void clickSaveProductChangesLink() {
		saveProductChangesLink.click();
	}

}
