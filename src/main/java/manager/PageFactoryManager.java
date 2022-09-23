package manager;

import org.openqa.selenium.WebDriver;
import pages.*;

public class PageFactoryManager {
    WebDriver driver;

    public PageFactoryManager(WebDriver driver) {this.driver = driver;}

    public HomePage getHomePage(){return new HomePage(driver);}

    public AllMenShoesPage getAllMenShoesPage(){return new AllMenShoesPage(driver);}

    public AllStoresPage getAllStoresPage(){return new AllStoresPage(driver);}

    public CartPage getCartPage(){return new CartPage(driver);}
}
