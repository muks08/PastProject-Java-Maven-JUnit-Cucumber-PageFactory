package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//div[@id='headerWrapper']")
    private WebElement header;

    @FindBy(xpath = "//div[@id='cookiebanner']")
    private WebElement cookieBanner;

    @FindBy(xpath = "//button[@id='cookiebotDialogOkButton']")
    private WebElement cookiebotDialogOkButton;

    public void openHomePage(String url) {
        driver.get(url);

    }

    public void cookieAccept() {
        if (cookieBanner.isDisplayed())cookiebotDialogOkButton.click();
    }

    public boolean isRightHeaderVisible() {
        return header.isDisplayed();
    }
}
