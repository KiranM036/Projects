package Com.Newproject;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Alter_Shop_Webapplication {
    
    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeClass
    public void setUp() {
        
        System.setProperty("webdriver.chrome.driver", "D:\\Eclipse\\Eclipse workspace\\Amazon_Demo\\Drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(3000));
        driver.get("https://betashop.alter.game/"); 
        driver.manage().window().maximize();
    }

    @Test(priority = 1)
    public void testSearchAndFilter() throws InterruptedException {
        WebElement searchBox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("auto-suggestion-search")));
        searchBox.sendKeys("Pistol");

       
        WebElement category = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"categories-container\"]/ul/li[3]")));
        category.click();

      
        WebElement sortByDropdown = wait.until(ExpectedConditions.elementToBeClickable(By.id("price-sort-select")));
        sortByDropdown.click();

       
        WebElement priceHighToLow = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\":r0:\"]/li[2]")));
        priceHighToLow.click(); 
        
    }   
    
    @Test(priority = 2)
    public void Viewing_Asset_Details() throws InterruptedException {
        
    	
        WebElement asset = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"348\"]/div[2]")));
        asset.click();
        Thread.sleep(3000);
    }  
    
    
    @Test(priority = 3)
    public void Creator_profile_page_and_their_assets() throws InterruptedException {
    
    	Thread.sleep(3000);
    	 WebElement asset = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"__next\"]/div/div[1]/div[1]/div[2]/div/div[1]/button[1]/span")));
         asset.click();
         ((JavascriptExecutor) driver).executeScript("window.scrollBy(0, 250);");
        
         
         WebElement asset1 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"344\"]/div[2]/div[1]/div")));
         asset1.click();
         
         WebElement asset3 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"creator_profile\"]/span[2]/span[2]")));
         asset3.click();
         Thread.sleep(3000);
    }
    
    
    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
