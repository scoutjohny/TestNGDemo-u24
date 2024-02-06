import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;

public class TestNG {
    public WebDriver driver;
    String URL = "https://www.saucedemo.com/";

    @BeforeMethod
    @Parameters({"browser"})
    public void setup(String browser){
        if(browser.equals("Chrome")){
            System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver_121.exe");
            driver = new ChromeDriver();
        } else if (browser.equals("Firefox")){
            System.setProperty("webdriver.gecko.driver","src/main/resources/geckodriver0322.exe");
            driver = new FirefoxDriver();
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.get(URL);
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

    @Test
    @Parameters({"username","password","url","testType","errorMessage"})
    public void loginToSauceDemo(String username, String password, String url, String testType, @Optional String errorMessage){
        //logika ako username nije prazan
        if(!username.equals("empty")){
            driver.findElement(By.cssSelector("[id='user-name']")).sendKeys(username);
        }
        //logika ako password nije prazan
        if(!password.equals("empty")){
            driver.findElement(By.cssSelector("[id='password']")).sendKeys(password);
        }
        driver.findElement(By.cssSelector("[id='login-button']")).click();
        Assert.assertEquals(driver.getCurrentUrl(),url);
        if(testType.equals("negative")){
            Assert.assertEquals(driver.findElement(By.cssSelector("h3")).getText(),errorMessage);
        }
    }

//    @Test
//    public void loginToSauceDemoInvalidUserName(){
//        driver.findElement(By.cssSelector("[id='user-name']")).sendKeys("user");
//        driver.findElement(By.cssSelector("[id='password']")).sendKeys("secret_sauce");
//        driver.findElement(By.cssSelector("[id='login-button']")).click();
//
//        Assert.assertEquals(driver.getCurrentUrl(),"https://www.saucedemo.com/");
//        Assert.assertEquals(driver.findElement(By.cssSelector("h3")).getText(),"Epic sadface: Username and password do not match any user in this service");
//    }
//
//    @Test
//    public void loginToSauceDemoInvalidPassword(){
//        driver.findElement(By.cssSelector("[id='user-name']")).sendKeys("standard_user");
//        driver.findElement(By.cssSelector("[id='password']")).sendKeys("secret_sauce2");
//        driver.findElement(By.cssSelector("[id='login-button']")).click();
//
//        Assert.assertEquals(driver.getCurrentUrl(),"https://www.saucedemo.com/");
//        Assert.assertEquals(driver.findElement(By.cssSelector("h3")).getText(),"Epic sadface: Username and password do not match any user in this service");
//    }
//
//    @Test
//    public void loginToSauceDemoNoUsernameAndPassword(){
//        driver.findElement(By.cssSelector("[id='login-button']")).click();
//
//        Assert.assertEquals(driver.getCurrentUrl(),"https://www.saucedemo.com/");
//        Assert.assertEquals(driver.findElement(By.cssSelector("h3")).getText(),"Epic sadface: Username is required");
//    }

}
