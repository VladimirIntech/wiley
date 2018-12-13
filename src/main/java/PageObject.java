import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class PageObject extends WebDR {
    /*Описание элементов страницы*/
    public void BasePage() {
        if (getDriver().getCurrentUrl().contains("www.wiley.com")) {
            PageFactory.initElements(driver, this);
        } else {
            Assert.fail("Not base page");
        }
    }

    /*Описание элементов страницы главная*/
    private String resurses = "//a[text()='WHO WE SERVE']";
    private String subjects = "//a[text()='SUBJECTS']";
    private String about = "//a[text()='ABOUT']";
    private String resitems = "//div[@id='Level1NavNode1']//ul//li";
    private String Students = "//a[text()='Students']";
    /*Переменная страницы студенты заголовок*/
    private String TitleStudent = "//span[text()='Students']";
    private String WilleyPlus = "//a[@href='https://www.wileyplus.com/']";
    private String Education = "//a[@href='/en-ru/Education-c-ED00']";
    /*Переменные страницы Образование*/
    private String EducationTitle = "//span[text()='Education']";
    private String SubjectList = "//div[@class='side-panel']//ul//li";
    /*Переменная логотипа компании*/
    private String HomePage = "//header[@id='main-header-container']//..//img[@title='Wiley']";
    /*Переменная кнопки поиска*/
    private String SearchBtn = "//button[text()='Search']";
    /*Переменная Поля поиска*/
    private String SearchEntryField = "//div[@class='input-group']//input[@type='search']";
    /*Переменная найденных элементов поиска */
    private String TitleProducts = "//div[@class='products-list']//..//h3//a";
    /*Локатор кнопки AddToCart*/
    private String ButtonAddToCart = "//div[@class='search-result-page']//..//a[@class='small-button']//..//button[text()='Add to cart']";

    /*Методы возвращающие значения искомых элементов страницы*/
    public WebElement getResours() {
        return driver.findElement(By.xpath(resurses));
    }

    public WebElement getSubjects() {
        return driver.findElement(By.xpath(subjects));
    }

    public WebElement getAbout() {
        return driver.findElement(By.xpath(about));
    }

    public Boolean resCheck() {
        return driver.findElements(By.xpath(resurses)).size() > 0;

    }

    public Boolean subCheck() {
        return driver.findElements(By.xpath(subjects)).size() > 0;
    }

    public Boolean aboCheck() {
        return driver.findElements(By.xpath(about)).size() > 0;
    }

    public Boolean resItemsCheck() {
        return driver.findElements(By.xpath(resitems)).size() > 0;
        //div[@id='navigationNode_00000RS2']//div[1]
    }

    public List<WebElement> ResIm() {
        return driver.findElements(By.xpath(resitems));
    }

    public WebElement Students() {
        return driver.findElement(By.xpath(Students));
    }

    public WebElement TitleStudent() {
        return driver.findElement(By.xpath(TitleStudent));
    }

    public WebElement WilleyPlusm() {
        return driver.findElement(By.xpath(WilleyPlus));
    }

    public WebElement Education() {
        return driver.findElement(By.xpath(Education));
    }

    public WebElement EducationTitle() {
        return driver.findElement(By.xpath(EducationTitle));
    }

    public List<WebElement> SubList() {
        return driver.findElements(By.xpath(SubjectList));
    }

    public WebElement HomePage() {
        return driver.findElement(By.xpath(HomePage));
    }

    public WebElement SearchBtn() {
        return driver.findElement(By.xpath(SearchBtn));
    }

    public WebElement SearchEntryField() {
        return driver.findElement(By.xpath(SearchEntryField));
    }

    public List<WebElement> ProductTitle() {
        return driver.findElements(By.xpath(TitleProducts));
    }

    public List<WebElement> ButtonCard() {
        return driver.findElements(By.xpath(ButtonAddToCart));
    }

}
