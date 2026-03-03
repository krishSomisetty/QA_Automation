import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class MiniProjectSauceDemo_ADV {
    public static void main(String[] args) throws IOException, InterruptedException {
        // 1. Data Setup
        Properties prop = new Properties();
        FileInputStream fis = new FileInputStream("src/main/resources/config.properties");
        prop.load(fis);

        String appUrl = prop.getProperty("url");
        String uName = prop.getProperty("username");
        String pWord = prop.getProperty("password");

        // 2. Driver Configuration
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();

        // 3. Execution Phase - Login
        driver.get(appUrl);
        ElementUtils.sendKeys(driver, By.id("user-name"), uName);
        ElementUtils.sendKeys(driver, By.id("password"), pWord);
        ElementUtils.clickElement(driver, By.id("login-button"));

        // 4. Validation - Check for Login Error
        boolean isErrorPresent = ElementUtils.isErrorMessageDisplayed(driver, By.cssSelector("h3[data-test='error']"), "Username and password do not match");

        if (isErrorPresent) {
            System.out.println("Negative Test Passed: Correct error displayed.");
            ElementUtils.captureScreen(driver, "SauceDemo_ADV", "Login_Failure");
            driver.quit();
            return;
        } else {
            System.out.println("Proceeding with Positive Flow...");
        }

        // 5. Add to Cart Phase
        ElementUtils.clickElement(driver, By.id("add-to-cart-sauce-labs-backpack"));
        ElementUtils.clickElement(driver, By.id("add-to-cart-sauce-labs-fleece-jacket"));
        System.out.println("Add to cart Successful....");
        ElementUtils.captureScreen(driver, "SauceDemo_ADV", "Products_Added");

        // 6. Checkout Phase
        ElementUtils.clickElement(driver, By.className("shopping_cart_link"));
        ElementUtils.clickElement(driver, By.id("checkout"));
        System.out.println("View cart Successful....");
        ElementUtils.sendKeys(driver, By.id("first-name"), "Krishna");
        ElementUtils.sendKeys(driver, By.id("last-name"), "Somisetty");
        ElementUtils.sendKeys(driver, By.id("postal-code"), "500075");
        ElementUtils.captureScreen(driver, "SauceDemo_ADV", "User_Information");
        System.out.println("User Details verified....");
        // 7. Completion Phase
        ElementUtils.clickElement(driver, By.id("continue"));
        ElementUtils.captureScreen(driver, "SauceDemo_ADV", "Order_Overview");

        ElementUtils.clickElement(driver, By.id("finish"));
        ElementUtils.captureScreen(driver, "SauceDemo_ADV", "Order_Confirmation");
        System.out.println("E2E SauceDemo Flow Completed Successfully!");
        driver.quit();
    }
}