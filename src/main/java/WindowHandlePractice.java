import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.Set;

public class WindowHandlePractice {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://www.hyrtutorials.com/p/window-handles-practice.html");

        // 1. Save the "Address" of the main page
        String parentHandle = driver.getWindowHandle();
        System.out.println("Parent Window ID: " + parentHandle);

        // 2. Click button to open a NEW TAB
        driver.findElement(By.id("newTabBtn")).click();

        // 3. Get ALL open window IDs (Parent + Child)
        Set<String> allHandles = driver.getWindowHandles();

        // 4. The Switch Logic: Loop through handles and find the one that isn't Parent
        for (String handle : allHandles) {
            if (!handle.equals(parentHandle)) {
                // ... (inside the for-loop after the switch)
                driver.switchTo().window(handle);
                System.out.println("Switched to Child Window ID: " + handle);
                String childTitle = driver.getTitle();
                System.out.println("Child Window Title is: " + childTitle);

                if (childTitle.contains("H Y R Tutorials")) {
                    System.out.println("Confirmed: We are on the Home Page tab!");
                    // You could try interacting with a home page element here
                }

                driver.close();
                System.out.println("Child tab closed.");
            }
        }

        // 6. CRITICAL: Switch back to parent to continue
        driver.switchTo().window(parentHandle);
        driver.findElement(By.id("name")).sendKeys("Back in Parent!");

        System.out.println("Final Title: " + driver.getTitle());
    }
}