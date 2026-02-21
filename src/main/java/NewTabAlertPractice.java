import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.Alert;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Set;

public class NewTabAlertPractice {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.hyrtutorials.com/p/window-handles-practice.html");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        String parentHandle = driver.getWindowHandle();
        System.out.println("Print the parentHandle: " + parentHandle);
        driver.findElement(By.id("newTabBtn")).click();
        Set<String> allHandles = driver.getWindowHandles();
        for(String handle :allHandles){
            if(!handle.equals(parentHandle)){
                driver.switchTo().window(handle);
                driver.manage().window().maximize();
                Thread.sleep(2000);
                driver.findElement(By.id("alertBox")).click();
                System.out.println("Alert button is clicked");
                driver.switchTo().alert().accept();
                System.out.println("Alert is accepted");
                Thread.sleep(1000);
                driver.close();
            }
        }
        driver.switchTo().window(parentHandle);
        driver.findElement(By.id("name")).sendKeys("Back to parent page successfully!!!");
System.out.println("Navigated back to parent page: " + driver.getTitle());
    }
}
