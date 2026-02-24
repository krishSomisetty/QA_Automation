import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class MultiBoxRegression {
    public static void main(String[] args) { // Removed throws InterruptedException (not needed anymore!)
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        WebDriver driver = new ChromeDriver(options);

        String[] boxUrls = {
                "https://www.saucedemo.com/",
                "https://www.saucedemo.com/v1/",
                "https://www.saucedemo.com/"
        };

        driver.get(boxUrls[0]);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        for (int i = 1; i < boxUrls.length; i++) {
            js.executeScript("window.open('" + boxUrls[i] + "','_blank');");
        }

        List<String> handles = new ArrayList<>(driver.getWindowHandles());

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        for (int i = 0; i < handles.size(); i++) {
            driver.switchTo().window(handles.get(i));

            System.out.println("Processing Tab " + (i + 1) + ": " + driver.getCurrentUrl());

            // Reusing the 'wait' object makes the code cleaner
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("user-name"))).sendKeys("standard_user");
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("password"))).sendKeys("secret_sauce");
            wait.until(ExpectedConditions.elementToBeClickable(By.id("login-button"))).click();

            System.out.println("Box " + (i + 1) + " login successful on: " + driver.getCurrentUrl());
        }

        // driver.quit();
    }
}