import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SearchTest {

    public WebDriver driver;

    @BeforeMethod
    public void setupTest(){
        System.setProperty("webdriver.chrome.driver","D:\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://answear.ro");

        System.out.println("Page opened");
    }

    @Test(priority = 2)
    public void searchTest() throws InterruptedException {

        WebElement search = driver.findElement(By.xpath("//*[@id=\"panelSearch\"]"));
        search.click();
        Thread.sleep(1000);

        WebElement searchForm = driver.findElement(By.xpath("//*[@id=\"searchInput\"]"));
        searchForm.sendKeys("Nike air force 1");
        System.out.println("Searching for nike air force 1");
        searchForm.sendKeys(Keys.ENTER);

        WebElement barbati = driver.findElement(By.xpath("//*[@id=\"filters\"]/section[1]/div/div/ol/li[2]/h3/a"));
        barbati.click();
        Thread.sleep(1000);

        WebElement sort = driver.findElement(By.xpath("//*[@id=\"sort1\"]"));
        sort.click();
        Thread.sleep(1000);

        WebElement scumpe = driver.findElement(By.xpath("//*[@id=\"sort1\"]/option[3]"));
        scumpe.click();
        Thread.sleep(1000);

        WebElement nike = driver.findElement(By.xpath("//*[@id=\"grid\"]/div[1]/div/a[2]/div/div/img"));
        nike.click();
        Thread.sleep(1000);

        WebElement title = driver.findElement(By.xpath("//*[@id=\"productPanel\"]/div/h2"));

        Assert.assertEquals(title.getText(),"NIKE SPORTSWEAR - PANTOFI AIR FORCE 1 UTILITY MID");

        System.out.println("Sneakers have been found");

        System.out.println("Valid search!");


    }

    @Test(priority = 2)
    public void invalidSearch() throws InterruptedException {
        WebElement search = driver.findElement(By.xpath("//*[@id=\"panelSearch\"]"));
        search.click();
        Thread.sleep(1000);

        WebElement searchForm = driver.findElement(By.xpath("//*[@id=\"searchInput\"]"));
        searchForm.sendKeys("sadsadasdasdsadsadsa");
        searchForm.sendKeys(Keys.ENTER);

        WebElement message = driver.findElement(By.xpath("//*[@id=\"messages\"]/dl"));
        Assert.assertEquals(message.getText(),"NU AM GĂSIT CEEA CE AI CĂUTAT, DAR POATE VEI FI INTERESAT DE ALTE PRODUSE SIMILARE DIN GAMA NOASTRĂ");

        System.out.println("Invalid search!");
    }





    @AfterMethod
    public void teardownTest() throws InterruptedException {
        Thread.sleep(1000);
        driver.quit();
    }
}