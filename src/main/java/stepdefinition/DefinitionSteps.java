package stepdefinition;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import manager.PageFactoryManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.*;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static io.github.bonigarcia.wdm.WebDriverManager.chromedriver;

public class DefinitionSteps {

    private static final long DEFAULT_TIMEOUT = 60;

    WebDriver driver;
    HomePage homePage;
    AllMenShoesPage allMenShoesPage;
    PageFactoryManager pageFactoryManager;

    @Before
    public void testsSetUp(){
        chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        pageFactoryManager = new PageFactoryManager(driver);
    }

    @After
    public void tearDown() {
        driver.close();
    }

    @Given("User opens {string} page")
    public void userOpenPage(final String url) {
        homePage = pageFactoryManager.getHomePage();
        homePage.openHomePage(url);                     
    }

    @And("User accepts cookies")
    public void userAcceptsCookies() {
        homePage.cookieAccept();
    }
    
    @Then("User checks whether header is visible")
    public void userChecksWhetherHeaderIsVisible() {
        homePage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        assertTrue(homePage.isRightHeaderVisible());
    }
    
    @When("User moves a cursor to the tab menu Shoes")
    public void userMovesACursorToTheTabMenuShoes() {
        homePage.moveToElement();
    }

    @And("User clicks All for men")
    public void userClicksAllForMen() {
        homePage.clickOnTabShoesAllMen();
        allMenShoesPage = pageFactoryManager.getAllMenShoesPage();
        allMenShoesPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
    }

    @Then("User checks if the elements on page contains word {string}more than ten times")
    public void userChecksIfTheElementsOnPageContainsWordKeyWordMoreThanTenTimes(String keyWord) {
        List<WebElement> allElements = allMenShoesPage.getAllElements();
        int count = 0;
        for (WebElement element : allElements) {
            if (element.getText().contains(keyWord)) {
                count += 1;
            }
        }

        assertTrue(count > 10);
    }
}
