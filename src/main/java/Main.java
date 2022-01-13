import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        /*
        driver.get("https://iprice.my");
        System.out.println(driver.findElement(By.xpath("//*[@id=\"homepage\"]/div[3]/h2")).getText());

        WebElement bestDealsOuterDiv = driver.findElement(By.xpath("//*[@id=\"homepage\"]/div[2]/div/div/amp-carousel/div/div[1]"));
        List<WebElement> bestDealsLinks = bestDealsOuterDiv.findElements(By.tagName("a"));
        System.out.println(bestDealsLinks.size());

        WebElement topTrendingOuterDiv = driver.findElement(By.xpath("//*[@id=\"homepage\"]/div[3]/amp-carousel/div/div[1]"));
        List<WebElement> topTrendinglinks = topTrendingOuterDiv.findElements(By.tagName("a"));


        for(WebElement link : topTrendinglinks) {
            System.out.println(link.getAttribute("data-vars-cgt"));
        } */

        driver.get("https://iprice.my/coupons");
        WebElement topStoresOuterDiv = driver.findElement(By.xpath("//*[@id=\"coupon-overview\"]/div/div[2]/div/div/div[1]/section"));
        List<WebElement> topStoresLinks = topStoresOuterDiv.findElements(By.className("rY"));
        System.out.println(topStoresLinks.size());


        Map<String, String> urls = new HashMap<String, String>();
        for(WebElement link : topStoresLinks) {
            String url = link.findElement(By.tagName("a")).getAttribute("href");
            String title = link.getText();

            //System.out.println(url +" - " + title);
            urls.put(url, title);
        }

        for(String url : urls.keySet()) {

            driver.get(url);
            System.out.println(driver.getTitle());
            System.out.println((urls.get(url)));
        }
        //"#coupon-overview > div > div.mu.lD > div > div > div.nz > section > div:nth-child(2)"
        //"#coupon-overview > div > div.mu.lD > div > div > div.nz > section > div:nth-child(14)"
    }
}
