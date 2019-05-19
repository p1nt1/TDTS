package FunctionTesting;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class FunctionTest {

    public WebDriver driver;

    @BeforeMethod
    public void setupTest(){
        System.setProperty("webdriver.chrome.driver","D:\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://answear.ro");

        System.out.println("Page opened");
    }

    @Test
    public void LoginTest() throws InterruptedException {

        WebElement login= driver.findElement(By.xpath("//*[@id=\"panelLogin\"]"));
        login.click();
        String link= "https://answear.ro/profil/logine.html?returnTo=ww%3D%3D";
        Assert.assertEquals(driver.getCurrentUrl(),link,"Not on login page!");
        System.out.println("You are on the correct page");

        WebElement auth = driver.findElement(By.xpath("//*[@id=\"loginFormSubmit\"]"));
        auth.click();
        WebElement alertEmail =driver.findElement(By.xpath("//*[@id=\"realLoginForm\"]/div[1]/p"));
        WebElement alertPass = driver.findElement(By.xpath("//*[@id=\"realLoginForm\"]/div[2]/p"));

        Assert.assertTrue(alertEmail.isDisplayed());
        Assert.assertTrue(alertPass.isDisplayed());

        System.out.println("Alerts are displayed!");

        WebElement email= driver.findElement(By.xpath("//*[@id=\"l1\"]"));
        String inputemail = "sadsad@asdaddsa";

        email.sendKeys(inputemail);
        auth.click();
        WebElement alertEmail2 = driver.findElement(By.xpath("//*[@id=\"realLoginForm\"]/div[1]/p"));
        Assert.assertEquals(alertEmail2.getText(),"INTRODU ADRESA DE E-MAIL CORECTĂ");
        System.out.println("Alert for invalid email displayed!");
        Thread.sleep(1000);

        email.clear();
        inputemail = "alex.pintilie13@yahoo.com";
        String passw= " parolagresita";

        email.sendKeys(inputemail);
        WebElement password = driver.findElement(By.xpath("//*[@id=\"l2\"]"));
        password.sendKeys(passw);
        auth.click();
        Thread.sleep(1000);
        WebElement alert = driver.findElement(By.xpath("//*[@id=\"realLoginForm\"]/div[2]/p"));

        Assert.assertEquals(alert.getText(),"PAROLĂ INCORECTĂ");

        System.out.println("Alert for invalid password displayed!");

        WebElement forgetpass = driver.findElement(By.xpath("//*[@id=\"checkoutLogin\"]/div[1]/div[2]/a"));

        forgetpass.click();
        Assert.assertEquals(driver.getCurrentUrl(),"https://answear.ro/profil/am_uitat_parola.html");
        System.out.println("Forget password OK");


    }

    @AfterMethod
    public void teardownTest() throws InterruptedException {
        Thread.sleep(1000);
        driver.quit();
    }




}