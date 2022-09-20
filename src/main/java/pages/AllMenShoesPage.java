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
    private List<WebElement> allElements;

    public List<WebElement> getAllElements() {
        return allElements;
    }
}
