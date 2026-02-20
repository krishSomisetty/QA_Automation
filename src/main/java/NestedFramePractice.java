import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class NestedFramePractice {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://www.hyrtutorials.com/p/frames-practice.html");


        // Step-1. THE SWITCH: Move into Frame 1
        driver.switchTo().frame("frm1");
        // Step-2 ACTION INSIDE: select an option in dropdown which is inside the frame
        WebElement dropdown = driver.findElement(By.id("selectnav2"));
        Select selector = new Select(dropdown);
        selector.selectByVisibleText("Contact");
        System.out.println("Step 2: Successfully interacted INSIDE the frame1.");

        // Step-3. THE JUMP OUT: Go back to the main page
        driver.switchTo().defaultContent();

        // Step-4. ACTION OUTSIDE: Clear the first text box to prove we are back
        driver.switchTo().frame("frm2");
         driver.findElement(By.id("firstName")).sendKeys("Krishna");
        driver.findElement(By.id("lastName")).sendKeys("Somisetty");
        System.out.println("Step 4: Successfully interacted INSIDE the frame2.");
        driver.switchTo().defaultContent();

        // driver.quit();
    }
}