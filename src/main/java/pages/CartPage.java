package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartPage extends BasePage {
    public CartPage(WebDriver driver){
        super(driver);
    }

    @FindBy(xpath = "//*[@id=\"ModalRoot-lyrhutsewp\"]/div/div[2]/div/div[2]/div[2]/a")
    private WebElement cartButton;

    public void goesToTheShoppingCart(){
        cartButton.click();
    }
}
