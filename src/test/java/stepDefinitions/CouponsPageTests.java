package stepDefinitions;
import io.cucumber.java.AfterAll;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

public class CouponsPageTests {
    static WebDriver driver;
    Map<String, String> urls = new HashMap<String, String>();

    @Given("User is on coupons page")
    public void user_is_on_coupons_page() {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://iprice.my/coupons");
    }
    @When("He sees Top Stores")
    public void he_sees_top_stores() {
        WebElement topStoresOuterDiv = driver.findElement(By.xpath("//*[@id=\"coupon-overview\"]/div/div[2]/div/div/div[1]/section"));
        List<WebElement> topStoresLinks = topStoresOuterDiv.findElements(By.className("rY"));

        for(WebElement link : topStoresLinks) {
            String url = link.findElement(By.tagName("a")).getAttribute("href");
            String title = link.getText();

            urls.put(url, title);
        }
    }
    @Then("Validate that all urls are active and link to proper stores")
    public void validate_that_all_urls_are_active_and_link_to_proper_stores() {
        for(String url : urls.keySet()) {
            driver.get(url);
            String title = urls.get(url);

            assertNotNull(driver.findElement(By.xpath( "//*[contains(text(),'"+title+"')]")));
        }
    }

    @AfterAll
    public static void before_or_after_all() {
        driver.close();
    }
}
