import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class Driver_Setup {
    public static WebDriver driver;
    public static WebElement element;

    @BeforeSuite
    public static void setDriver() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", ".\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    @AfterSuite
    public static void close() {
        driver.close();
    }
}
