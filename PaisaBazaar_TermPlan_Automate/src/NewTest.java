import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;

public class NewTest {
	WebDriver driver = new ChromeDriver();
  @Test(priority = 1, description = "Search PaisaBazaar on Google.co.in")
  public void f() {
	  driver.findElement(By.name("q")).sendKeys("PaisaBazaar");
	  driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
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
	  driver.quit();
	  driver.close();
  }
}
