package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class BasePage {
	protected WebDriver driver;

	@FindBy(xpath = "//div[@id='cookiebanner']")
	private WebElement cookieBanner;

	@FindBy(xpath = "//button[@id='cookiebotDialogOkButton']")
	private WebElement cookiebotDialogOkButton;

	@FindBy(xpath = "//label[contains(text(),'Сортувати за')]")
	private WebElement sortBy;

	@FindBy(xpath = "//label[@for='sortBy-0']")
	private WebElement sortByAscendingPrice;

	@FindBy(xpath = "//label[@for='sortBy-1']")
	private WebElement sortByDescendingPrice;

	@FindBy(xpath = "//button[contains(text(),'Сортувати')]")
	private WebElement sortingButton;

	public BasePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void cookieAccept() {
		if (cookieBanner.isDisplayed())cookiebotDialogOkButton.click();
	}

	public void clickOnSortBy() {
		sortBy.click();
	}

	public void clickOnSortByAscendingPrice() {
		sortByAscendingPrice.click();
	}

	public void clickOnSortByDescendingPrice() {
		sortByDescendingPrice.click();
	}

	public void clickOnSortingButton() {
		sortingButton.click();
	}

	public void waitForPageLoadComplete(long timeToWait) {
		new WebDriverWait(driver, timeToWait).until(
				webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
	}

	public void WebDriverImplicitlyWait(long time) {
		driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
	}

	public void waitForAjaxComplete(long timeToWait){
		new WebDriverWait(driver, timeToWait).until(
				webDriver -> ((JavascriptExecutor) webDriver).executeScript(
						"return window.jQuery != undefined && jQuery.active == 0;"));
	}

	public void waitVisibilityOfElement(long timeToWait, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, timeToWait);
		wait.until(ExpectedConditions.visibilityOf(element));
	}
}
