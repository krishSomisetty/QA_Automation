import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MouseHoverPractice {
    public static void main(String[] args){
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.amazon.in/");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement myaccountMenu = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("nav-link-accountList")));
         Actions actions = new Actions(driver);
         actions.moveToElement(myaccountMenu).perform();
         WebElement myaccount = driver.findElement(By.linkText("Your Orders"));
         myaccount.click();
         System.out.println("Navigated and opened orders in my account");
         driver.quit();

    }
}
