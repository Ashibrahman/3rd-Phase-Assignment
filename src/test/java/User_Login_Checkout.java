import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class User_Login_Checkout extends Driver_Setup {

    // Go to the URL http://automationpractice.com/index.php
    public static String baseURL = "http://automationpractice.com/index.php";

    @Test
    public static void userLoginAndCheckout() throws InterruptedException {

        driver.get(baseURL);
        driver.manage().timeouts().implicitlyWait(90, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        Thread.sleep(1000);

        //ALREADY REGISTERED
        driver.findElement(By.xpath("//a[normalize-space()='Sign in']")).click();
        driver.findElement(By.xpath("//input[@id='email']")).sendKeys("ashikur15-8763@diu.edu.bd");
        driver.findElement(By.xpath("//input[@id='passwd']")).sendKeys("12345678");
        driver.findElement(By.xpath("//span[normalize-space()='Sign in']")).click();
        Thread.sleep(2000);

        // User Validation
        String actualName = "Ashibur Rahman";
        String username = driver.findElement(By.xpath("//a[contains(@class,'account')]")).getText();

        if (username.equalsIgnoreCase(actualName)) {
            System.out.println(username + " Name is Validate");
        }

        // Dresses To Casual Dresses
        Actions action = new Actions(driver);
        action.clickAndHold(driver.findElement(By.xpath("//body/div[@id='page']/div[@class='header-container']/header[@id='header']/div/div[@class='container']/div[@class='row']/div[@id='block_top_menu']/ul[@class='sf-menu clearfix menu-content sf-js-enabled sf-arrows']/li[2]/a[1]"))).build().perform();
        driver.findElement(By.xpath("//li[@class='sfHover']//a[@title='Casual Dresses'][normalize-space()='Casual Dresses']")).click();
        Thread.sleep(1000);

        // Add to Cart
        WebElement element = driver.findElement(By.xpath("//span[normalize-space()='Add to cart']"));
        JavascriptExecutor jse_01 = (JavascriptExecutor)driver;
        jse_01.executeScript("arguments[0].click()", element);

        driver.findElement(By.xpath("//span[@title='Continue shopping']//span[1]")).click();
        Thread.sleep(1000);

        // Go To The T-shirts Section
        driver.findElement(By.xpath("(//a[@title='T-shirts'][normalize-space()='T-shirts'])[2]")).click();
        Thread.sleep(1000);

        // Filter Blue Color
        WebElement filter_blue = driver.findElement(By.xpath("//span[normalize-space()='More']"));
        JavascriptExecutor jse_03 = (JavascriptExecutor)driver;
        jse_03.executeScript("arguments[0].click()", filter_blue);

        driver.findElement(By.xpath("//a[@id='color_14']")).click();

        // Add to Cart Filter List
        WebElement cart_filter = driver.findElement(By.xpath("//span[normalize-space()='Add to cart']"));
        JavascriptExecutor jse_02 = (JavascriptExecutor)driver;
        jse_02.executeScript("arguments[0].click()", cart_filter);

        driver.findElement(By.xpath("//span[normalize-space()='Proceed to checkout']")).click();
        Thread.sleep(3000);

        // Proceed To Checkout
        driver.findElement(By.xpath("(//span[contains(text(),'Proceed to checkout')])[2]")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("(//span[contains(text(),'Proceed to checkout')])[2]")).click();
        Thread.sleep(1000);

        // Terms of service
        WebElement checkCondition = driver.findElement(By.id("cgv"));
        checkCondition.click();

        driver.findElement(By.xpath("(//span[contains(text(),'Proceed to checkout')])[2]")).click();
        Thread.sleep(1000);

        // Pay Bay Check
        driver.findElement(By.xpath("//a[@title='Pay by check.']")).click();
        Thread.sleep(1000);

        driver.findElement(By.xpath("//span[normalize-space()='I confirm my order']")).click();
        Thread.sleep(2000);

        String orderActual = "Order confirmation";
        String orderConfirm = driver.findElement(By.xpath("//h1[normalize-space()='Order confirmation']")).getText();
        if (orderActual.equalsIgnoreCase(orderConfirm))
        {
            System.out.println("ORDER CONFIRMATION is Validate");
        }

        // Log Out
        driver.findElement(By.xpath("//a[@href='http://automationpractice.com/index.php?mylogout']")).click();
        Thread.sleep(2000);
    }
}