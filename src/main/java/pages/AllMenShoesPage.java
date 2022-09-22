package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class AllMenShoesPage extends BasePage {

    public AllMenShoesPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//h3[@class='sc-eCstlR eUervm es-product-name']")
    private List<WebElement> allProductName;

    @FindBy(xpath = "//section[@class='sc-gsTEea kxkGu es-product-price']")
    private List<WebElement> allProductPrice;

    @FindBy(xpath = "//figcaption[@class='sc-hKgJUU dGyDEC']")
    private List<WebElement> allProductNameWithPrice;

    public List<WebElement> getAllProductName() {
        return allProductName;
    }

    public List<WebElement> getAllProductPrice() {
        return allProductPrice;
    }

    public List<WebElement> getAllProductNameWithPrice() {
        return allProductNameWithPrice;
    }
}
