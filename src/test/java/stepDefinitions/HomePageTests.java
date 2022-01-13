package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.junit.Assert.*;


import java.util.List;

public class HomePageTests {
    static WebDriver driver;
    List<WebElement> bestDealsLinks;
    List<WebElement> topTrendinglinks;

    @Given("User is on homepage")
    public void user_is_on_homepage() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://iprice.my");
    }
    @When("He sees all best deals")
    public void he_sees_all_best_deals() {
        WebElement bestDealsOuterDiv = driver.findElement(By.xpath("//*[@id=\"homepage\"]/div[2]/div/div/amp-carousel/div/div[1]"));
        bestDealsLinks = bestDealsOuterDiv.findElements(By.tagName("a"));

    }
    @When("He sees Top Trending Products")
    public void he_sees_top_trending_products() {
        WebElement topTrendingOuterDiv = driver.findElement(By.xpath("//*[@id=\"homepage\"]/div[3]/amp-carousel/div/div[1]"));
        topTrendinglinks = topTrendingOuterDiv.findElements(By.tagName("a"));
    }
    @Then("Count the list of the stores in the Find the Best Deals Online")
    public void count_the_list_of_the_stores_in_the_find_the_best_deals_online() {
        System.out.println(bestDealsLinks.size());
    }
    @Then("Count the list of items in Top Trending Products")
    public void count_the_list_of_items_in_top_trending_products() {
        System.out.println(topTrendinglinks.size());
    }
    @Then("Validate that each item in Top Trending Products contains {string}")
    public void validate_that_each_item_in_top_trending_products_contains(String string) {
        for(WebElement link : topTrendinglinks) {
            assertNotNull(link.getAttribute(string));
        }
    }

    @AfterAll
    public static void before_or_after_all() {
        driver.close();
    }
}
