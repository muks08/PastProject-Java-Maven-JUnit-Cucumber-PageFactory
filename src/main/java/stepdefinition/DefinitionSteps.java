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
import classes.*;

import java.util.List;
import java.util.function.Predicate;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static io.github.bonigarcia.wdm.WebDriverManager.chromedriver;

public class DefinitionSteps {

	private static final long DEFAULT_TIMEOUT = 60;

	WebDriver driver;
	HomePage homePage;
	AllMenShoesPage allMenShoesPage;

	AllStoresPage allStoresPage;
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
		List<WebElement> allProductName = allMenShoesPage.getAllProductName();
		long count = allProductName.stream().filter(element -> element.getText().contains(keyWord)).count();
		assertTrue(count > 10);
	}

	@When("User clicks Language button")
	public void userClicksLanguageButton() {
		homePage.changeLanguage();
		allStoresPage = pageFactoryManager.getAllStoresPage();
		allStoresPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
	}

	@And("User changes location to {string}")
	public void userChangesLocationToLocation(String location) {
		allStoresPage.ChangeLocation(location);
	}

	@Then("User checks that url has changed to {string}")
	public void userChecksThatUrlHasChangedToExpectedUrl(String expectedUrl) {
		homePage = pageFactoryManager.getHomePage();
		homePage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
		assertEquals(driver.getCurrentUrl(), expectedUrl);
	}

	@Then("User checks")
	public void userChecks() {
		allMenShoesPage = pageFactoryManager.getAllMenShoesPage();
		allMenShoesPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
		List<Product> allProducts = allMenShoesPage.getProductsList
				(allMenShoesPage.getAllProductName(), allMenShoesPage.getAllProductPrice());
//        int count = 0;
//        for (Product product : allProducts) {
//            if (product.getName().contains("Кросівки") && product.getPrice() < 500) {
//                count ++;
//            }
//        }
		Predicate<Product> byPrice = product -> product.getPrice() < 500;
		long count = allProducts.stream()
				.filter(product -> product.getName()
						.contains("Кросівки")).filter(byPrice)
				.count();
		assertEquals(0, count);
	}
}
