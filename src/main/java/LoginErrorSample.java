import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.Keys;

public class LoginErrorSample {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/login");
        WebElement usernameFeild = driver.findElement(By.id("username"));
        usernameFeild.sendKeys("tomsmith");
        System.out.println("Is username is correct? " + usernameFeild);
        //For wrong password
        WebElement passwordFeild = driver.findElement(By.id("password"));
        passwordFeild.sendKeys("WrongPassword123");
        System.out.println("Is password correct? " + passwordFeild);
        //For Login
        WebElement loginButton = driver.findElement(By.className("radius"));
        loginButton.click();
        //For Error
        String errorText = driver.findElement(By.id("flash")).getText();
        if (errorText.contains("Your password is invalid")){
            System.out.println("Test PASSED: Correct error message displayed.");
        }
        else {
            System.out.println("Test FAILED:  error message was wrong.");
        }
        driver.quit();
    }
}
