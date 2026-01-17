import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GoogleSearch {
    public static void main(String[] args) {

        // 1. Setup
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/login");

        // 2. LOCATING THE ELEMENT
        // We are telling Selenium: "Find the element on the page where the 'name' attribute equals 'q'"
        // (If you inspect Google's search box, you will see <textarea name="q" ...>)
        //For Username
        WebElement usernameFeild = driver.findElement(By.id("username"));
        // 3. ACTION: Typing
        usernameFeild.sendKeys("tomsmith");
        //For password
        WebElement passwordFeild = driver.findElement(By.id("password"));
        // 3. ACTION: Typing
        passwordFeild.sendKeys("SuperSecretPassword!");
        //For Login
        WebElement loginButton = driver.findElement(By.className("radius"));
        loginButton.click();

        // 4. ACTION: Pressing Enter
        //usernameFeild.sendKeys(Keys.ENTER);

        // 5. Verification
        System.out.println("Title is now: " + driver.getTitle());

        // Optional: Close the browser after 5 seconds so you can see what happened
        try { Thread.sleep(5000); } catch (InterruptedException e) { e.printStackTrace(); }
        driver.quit();
    }
}