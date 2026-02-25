import java.util.List;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class WebTablePractice {
    public static void main(String[] args){
        WebDriver driver= new ChromeDriver();
        driver.get("https://www.w3schools.com/html/html_tables.asp");
        WebElement table = driver.findElement(By.id("customers"));
        List<WebElement>rows = table.findElements(By.tagName("tr"));
        System.out.println("Total rows: " +rows.size());
        for(WebElement row :rows){
            List<WebElement>cells = row.findElements(By.tagName("td"));
            for(WebElement cell : cells){
                System.out.println(cell.getText() + " | ");
            }
            System.out.println();
        }
        driver.quit();
    }
}
