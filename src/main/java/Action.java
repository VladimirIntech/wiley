import io.qameta.allure.Step;
import org.junit.Assert;
import org.openqa.selenium.interactions.Actions.*;
import com.sun.glass.events.MouseEvent;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Action extends PageObject {
    /*Действия с объектами*/
    PageObject pj = new PageObject();

    @Step ("перехода к странице")
    public void PageNavigate(String baseUrl) {

        driver.navigate().to(baseUrl);
        /*Описание для перехода к странице*/
    }

    @Step ("Фокусировка на элементе WHO WE SERVE")
    public void Resourses() {
        Actions resAc = new Actions(driver);
        resAc.moveToElement(pj.getResours()).perform();
        /*Фокусировка на элементе*/
    }

    @Step ("Фокусировка на элементе Subjects")
    public void Subjects() {
        Actions subAc = new Actions(driver);
        subAc.moveToElement(getSubjects()).perform();
        /*Фокусировка на элементе*/
    }
    @Step ("Фокусировка на элементе About")
    public void About() {
        Actions aboAc = new Actions(driver);
        aboAc.moveToElement(pj.getAbout()).perform();
        /*Фокусировка на элементе*/
    }
    @Step ("Проверка вкладки WHO WE SERVE")
    public void resoursesCh() {

        if (pj.resCheck()) {
            Actions resAc = new Actions(driver);
            resAc.moveToElement(pj.getResours()).perform();
            System.out.println("Элемент присутствует" + " " + pj.getResours().getText());
        } else {
            System.out.println("Элемент отсутствует");
            Assert.fail("Элемент отсутствует " + pj.resCheck());
        }

    }
    @Step ("Проверка вкладки Subjects")
    public void subjectsCh() {
        if (pj.subCheck()) {
            Actions subAc = new Actions(driver);
            subAc.moveToElement(pj.getSubjects()).perform();
            System.out.println("Элемент присутствует" + " " + pj.getSubjects().getText());
        } else {
            System.out.println("Элемент отсутствует");
            Assert.fail("Элемент отсутствует " + pj.subCheck());
        }
    }
    @Step ("Проверка вкладки about")
    public void aboutCh() {
        if (pj.aboCheck()) {
            Actions aboAc = new Actions(driver);
            aboAc.moveToElement(pj.getAbout()).perform();
            System.out.println("Элемент присутствует" + " " + pj.getAbout().getText());
        } else {
            System.out.println("Элемент отсутствует");
            Assert.fail("Элемент отсутствует " + pj.aboCheck());
        }
    }
    @Step ("Сравнение данных вкладки WHO WE SERVE")
    public void resItems() {
        /*Проверка значений вкладки Resources*/
        Resourses();
        String[] arItems = {"Students", "Instructors", "Researchers", "Professionals",
                "Librarians", "Institutions", "Book Authors", "Corporations", "Societies"};
        List<String> listQ = new ArrayList<>();
        for (WebElement webElement : pj.ResIm()) {
            listQ.add(webElement.getText());
        }
        System.out.println("Полученные значения: " + listQ + " Размер: " + listQ.size());
        Assert.assertTrue("Не содержит элемент ", listQ.containsAll((Arrays.asList(arItems))));
    }
    @Step ("Проверка страницы Студенты, на правильный URL, наличие заголовка, и ссылку на WileyPlus")
    public void StudentsPage() {
        /*Проверка страницы Студенты*/
        Resourses();
        pj.Students().click();
        if (getDriver().getCurrentUrl().equals("https://www.wiley.com/en-ru/students")) {
            if (pj.TitleStudent().isDisplayed()) {

                if (pj.WilleyPlusm().getAttribute("href").equals("https://www.wileyplus.com/")) {
                    Actions wileyAc = new Actions(driver);
                    wileyAc.moveToElement(pj.WilleyPlusm()).perform();
                    Assert.assertTrue("Ссылка WileyPlus корректная", true);
                } else {
                    Assert.fail("Ссылка WileyPlus не корректная");
                }
            } else {
                Assert.fail("Заголовок Студенты не отображается");
            }
        } else {
            Assert.fail("Ссылка на странице неверная");
        }
    }
    @Step ("Проверка страницы Образование")
    public void EducationPage() {
        /*Проверка страницы Образование*/
        Subjects();
        String[] arrSubj = {"Information & Library Science", "Education & Public Policy", "K-12 General",
                "Higher Education General", "Vocational Technology", "Conflict Resolution & Mediation (School settings)",
                "Curriculum Tools- General", "Special Educational Needs", "Theory of Education",
                "Education Special Topics", "Educational Research & Statistics", "Literacy & Reading",
                "Classroom Management"};
        pj.Education().click();
        if (pj.EducationTitle().isDisplayed()) {
            /*Получаем значения панели Предметы и преобразуем в тип строковые*/
            List<String> getlistSidePanel = new ArrayList();
            for (WebElement getlist : pj.SubList()) {
                getlistSidePanel.add(getlist.getText());
            }
            System.out.println("Полученные значения панели : " + getlistSidePanel + " Размер: " + getlistSidePanel.size());
            Assert.assertTrue("Элементы панели не найдены", getlistSidePanel.containsAll(Arrays.asList(arrSubj)));

        } else {
            Assert.fail("Отсутствует заголовок \"Education\"");
        }
    }
    @Step ("Переход на главную страницу")
    public void HomePageClick() {
        /*Переход на главную страницу*/
        pj.HomePage().click();
    }
    @Step ("Нажатие на кнопку поиск")
    public void SearchBtnClick() {
        /*Нажатие на кнопку поиск*/
        pj.SearchBtn().click();
    }
    @Step ("Ввод текста в поисковик")
    public void SeachText(String textsearch) {
        //  pj.SearchEntryField().click();
        pj.SearchEntryField().sendKeys(textsearch);
    }
    @Step ("Сравнение найденных продуктов")
    public void TitleProductsSearch(String str) {
        System.out.println("Номер проверки для MATH " + str);
        List<String> listTitleProduct = new ArrayList<>();
        List<String> list2 = new ArrayList<>();
        for (WebElement getListProduct : pj.ProductTitle()) {
            listTitleProduct.add(getListProduct.getText());
        }
       /* System.out.println(listTitleProduct.size());
        System.out.println(listTitleProduct);*/
//        Assert.assertTrue("Элементы с титлом Math не найдены", listTitleProduct.contains("Math"));
        for (String e : listTitleProduct) {
            if (e.contains("Math")) {
                System.out.println("Заголовки содержащие \"Math\": " + e);
//            Assert.assertTrue(e.contains("Math"));
                list2.add(e);
            }

        }
        System.out.println("Общее количество найденных звголовков " + listTitleProduct.size());
        System.out.println("Количество найденных звголовков с \"Math\" " + list2.size());
        Assert.assertEquals(listTitleProduct.size(), 10);

        BtnAdd();

    }
    @Step ("Получение количества кнопок Add to Cart")
    public void BtnAdd() {
        List<String> listBtnAdd = new ArrayList<>();
        for (WebElement getListAddToCard : pj.ButtonCard()) {
            listBtnAdd.add(getListAddToCard.getText());
        }
        System.out.println("Колличество кнопок \"Add to Cart\" на найденных элементах " + listBtnAdd.size());
        Assert.assertEquals(listBtnAdd.size(), 15);
    }

}

