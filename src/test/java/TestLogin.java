import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.annotations.Test;


public class TestLogin {

    public WebDriver driver;

    @BeforeMethod
    public void setupTest() {
        System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://answear.ro");

        System.out.println("Page opened");
    }

    @Test(priority = 1)
    public void invalidLogin() {

        WebElement login = driver.findElement(By.xpath("//*[@id=\"panelLogin\"]"));
        String password = "1234";
        String email = "alex.pintilie13@yahoo.com";

        login.click();
        System.out.println("Login clicked");

        WebElement email1 = driver.findElement(By.xpath("//*[@id=\"l1\"]"));
        WebElement pass = driver.findElement(By.xpath("//*[@id=\"l2\"]"));

        email1.sendKeys(email);
        pass.sendKeys(password);
        pass.sendKeys(Keys.RETURN);


        WebElement message = driver.findElement(By.xpath("//*[@id=\"messages\"]/dl/dd\n"));
        Assert.assertTrue(message.isDisplayed());

        System.out.println("Invalid login !");


    }

    @Test(priority = 1)
    public void LoginTest() {
        WebElement login = driver.findElement(By.xpath("//*[@id=\"panelLogin\"]"));
        String password = "XyxJW3bT";
        String email = "alex.pintilie13@yahoo.com";

        login.click();
        System.out.println("Login clicked");

        WebElement email1 = driver.findElement(By.xpath("//*[@id=\"l1\"]"));
        WebElement pass = driver.findElement(By.xpath("//*[@id=\"l2\"]"));

        email1.sendKeys(email);
        pass.sendKeys(password);
        pass.sendKeys(Keys.RETURN);

        WebElement account = driver.findElement(By.xpath("//*[@id=\"panelAccount\"]"));
        WebElement alert = driver.findElement(By.xpath("//*[@id=\"messages\"]"));
        WebElement message = driver.findElement(By.xpath("//*[@id=\"messages\"]/dl/dd"));

        Assert.assertTrue(account.isDisplayed());
        Assert.assertTrue(alert.isDisplayed());
        Assert.assertEquals(message.getText(), "SUNTEŢI CONECTAT.");

        System.out.println("Login validated!");

    }


    @AfterMethod
    public void teardownTest() throws InterruptedException {
        Thread.sleep(1000);
        driver.quit();
    }
}
