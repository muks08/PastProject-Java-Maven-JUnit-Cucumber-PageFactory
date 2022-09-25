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

	@FindBy(xpath = "//a[@class='hit-item__Title-cz15ax-4 fPngiJ']")
	private List<WebElement> allProductName;

	@FindBy(xpath = "//div[@class='product-price__ProductPriceWrapper-sc-1ftsh9w-0 kdWDDW']")
	private List<WebElement> allProductPrice;

	@FindBy(xpath = "//input[@type='search']")
	private WebElement inputField;

	@FindBy(xpath = "//iframe[@id='__JSBridgeIframe_SetResult_1.0__']")
	private WebElement searchFrameEl1;
	@FindBy(xpath = "//iframe[@id='__JSBridgeIframe_1.0__']")
	private WebElement searchFrameEl2;
	@FindBy(xpath = "//iframe[@id='__JSBridgeIframe__']")
	private WebElement searchFrameEl3;
	@FindBy(xpath = "//iframe[@id='__JSBridgeIframe_SetResult__']")
	private WebElement searchFrameEl4;

	private String searchFrame1 = "__JSBridgeIframe_SetResult_1.0__";
	private String searchFrame2 = "__JSBridgeIframe_1.0__";
	private String searchFrame3 = "__JSBridgeIframe__";
	private String searchFrame4 = "__JSBridgeIframe_SetResult__";

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

	public void switchToSearchFrame() {
		driver.switchTo().frame(searchFrameEl4);
	}
}
