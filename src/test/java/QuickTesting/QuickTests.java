package QuickTesting;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class QuickTests {

    public WebDriver driver;


    @BeforeTest
    public void setupTest(){
        System.setProperty("webdriver.chrome.driver","D:\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://answear.ro");

        System.out.println("Page opened");
    }

    @Test
    public void femei(){
        WebElement button = driver.findElement(By.xpath("//*[@id=\"viewsHome\"]/div/div/div[1]"));
        button.click();
        Assert.assertEquals(driver.getCurrentUrl(),"https://answear.ro/p/femei-4-k.html");
        System.out.println("Femei category button ok!");
    }

    @Test
    public void barbati(){
        WebElement button = driver.findElement(By.xpath("//*[@id=\"viewsHome\"]/div/div/div[2]"));
        button.click();
        Assert.assertEquals(driver.getCurrentUrl(),"https://answear.ro/p/barbati-89-k.html");
        System.out.println("Barbati category button ok!");

    }
    @Test
    public void copii(){
        WebElement button = driver.findElement(By.xpath("//*[@id=\"viewsHome\"]/div/div/div[3]"));
        button.click();
        Assert.assertEquals(driver.getCurrentUrl(),"https://answear.ro/p/copii.html");
        System.out.println("Copii category button ok!");

    }
    @Test
    public void wishlist(){
        WebElement button = driver.findElement(By.xpath("//*[@id=\"panelSave\"]/a"));
        button.click();
        Assert.assertEquals(driver.getCurrentUrl(),"https://answear.ro/produse-preferate.html");
        System.out.println("Wishlist button ok!");

    }

    @Test
    public void cart(){
        WebElement button = driver.findElement(By.xpath("    //*[@id=\"panelCart\"]\n"));
        button.click();
        Assert.assertEquals(driver.getCurrentUrl(),"https://answear.ro/lista-cos-1.html");
        System.out.println("Cart button ok!");

    }



    @AfterMethod
    public void getBack() throws InterruptedException {
        driver.get("https://answear.ro");
        Thread.sleep(1000);

    }

    @AfterTest
    public void teardownTest() throws InterruptedException {
        Thread.sleep(1000);
        driver.quit();
    }
}