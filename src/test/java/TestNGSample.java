import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert; // Import TestNG Assertions!
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class TestNGSample {

    WebDriver driver;

    // --- SETUP (Runs once before the test) ---
    @BeforeMethod
    public void setup() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        options.addArguments("--disable-notifications");

        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.saucedemo.com/");
    }

    // --- THE TEST CASE ---
    @Test
    public void testLoginAndAddToCart() {
        // 1. Login
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();

        // 2. Sort Items (Low to High)
        WebElement dropdown = driver.findElement(By.className("product_sort_container"));
        Select selector = new Select(dropdown);
        selector.selectByVisibleText("Price (low to high)");

        // 3. Add to Cart (First item)
        // Note: After sorting, the first 'Add to cart' button corresponds to the cheapest item
        driver.findElement(By.xpath("//button[text()='Add to cart']")).click();

        // 4. Verification (The Professional Way)
        String badgeCount = driver.findElement(By.className("shopping_cart_badge")).getText();

        // Assert.assertEquals(Actual, Expected, "Error Message if it fails");
        Assert.assertEquals(badgeCount, "1", "Cart count should be 1!");
    }

    // --- CLEANUP (Runs once after the test) ---
    @AfterMethod
    public void tearDown() {
        // driver.quit(); // Uncomment this to close the browser automatically
    }
}