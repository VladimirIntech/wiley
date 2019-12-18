package PageInfo;

import Driver.WebDR;
import org.junit.Assert;
import org.openqa.selenium.support.PageFactory;

public class ObgectPage extends WebDR {
    /*Описание элементов страницы*/
    public void BasePage() {
        if (getDriver().getCurrentUrl().contains("www.wiley.com")) {
            PageFactory.initElements(driver, this);
        } else {
            Assert.fail("Not base page");
        }
    }

    /*Описание элементов страницы главная*/
    private static String resurses = "//a[contains(text(),'WHO WE SERVE')]";
    private static String subjects = "//a[contains(text(),'SUBJECTS')]";
    private static String about = "//a[contains(text(),'ABOUT')]";
    private static String resitems = "//div[@id='Level1NavNode1']//ul//li";
    private static String Students = "//a[text()='Students']";
    /*Переменная страницы студенты заголовок*/
    private static String TitleStudent = "//span[text()='Students']";
    private static String WilleyPlus = "//a[@href='https://www.wileyplus.com/']";
    private static String Education = "//a[@href='/en-ru/Education-c-ED00']";
    /*Переменные страницы Образование*/
    private static String EducationTitle = "//span[text()='Education']";
    private static String SubjectList = "//div[@class='side-panel']//ul//li";
    /*Переменная логотипа компании*/
    private static String HomePage = "//header[@id='main-header-container']//..//img[@title='Wiley']";
    /*Переменная кнопки поиска*/
    private static String SearchBtn = "//button[text()='Search']";
    /*Переменная Поля поиска*/
    private static String SearchEntryField = "//div[@class='input-group']//input[@type='search']";
    /*Переменная найденных элементов поиска */
    private static String TitleProducts = "//span[contains(text(),'Math')]";
    /*Локатор кнопки AddToCart*/
    private static String ButtonAddToCart = "//button[contains(text(),'Add to cart')]";

    public static String getResurses() {
        return resurses;
    }

    public static String getSubjects() {
        return subjects;
    }

    public static String getAbout() {
        return about;
    }

    public static String getResitems() {
        return resitems;
    }

    public static String getStudents() {
        return Students;
    }

    public static String getTitleStudent() {
        return TitleStudent;
    }

    public static String getWilleyPlus() {
        return WilleyPlus;
    }

    public static String getEducation() {
        return Education;
    }

    public static String getEducationTitle() {
        return EducationTitle;
    }

    public static String getSubjectList() {
        return SubjectList;
    }

    public static String getHomePage() {
        return HomePage;
    }

    public static String getSearchBtn() {
        return SearchBtn;
    }

    public static String getSearchEntryField() {
        return SearchEntryField;
    }

    public static String getTitleProducts() {
        return TitleProducts;
    }

    public static String getButtonAddToCart() {
        return ButtonAddToCart;
    }

}
