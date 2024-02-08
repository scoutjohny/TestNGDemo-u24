import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class Elements {

    public WebDriver driver;
    String URL = "https://demoqa.com/text-box";

    @BeforeMethod
    public void setup(){
        System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver_121.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.get(URL);
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

    @Test
    public void demoQaTesting(){
//        //Polja za unos i klik na dugme:
//        driver.findElement(By.cssSelector("[type='text']")).sendKeys("Petar I Petrovic");
//        driver.findElement(By.id("userEmail")).sendKeys("gorskivijenac@cetinje.com");
//        driver.findElement(By.cssSelector("#currentAddress")).sendKeys("Neznanog junaka BB");
//        driver.findElement(By.cssSelector("#permanentAddress")).sendKeys("Njegošev mauzolej na Lovćen");
//        driver.findElement(By.cssSelector("#submit")).click();
//
//        //Checkbox
//        driver.findElement(By.xpath("//*[contains(text(),'Check Box')]")).click();
//        driver.findElement(By.cssSelector(".rct-collapse.rct-collapse-btn")).click();
//        driver.findElement(By.cssSelector("ol ol>li>span>button")).click();
//        //logika za proveru da li je checkbox obeležen i onda ga obeležava ako nije
//        if(!driver.findElement(By.cssSelector("ol ol>li>ol>li:nth-child(2) .rct-checkbox")).isSelected()) {
//            driver.findElement(By.xpath("(//*[contains(text(),'Comm')]/../span)[1]")).click();
////            driver.findElement(By.xpath("(//*[@class='rct-checkbox'])[4]")).click();
//            Assert.assertEquals(driver.findElement(By.cssSelector(".text-success")).getText(),"commands");
//        }
//
//        //Radio button je suštinski isto što i checkbox pa se i na isti način testira
//        driver.findElement(By.xpath("//*[contains(text(),'Radio Button')]")).click();
//        driver.findElement(By.cssSelector("#yesRadio")).click();
//        Assert.assertEquals(driver.findElement(By.cssSelector(".text-success")).getText(),"Yes");

//        //Padajući meni (select)
//        driver.get("https://demoqa.com/select-menu");
//        Select oldSelectMenu = new Select(driver.findElement(By.cssSelector("#oldSelectMenu")));
//        oldSelectMenu.selectByValue("1");
//        Assert.assertTrue(driver.findElement(By.xpath("//*[contains(text(),'Blue')]")).isDisplayed());

//        //Novi tab i prebacivanje na njega
//
//        // otvaranje novog taba preko javaScript executor-a
//
//        JavascriptExecutor js=(JavascriptExecutor) driver;
//        js.executeScript("window.open()"); //ovo otvara novi tab
//
//        //ako hoćemo da zapamtimo na kom smo tabu bili:
//        String currentWindowHandle = driver.getWindowHandle();
//
//        //pravljenje liste svih otvorenih tabova:
//        List <String> windowHandles = new ArrayList<String>(driver.getWindowHandles());
//
//        //prebacivanje na određeni tab:
//        driver.switchTo().window(windowHandles.get(0));
//
//        driver.get("https://www.google.rs");
//        Assert.assertEquals(driver.getCurrentUrl(),"https://www.google.rs/");
//        driver.close(); //gasi trenutno aktivni tab!!!

//        //Alert
//        driver.get("https://demoqa.com/alerts");
//        //Alert samo sa OK dugmetom:
//        driver.findElement(By.cssSelector("#alertButton")).click();
//        System.out.println(driver.switchTo().alert().getText());
//        driver.switchTo().alert().accept();
//
//        //Alert sa textbox-om
//        driver.findElement(By.cssSelector("#promtButton")).click();
//        driver.switchTo().alert().sendKeys("Legenda!");
//        driver.switchTo().alert().accept();
//        Assert.assertEquals(driver.findElement(By.cssSelector("#promptResult")).getText(),"You entered Legenda!");
//
//        //Alert sa dugmetom za potvrdu i otkazivanje
//        driver.findElement(By.cssSelector("#confirmButton")).click();
//        driver.switchTo().alert().dismiss();
//        Assert.assertEquals(driver.findElement(By.cssSelector("#confirmResult")).getText(),"You selected Cancel");

//        //Modali - zahtevaju da se ODMAH njima posvetimo jer prekrivaju celu stranicu i sve elemente na njoj!
//        driver.get("https://demoqa.com/modal-dialogs");
//        driver.findElement(By.cssSelector("#showSmallModal")).click();
//        driver.findElement(By.cssSelector(".modal-body")).getText().equals("This is a small modal. It has very less content");
//        driver.findElement(By.cssSelector("#closeSmallModal")).click();
//        Assert.assertTrue(driver.findElement(By.cssSelector("#showLargeModal")).isDisplayed());

        //iFrame - sajt unutar već postojećeg sajta
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");

        //prvo hvatamo broj iFrame-ova - nije obavezan ako imamo samo jedan
        int size = driver.findElements(By.tagName("iframe")).size();

        //prebacivanje na iFrame pomoću indeksa:
        driver.switchTo().frame(0); //ili driver.switchTo().frame(1);

        //prebacivanje na iFrame pomoću imena ili id-a:
        driver.switchTo().frame("iframe-name"); // ili driver.switchTo().frame("courses-iframe");

        //prebacivanje na iFrame pomoću elementa koji se nalazi u njemu:
        driver.switchTo().frame(driver.findElement(By.cssSelector(".login-btn")));

        //vraćanje sa iFrame-a na roditeljsku stranicu:
        driver.switchTo().parentFrame();

        //vraćanje na glavnu stranicu:
        driver.switchTo().defaultContent();
    }




}
