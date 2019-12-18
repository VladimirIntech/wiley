package Driver;

import SimpleActions.ActionsAPI;
import org.apache.logging.log4j.Level;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import static PropertyParser.PropertyReader.*;
import static Logger.LogReader.*;

public class WebDR extends ActionsAPI {
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

    public static void setUp() {
        try {
            System.setProperty(getPropertyReader("driverName"), getPropertyReader("webDriverEnvironment"));
            driver = new ChromeDriver();
            driver.manage().timeouts().implicitlyWait(getTimeout(), TimeUnit.SECONDS);
            driver.manage().window().maximize();
            getLog().log(Level.INFO, "Драйвер запущен", getDriver().getPageSource());
        } catch (Exception exDriver) {
            getLog().log(Level.ERROR, "Драйвер не запущен");
        }
    }


    @AfterClass
    public static void CloseDR() {
        if (driver != null)
            driver.quit();
        getLog().log(Level.INFO, "Драйвер остановлен");

    }
}
