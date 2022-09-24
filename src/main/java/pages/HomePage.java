package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

	public HomePage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//div[@id='headerWrapper']")
	private WebElement header;

	@FindBy(xpath = "//header/div/div/ul/li/a[@href='https://www.cropp.com/ua/uk/vzuttia']")
	private WebElement tabShoes;

	@FindBy(xpath = "//header/div/div/ul/li/ul/div/a[@href='https://www.cropp.com/ua/uk/vzuttia/cholovikam']")
	private WebElement tabShoesAllMen;

	@FindBy(xpath = "//span[@data-testid='store-switcher']")
	private WebElement languageButton;

	@FindBy(xpath = "//input[@class='input__InputText-sc-1mxde2b-0 hjxLSD']")
	private WebElement searchButton;

	public void openHomePage(String url) {
		driver.get(url);
	}

	public boolean isRightHeaderVisible() {
		return header.isDisplayed();
	}

	public void moveToElement() {
		new Actions(driver).moveToElement(tabShoes).perform();
	}

	public void clickOnTabShoesAllMen() {
		tabShoesAllMen.click();
	}

	public void changeLanguage() {
		languageButton.click();}

	public void clickOnSearchButton() {
		searchButton.click();
	}
}
