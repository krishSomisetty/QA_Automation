import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class addProducttoCart {
    public static void main(String[] args) {
        ChromeOptions options = new ChromeOptions();
        WebDriver driver = new ChromeDriver();
        driver.get(" https://demo.nopcommerce.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.findElement(By.name("q")).sendKeys("Nike", Keys.ENTER);
        WebElement dropdown = driver.findElement(By.id("products-orderby"));
        Select selector = new Select(dropdown);
        selector.selectByVisibleText("Price: low - High");
        System.out.println("Filter applied");
    }
}