import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
public class findUsingCSSselector {
    public static void main(String[] args){
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
        WebElement username = driver.findElement(By.cssSelector("#user-name"));
        username.sendKeys("standard_user");
        WebElement password = driver.findElement(By.cssSelector("#password"));
        password.sendKeys("secret_sauce");
        WebElement login = driver.findElement(By.cssSelector("#login-button"));
        login.click();
        System.out.println("Login using css selector is successful");
    }
}
