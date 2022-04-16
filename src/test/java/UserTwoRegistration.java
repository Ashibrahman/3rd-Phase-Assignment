import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class UserTwoRegistration extends Driver_Setup {

    // Go to the URL http://automationpractice.com/index.php
    public static String baseURL = "http://automationpractice.com/index.php";

    @Test
    // Create Two Accounts
    public static void registration() throws InterruptedException {
        driver.get(baseURL);
        driver.manage().timeouts().implicitlyWait(90, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        Thread.sleep(1000);

        // CREATE AN ACCOUNT (Email address)
        driver.findElement(By.xpath("//div[contains(@class,'header_user_info')]")).click();
        driver.findElement(By.xpath("//input[contains(@id,'email_create')]")).sendKeys("soliman15-8572@diu.edu.bd");
        driver.findElement(By.xpath("//button[contains(@id,'SubmitCreate')]")).click();
        Thread.sleep(2000);

        // (First name, Last name, Password)
        driver.findElement(By.xpath("//input[contains(@id,'customer_firstname')]")).sendKeys("Soliman");
        driver.findElement(By.xpath("//input[contains(@id,'customer_lastname')]")).sendKeys("Ali");
        driver.findElement(By.xpath("//input[contains(@id,'passwd')]")).sendKeys("87654321");

        // YOUR ADDRESS (First name, Last name, Address, City)
        driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys("");
        driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("");
        driver.findElement(By.xpath("//input[contains(@id,'address1')]")).sendKeys("Naruli");
        driver.findElement(By.xpath("//input[contains(@id,'city')]")).sendKeys("Bogura");

        // State
        WebElement states = driver.findElement(By.id("id_state"));
        Select selectState = new Select(states);
        selectState.selectByIndex(5);

        // Zip/Postal Code
        driver.findElement(By.xpath("//input[contains(@id,'postcode')]")).sendKeys("00000");

        // Mobile phone
        driver.findElement(By.xpath("//input[contains(@id,'phone_mobile')]")).sendKeys("01706994692");

        // Assign an address alias for future reference
        driver.findElement(By.xpath("//input[contains(@id,'alias')]")).sendKeys("");

        // Register
        driver.findElement(By.xpath("//button[contains(@id,'submitAccount')]")).click();
        Thread.sleep(1000);

        // Log Out
        driver.findElement(By.xpath("//a[@href='http://automationpractice.com/index.php?mylogout']")).click();
        Thread.sleep(2000);
    }
}