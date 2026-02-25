import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class webTableUsingXpath {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.w3schools.com/html/html_tables.asp");

        // Use XPath to find the company DIRECTLY based on the Country Name
        String Country = "UK";

        // This XPath looks for the row containing our Country and grabs the 1st column (Company)
        By companyLocator = By.xpath("//td[text()='" + Country + "']/preceding-sibling::td[2]");

        WebElement companyCell = driver.findElement(companyLocator);

        System.out.println(Country + " contains: " + companyCell.getText() + "company");

        driver.quit();
    }
}
