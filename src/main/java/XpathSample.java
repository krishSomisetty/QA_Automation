import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebDriver;

public class XpathSample {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/add_remove_elements/");
        WebElement AddElement = driver.findElement(By.xpath("//button[text()='Add Element']"));
        for (int i=0; i<3; i++) {
            AddElement.click();
            try { Thread.sleep(500); } catch (Exception e) {}
        }
        WebElement SecondDelete = driver.findElement(By.xpath("(//button[text()='Delete'])[2]"));
        SecondDelete.click();
        System.out.println("Clicked the 2nd Delete button successfully!");
        try { Thread.sleep(2000); } catch (Exception e) {}
        driver.quit();
    }

}
