import org.testng.annotations.Test;

import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;
import ru.yandex.qatools.ashot.shooting.ShootingStrategy;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;

public class NewTest {
	WebDriver driver = new ChromeDriver();
  @Test(priority = 1, description = "Search PaisaBazaar on Google.co.in")
  public void a() {
	  driver.findElement(By.name("q")).sendKeys("PaisaBazaar");
	  driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
  }
  @Test(priority = 2, description = "Click on main link of PaisaBazaar")
  public void b() {
	  WebDriverWait waitLinkText = new WebDriverWait(driver, 10);
	  waitLinkText.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h3[text()='Paisabazaar.com: Compare & Apply for Loans & Credit Cards']"))).click();
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
  }
  @Test(priority = 3, description = "Take a full page screenshot", enabled = false)
  public void c() throws IOException {
	  Screenshot screenshot = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(1000)).takeScreenshot(driver);
	  ImageIO.write(screenshot.getImage(), "JPEG", new File("F:\\Study\\Screenshots\\PaisaBazaar\\paisaBazaarHomePage.jpeg"));
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
  }
  @Test(priority = 4, description = "Scroll up and click on All Product >> Health Insurance")
  public void d() throws InterruptedException, IOException {
	  JavascriptExecutor js = (JavascriptExecutor) driver;
	  js.executeScript("window.scrollBy(1000,0)");
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  //Clicking on All products
	  WebElement allProducts = driver.findElement(By.linkText("All Products"));
	  Actions action = new Actions(driver);
	  action.moveToElement(allProducts).build().perform();
	  WebElement healthInsurance = driver.findElement(By.xpath("//a[@href='https://www.paisabazaar.com/health-insurance/']"));
	  Actions action1 = new Actions(driver);
	  action1.moveToElement(healthInsurance).click().build().perform();
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  File screenshot1 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	  FileUtils.copyFile(screenshot1, new File("F:\\Study\\Screenshots\\PaisaBazaar\\HealthInsurancePage.jpeg"));
	  
	  
  }
  @BeforeClass
  public void beforeClass() {
	  System.setProperty("webdriver.chrome.driver", "F:\\Study\\chromedriver_win32 (90)\\chromedriver.exe");
	  driver.navigate().to("https://www.google.co.in/");
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
  }
  @BeforeTest
  public void BeforeTest() {
	  ChromeOptions options = new ChromeOptions();
	  String userAgent = "Mozilla/5.0 (Windows NT 6.1; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/91.0.4472.114 Safari/537.36";
	  options.addArguments(String.format("user-agent=%s", userAgent));
  }
  @AfterClass
  public void afterClass() {
	 driver.close();
	 driver.quit();
  }
}
