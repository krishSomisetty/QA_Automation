import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.io.FileHandler;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class LoginDataTestusingElementsUtil {
    public static void main(String[] args) throws IOException {
        Properties prop = new Properties();
        // configuring the path for the file
        FileInputStream fis = new FileInputStream("src/main/resources/config.properties");
        //load the file
        prop.load(fis);
        //get the properties of the file
        String appUrl = prop.getProperty("url");
        String uName = prop.getProperty("username");
        String pWord = prop.getProperty("password");
        // Initializing the driver
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        JavascriptExecutor js = (JavascriptExecutor) driver;

        driver.get(appUrl);
        driver.findElement(By.id("user-name")).sendKeys(uName);
        driver.findElement(By.id("password")).sendKeys(pWord);
        WebElement loginBtn = driver.findElement(By.id("login-button"));
        js.executeScript("arguments[0].click();", loginBtn);
        try {
            WebElement errorElement = driver.findElement(By.cssSelector("h3[data-test='error']"));
            String errorMessage = errorElement.getText();
            System.out.println("Error captured: " + errorMessage);

            // Take a screenshot of the failure
            ElementUtils.captureScreen(driver, "SauceDemo_ADV","Login_Error_Validation");

        } catch (NoSuchElementException e) {
            System.out.println("No error message found. Check if you actually used a wrong password!");
        }
    }
}
