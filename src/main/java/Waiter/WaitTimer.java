package Waiter;

import Driver.WebDR;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitTimer extends WebDR {
    private int timeout = 10;
 /*   @FindBy(xpath = "//div[@class='top-menu-item-settings']")
    private WebElement tmain;*/



    /*Описание неявного ожидания*/
    public void timer (int timeUnit){
        try {
            Thread.sleep(timeUnit * 1000);
        }
        catch (Exception e)
        {
            e.getMessage();
        }
    }
    public void ExpectedConditionsTimer () {
        for (int i = 0; i <10 ; i++) {
            WebDriverWait timeWait = new WebDriverWait(driver, timeout);
            if (timeWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@href='/copyright']"))).isEnabled()){


            }
            else {
                Assert.fail("No element");
            }
        }
    }
}
