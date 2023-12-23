import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AutomationAnywhereTestNG {

    private WebDriver driver;

    @BeforeTest
    public void setUp() {
        
           System.setProperty("webdriver.chrome.driver", "c:/Users/vharipriya/documents/chromedriver.exe");
        
        driver = new ChromeDriver();
        
        driver.get("https://www.automationanywhere.com/");
    }

    @Test(priority = 1)
    public void testProductsNavigation() {
        WebElement productsMenu = driver.findElement(By.xpath("//a[text()='Products']"));
        Actions actions = new Actions(driver);
        actions.moveToElement(productsMenu).perform();

        WebElement processDiscoveryLink = driver.findElement(By.xpath("//a[text()='Process Discovery']"));
        processDiscoveryLink.click();

        String expectedURL = "https://www.automationanywhere.com/products/process-discovery";
        String actualURL = driver.getCurrentUrl();
        Assert.assertEquals(actualURL, expectedURL, "Navigation to Process Discovery failed.");
    }

    @Test(priority = 2)
    public void testRequestDemoNavigation() {
         WebElement requestDemoButton = driver.findElement(By.xpath("//a[@title='Request demo']"));
        requestDemoButton.click();

        String expectedURL = "https://www.automationanywhere.com/request-live-demo";
        String actualURL = driver.getCurrentUrl();
        Assert.assertEquals(actualURL, expectedURL, "Navigation to Request Demo page failed.");

            WebElement firstNameLabel = driver.findElement(By.xpath("//input[@id='FirstName']"));
            WebElement lastNameLabel = driver.findElement(By.xpath("//input[@id='LastName']"));
			
        Assert.assertEquals(firstNameLabel.getText(), "First Name", "Incorrect First Name label");
        Assert.assertEquals(lastNameLabel.getText(), "Last Name", "Incorrect Last Name label");
    }

    @AfterTest
    public void tearDown() {

        driver.quit();
    }
}
