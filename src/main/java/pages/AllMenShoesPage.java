package pages;

import classes.Product;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
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

    public List<Product> getProductsList(List<WebElement> listName, List<WebElement> listPrice) {
        List<Product> productList = new ArrayList<>();
        for (int i = 0; i < listName.size(); i++) {
            Product temp = new Product();
            temp.setName(listName.get(i).getText());
            temp.setPrice(listPrice.get(i).getText());
            productList.add(temp);
        }
        return productList;
    }
}
