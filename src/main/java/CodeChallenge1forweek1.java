import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.Keys;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class CodeChallenge1forweek1 {
    public static void main(String[] args){
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.google.com");
        WebElement searchbar = driver.findElement(By.name("q"));
        searchbar.sendKeys("Selenium Automation", Keys.ENTER);
        System.out.println("Page Title is : " + driver.getTitle());
        driver.quit();
    }

}
