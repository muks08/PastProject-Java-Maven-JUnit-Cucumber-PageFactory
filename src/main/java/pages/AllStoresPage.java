package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class AllStoresPage extends BasePage {

    public AllStoresPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[contains(text(), 'Polska')]")
    private WebElement poland;

    public void ChangeLocationToPoland() {
        poland.click();
    }

}
