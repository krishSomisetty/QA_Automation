import java.util.List;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
public class advancedWebTablePractice {
    public static void main(String[] args){
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.w3schools.com/html/html_tables.asp");
        // 1. Find the table
        WebElement myTable = driver.findElement(By.id("customers"));
        // 2. Count the Rows
        List<WebElement> rows = myTable.findElements(By.tagName("tr"));
        System.out.println("Total rows: " + rows.size());
        for(WebElement row : rows){
            List<WebElement> cells = row.findElements(By.tagName("td"));
          if(!cells.isEmpty()){
              String CompanyName = cells.get(0).getText();
              System.out.println("Companies: " + CompanyName);
              if(CompanyName.equals("Island Trading")){
                  String country = cells.get(2).getText();
                  System.out.println("Match Found!");
                  System.out.println("Company: " + CompanyName + " | Country: " + country);
              }
          }
        }
    }
}
