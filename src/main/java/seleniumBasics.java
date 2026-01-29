import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

public class seleniumBasics {
    public static void main(String[] args) {

        // --- STEP 1: CONFIGURE CHROME ---
        ChromeOptions options = new ChromeOptions();
        // to open tab in incognito
        options.addArguments("--incognito");
        options.addArguments("--disable-notifications");
        // Create a Map to store our preferences
        Map<String, Object> prefs = new HashMap<>();

        // Add the rules to the map
        prefs.put("credentials_enable_service", false);
        prefs.put("profile.password_manager_enabled", false);

        // Apply the map to ChromeOptions using 'setExperimentalOption'
        options.setExperimentalOption("prefs", prefs);

        // Stop the "Data Breach" warning
        options.addArguments("--disable-notifications");

        // --- STEP 2: LAUNCH BROWSER WITH OPTIONS ---
        WebDriver driver = new ChromeDriver(options);

        driver.get("https://www.saucedemo.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // Login Logic
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();

        // Verification
        String currentUrl = driver.getCurrentUrl();
        if(currentUrl.contains("inventory")) {
            System.out.println("TEST PASSED: Login Successful!");
        } else {
            System.out.println("TEST FAILED: Login Failed. Current URL: " + currentUrl);
        }
// Filter the products in the screen using filter dropdown
        WebElement dropdown = driver.findElement(By.className("product_sort_container"));
        Select selector = new Select(dropdown);
        selector.selectByVisibleText("Name (Z to A)");
        // --- STEP 3: THE ADD TO CART ---

        // Corrected XPath without the '@' symbol for text()
        WebElement addToCart = driver.findElement(By.xpath("//button[text()='Add to cart']"));
        addToCart.click();

        System.out.println("Item added to cart!");

        // 1. Find the badge element
        String badgeElement = driver.findElement(By.className("shopping_cart_badge")).getText();
        System.out.println("Cart count is " + badgeElement);
        //Verification
        if (badgeElement.equals("1")){
            System.out.println("TEST PASSED: Item was successfully added!");
        }
        else{
            System.out.println("TEST FAILED: Item was not successfully added!");
        }
    }
}