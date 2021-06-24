import org.testng.annotations.Test;

import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;
import ru.yandex.qatools.ashot.shooting.ShootingStrategy;

import org.testng.annotations.BeforeClass;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;

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
  @Test(priority = 3, description = "Take a full page screenshot")
  public void c() throws IOException {
	  Screenshot screenshot = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(1000)).takeScreenshot(driver);
	  ImageIO.write(screenshot.getImage(), "JPEG", new File("F:\\Study\\Screenshots\\PaisaBazaar\\paisaBazaarHomePage.jpeg"));
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
