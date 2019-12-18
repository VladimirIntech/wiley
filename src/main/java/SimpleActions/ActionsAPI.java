package SimpleActions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static Driver.WebDR.*;

public abstract class ActionsAPI {




    public static void open(String url) {
     //   driver.navigate().to(url);
        getDriver().navigate().to(url);
    }

    public static WebElement find(String locator) {
        return new WebDriverWait(getDriver(), getTimeout()).until(ExpectedConditions.elementToBeClickable(By.xpath(locator))).findElement(By.xpath(locator));
        //getDriver().findElement(locator);
    }

    public static String getActualText(String locator) {
        //return find(locator).getText();
        return new WebDriverWait(getDriver(), getTimeout()).until(ExpectedConditions.elementToBeClickable(By.xpath(locator))).getText();
    }

    public static void actionsWith(String object) {
        new Actions(driver).moveToElement(find(object)).perform();
    }

    public static Boolean check(String objectCheck) {
        return new WebDriverWait(getDriver(), getTimeout()).until(ExpectedConditions.elementToBeClickable(By.xpath(objectCheck))).findElements(By.xpath(objectCheck)).size() > 0;

    }

    public static List<WebElement> List_find(String listObject) {
        return driver.findElements(By.xpath(listObject));
    }

    public static void Click (String objectClick) {
        new WebDriverWait(getDriver(), getTimeout()).until(ExpectedConditions.elementToBeClickable(By.xpath(objectClick))).click();
    }

    public void delay(long millisec) {
        try {
            Thread.sleep(millisec);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}
