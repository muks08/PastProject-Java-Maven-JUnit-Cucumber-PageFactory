package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class AllMenShoesPage extends BasePage {

    public AllMenShoesPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//section[@id='categoryProducts']")
    private List<WebElement> allElements;

    public List<WebElement> getAllElements() {
        return allElements;
    }
}
