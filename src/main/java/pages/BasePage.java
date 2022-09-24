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

	public BasePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void cookieAccept() {
		if (cookieBanner.isDisplayed())cookiebotDialogOkButton.click();
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
