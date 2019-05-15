import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddToCartTest {

    public WebDriver driver;

    @BeforeMethod
    public void setupTest(){
        System.setProperty("webdriver.chrome.driver","D:\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://answear.ro");

        System.out.println("Page opened");
    }

    @Test(priority = 3)
    public void addToCart() throws InterruptedException {

        WebElement search = driver.findElement(By.xpath("//*[@id=\"panelSearch\"]"));
        search.click();
        Thread.sleep(1000);

        WebElement searchForm = driver.findElement(By.xpath("//*[@id=\"searchInput\"]"));
        searchForm.sendKeys("Tommy Hilfiger");
        searchForm.sendKeys(Keys.ENTER);

        Thread.sleep(1000);

        WebElement barbati = driver.findElement(By.xpath("//*[@id=\"filters\"]/section[1]/div/div/ol/li[2]/h3/a"));
        barbati.click();
        Thread.sleep(1000);

        WebElement tricou = driver.findElement(By.xpath("//*[@id=\"filters\"]/section[2]/div/div/ul/li[2]/label/h3"));
        tricou.click();
        Thread.sleep(1000);

        System.out.println("Filtered");

        WebElement sort = driver.findElement(By.xpath("//*[@id=\"sort1\"]"));
        sort.click();
        Thread.sleep(1000);

        WebElement scumpe = driver.findElement(By.xpath("//*[@id=\"sort1\"]/option[3]"));
        scumpe.click();

        System.out.println("Sorted");

        WebElement camasa = driver.findElement(By.xpath("//*[@id=\"grid\"]/div[2]/div/a[2]/div/div/img"));
        camasa.click();

        System.out.println("Shirt selected");

        String linkCamasa = "https://answear.ro/1697776-tommy-hilfiger-camasa.html";

        WebElement selectSize =driver.findElement(By.xpath("//*[@id=\"selectSize\"]"));
        selectSize.click();


        WebElement Lsize = driver.findElement(By.xpath("//*[@id=\"selectSize\"]/option[4]"));
        Lsize.click();

        System.out.println("L size selected");


        WebElement addToCart =driver.findElement(By.xpath("//*[@id=\"cartaddButton\"]"));
        addToCart.click();

        System.out.println("Added to cart");

        Thread.sleep(1000);

        WebElement cart = driver.findElement(By.xpath("//*[@id=\"miniBtns\"]/a[1]"));
        cart.click();

        WebElement rowValidate =driver.findElement(By.xpath("//*[@id=\"basket\"]/div[2]"));

        Assert.assertTrue(rowValidate.isDisplayed());

        WebElement link = driver.findElement(By.xpath("//*[@id=\"basket\"]/div[2]/div[1]/div/div/a[2]"));

        Assert.assertEquals(linkCamasa,link.getAttribute("href"),"Different item in cart");

        System.out.println("Valid add to cart");


    }

    @Test(priority = 3)
    public void invalidAddToCart() throws InterruptedException {

        WebElement search = driver.findElement(By.xpath("//*[@id=\"panelSearch\"]"));
        search.click();
        Thread.sleep(1000);

        WebElement searchForm = driver.findElement(By.xpath("//*[@id=\"searchInput\"]"));
        searchForm.sendKeys("Adidas superstar");
        searchForm.sendKeys(Keys.ENTER);
        Thread.sleep(1000);

        WebElement item = driver.findElement(By.xpath("//*[@id=\"grid\"]/div[1]/div/a[2]/div/div/img"));
        item.click();
        Thread.sleep(1000);

        WebElement add =driver.findElement(By.xpath("//*[@id=\"cartaddButton\"]"));
        add.click();

        WebElement alert =driver.findElement(By.xpath("//*[@id=\"productAction\"]/div[1]/div[1]"));
        Assert.assertTrue(alert.isDisplayed());

        System.out.println("Invalid add to cart ");




    }





    @AfterMethod
    public void teardownTest() throws InterruptedException {
        Thread.sleep(1000);
        driver.quit();
    }
}