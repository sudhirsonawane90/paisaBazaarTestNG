import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
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
  @BeforeClass
  public void beforeClass() {
	  System.setProperty("webdriver.chrome.driver", "F:\\Study\\chromedriver_win32 (90)\\chromedriver.exe");
	  driver.navigate().to("https://www.google.co.in/");
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
  }

  @AfterClass
  public void afterClass() {
	 driver.close();
	 driver.quit();
  }
}
