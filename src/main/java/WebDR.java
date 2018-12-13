import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class WebDR {
    /*Подключнеие webDriver*/
    public static WebDriver driver;
    private static int timeout = 10;

    public static int getTimeout() {
        return timeout;
    }

    public static WebDriver getDriver() {
        return driver;
    }
    @BeforeClass
    public static void setUp(){
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(timeout, TimeUnit.SECONDS);
        driver.manage().window().maximize();

            }

@AfterClass
public static void CloseDR(){
      if (driver != null)
       driver.quit();

}
}
