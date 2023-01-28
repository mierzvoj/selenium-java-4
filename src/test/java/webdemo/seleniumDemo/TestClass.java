package test.java.webdemo.seleniumDemo;

import org.junit.Assert;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThan;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class TestClass {
    private static WebDriver driver;

    @BeforeAll
    public static void setUpDriver(){
        System.setProperty("webdriver.chrome.drive", System.getProperty("user.dir") + "resources/chromedriver");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @BeforeEach
    public void setUp() throws Exception {
        driver.get("https://www.browserstack.com/users/sign_in");
    }

    @AfterAll
    public static void tearDown() throws Exception {
        driver.quit();
    }

    @Test
    public void checkLogin() throws InterruptedException {
        WebElement username=driver.findElement(By.id("user_email_login"));
        WebElement password=driver.findElement(By.id("user_password"));
        username.sendKeys("mierzvoj@gmail.com");
        password.sendKeys("blabla");
        WebElement login=driver.findElement(By.name("commit"));
        login.click();
        String actualUrl="https://live.browserstack.com/dashboard#os=Windows&os_version=11&browser=Chrome&browser_version=109.0&zoom_to_fit=true&full_screen=true&url=www.browserstack.com%2Fwelcome&speed=1";
        String expectedUrl= driver.getCurrentUrl();
        Thread.sleep(1000);
        Assert.assertEquals(expectedUrl,actualUrl);

    }

}