import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

public class WebTableChallengePractice {
    public static void main(String[] args) {

        // --- 1. SETTINGS TO KILL THE POPUP ---
        ChromeOptions options = new ChromeOptions();
        Map<String, Object> prefs = new HashMap<String, Object>();
        prefs.put("credentials_enable_service", false); // Disables password service
        prefs.put("profile.password_manager_enabled", false); // Disables manager popup
        options.setExperimentalOption("prefs", prefs);

        // Launch the browser with these options
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();

        try {
            // --- 2. LOGIN FLOW ---
            driver.get("https://www.saucedemo.com/");
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

            // Log in using Explicit Waits for stability
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("user-name"))).sendKeys("standard_user");
            driver.findElement(By.id("password")).sendKeys("secret_sauce");
            driver.findElement(By.id("login-button")).click();

            // --- 3. WAIT FOR PAGE LOAD ---
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("inventory_container")));

            // --- 4. THE DYNAMIC XPATH ---
            String productName = "Sauce Labs Backpack";

            // This XPath finds the name, goes up to the parent container, and then finds the price
            String xpathString = "//div[text()='" + productName + "']/ancestor::div[@class='inventory_item_description']//div[@class='inventory_item_price']";

            WebElement price = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpathString)));

            // --- 5. OUTPUT THE RESULT ---
            System.out.println("==============================================");
            System.out.println("Product Name: " + productName);
            System.out.println("Verified Price: " + price.getText());
            System.out.println("==============================================");

        } catch (Exception e) {
            System.out.println("Error found: " + e.getMessage());
        } finally {
            // Give it a few seconds so you can see the screen before it closes
            try { Thread.sleep(5000); } catch (InterruptedException e) {}
            driver.quit();
        }
    }
}