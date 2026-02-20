import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class IframePractice {
    public static void main(String[] args){
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.hyrtutorials.com/p/frames-practice.html");
        driver.switchTo().frame("frm1");
        driver.findElement(By.id("course")).sendKeys("java");
        driver.switchTo().defaultContent();
        driver.findElement(By.id("name")).sendKeys("krishna");
    }
}
