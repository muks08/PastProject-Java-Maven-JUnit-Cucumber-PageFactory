package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartPage extends BasePage {
    public CartPage(WebDriver driver){
        super(driver);
    }

    @FindBy(xpath = "//*[@id=\"headerWrapper\"]/div[2]/div[3]/button[3]")
    private WebElement cartButton;

    public void goesToTheShoppingCart(){
        cartButton.click();
    }
}
