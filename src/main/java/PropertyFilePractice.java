import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
public class PropertyFilePractice {
    public static void main(String[] args) throws IOException {
        Properties prop = new Properties ();
        //open the file in reader mode
        FileInputStream fis = new FileInputStream("src/main/resources/config.properties");
        //load the file
        prop.load(fis);
        //Read the data
        String appUrl = prop.getProperty("url");
        String username = prop.getProperty("username");
        String password = prop.getProperty("password");
        WebDriver driver = new ChromeDriver();
        driver.get(appUrl);
        System.out.println("Navigated to: " + appUrl + " using user: " + username);
    }
}
