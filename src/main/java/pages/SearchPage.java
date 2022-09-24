package pages;

import interfaces.IProduct;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SearchPage extends BasePage implements IProduct {

	public SearchPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//div[@class='hit-item__ProductInfo-cz15ax-2 gFMTte']")
	private List<WebElement> allProductName;

	@FindBy(xpath = "//div[@class='product-price__ProductPriceWrapper-sc-1ftsh9w-0 kdWDDW']")
	private List<WebElement> allProductPrice;

	@FindBy(xpath = "//input[@type='search']")
	private WebElement inputField;

	@Override
	public List<WebElement> getAllProductName() {
		return allProductName;
	}
	@Override
	public List<WebElement> getAllProductPrice() {
		return allProductPrice;
	}

	public void inputTextToSearchField(String str) {
		inputField.sendKeys(str);
	}
}
