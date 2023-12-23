import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class AutomationAnywhereTest {
   System.setProperty("webdriver.chrome.driver", "c:/Users/vharipriya/documents/chromedriver.exe");
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();

        driver.get("https://www.automationanywhere.com/");

        try {
            WebElement productsMenu = driver.findElement(By.xpath("//a[text()='Products']"));
            Actions actions = new Actions(driver);
            actions.moveToElement(productsMenu).perform();

            WebElement processDiscoveryLink = driver.findElement(By.xpath("//a[text()='Process Discovery']"));
            processDiscoveryLink.click();

            String expectedURL = "https://www.automationanywhere.com/products/process-discovery";
            String actualURL = driver.getCurrentUrl();

            if (actualURL.equals(expectedURL)) {
                System.out.println("Navigation to Process Discovery is successful.");
            } else {
                System.out.println("Navigation to Process Discovery failed.");
                System.out.println("Expected URL: " + expectedURL);
                System.out.println("Actual URL: " + actualURL);
            }

        } finally {
            // Close the browser window
            driver.quit();
        }
    }
}
