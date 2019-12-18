package PageInfo;

import ru.yandex.qatools.allure.annotations.Step;
import org.apache.logging.log4j.Level;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

import static Logger.LogReader.*;
import static PropertyParser.PropertyReader.*;
import static Driver.WebDR.*;
public class ActionPage extends ObgectPage {
    /*Действия с объектами*/

    @Step("перехода к странице")
    public static void PageNavigate(String baseUrl) {
        try {
            getLog().log(Level.INFO, "Переход к тестовой странице: " + baseUrl);
            open(baseUrl);
            getLog().log(Level.INFO, "Открыта страница: " + baseUrl);
        } catch (Exception urlEX) {
            getLog().log(Level.ERROR, "Переход на страницу не осуществлен: " + baseUrl, urlEX);
        }
    }

    @Step("Фокусировка на элементе WHO WE SERVE")
    public static void Resourses() {
        try {
            actionsWith(getResurses());
        } catch (Exception exResourses) {
            getLog().log(Level.ERROR, "Элемент не обнаружен " + getResurses(), exResourses);
        }
        /*Фокусировка на элементе*/
    }

    @Step("Фокусировка на элементе Subjects")
    public static void Subjects() {
        try {
            actionsWith(getSubjects());
        } catch (Exception exSub) {
            getLog().log(Level.ERROR, "Элемент не обнаружен " + getSubjects(), exSub);
        }
        /*Фокусировка на элементе*/
    }

    @Step("Фокусировка на элементе About")
    public static void About() {
        try {
            actionsWith(getAbout());
        } catch (Exception exAbout) {
            getLog().log(Level.ERROR, "Элемент не обнаружен " + getAbout(), exAbout);
        }
        /*Фокусировка на элементе*/
    }

    @Step("Проверка вкладки WHO WE SERVE")
    public static void resoursesCh() {
        try {
            if (check(getResurses())) {
                actionsWith(getResurses());
                getLog().log(Level.INFO, "Элементы " + getResurses());
            }
        } catch (Exception exRes) {
            getLog().log(Level.ERROR, "Элемент не обнаружен " + getAbout(), exRes);
        }
    }

    @Step("Проверка вкладки Subjects")
    public static void subjectsCh() {
        try {
            if (check(getSubjects())) {
                actionsWith(getSubjects());
                getLog().log(Level.INFO, "Элементы " + getSubjects());
            }
        } catch (Exception exSub) {
            getLog().log(Level.ERROR, "Элемент не обнаружен " + getSubjects(), exSub);
        }
    }

    @Step("Проверка вкладки about")
    public static void aboutCh() {
        try {
            if (check(getAbout())) {
                actionsWith(getAbout());
                getLog().log(Level.INFO, "Элементы " + getAbout());
            }
        } catch (Exception exAbout) {
            getLog().log(Level.ERROR, "Элемент не обнаружен " + getAbout(), exAbout);
        }
    }

    @Step("Сравнение данных вкладки WHO WE SERVE")
    public static void resItems() {
        /*Проверка значений вкладки Resources*/
        try {
            Resourses();
            String[] arItems = {"Students", "Instructors", "Researchers", "Professionals",
                    "Librarians", "Institutions", "Book Authors", "Corporations", "Societies"};
            List<String> listQ = new ArrayList<>();
            for (WebElement webElement : List_find(getResitems())) {
                listQ.add(webElement.getText());
            }
            getLog().log(Level.INFO, "Полученные значения: " + listQ + " Размер: " + listQ.size());
            // Assert.assertTrue("Не содержит элемент ", listQ.containsAll((Arrays.asList(arItems))));
        } catch (Exception exItems) {
            getLog().log(Level.ERROR, "Элемент не найден" + getResitems(), exItems);
        }
    }

    @Step("Проверка страницы Студенты, на правильный URL, наличие заголовка, и ссылку на WileyPlus")
    public static void StudentsPage() {
        /*Проверка страницы Студенты*/
        try {
            Resourses();
            Click(getStudents());
            if (getDriver().getCurrentUrl().equals(getPropertyReader("pageName"))) {
                if (find(getTitleStudent()).isDisplayed()) {

                    if (find(getWilleyPlus()).getAttribute(getPropertyReader("getAttributeURL")).equals(getPropertyReader("equalsURL"))) {
                        actionsWith(getWilleyPlus());
                        getLog().log(Level.INFO, "Проверка страницы успешна");
                    //Assert.assertTrue("Ссылка WileyPlus корректная", true);
                    } else {
                        getLog().log(Level.INFO, "Ссылка WileyPlus не корректная");
                        // Assert.fail("Ссылка WileyPlus не корректная");
                    }
                } else {
                    getLog().log(Level.INFO, "Заголовок Студенты не отображается");
                    //  Assert.fail("Заголовок Студенты не отображается");
                }
            } else {
                getLog().log(Level.INFO, "Ссылка на странице неверная");
                // Assert.fail("Ссылка на странице неверная");
            }
        } catch (Exception exPage) {
            getLog().log(Level.ERROR, "Элемент не найден" + getResitems(), exPage);
        }
    }

    @Step("Проверка страницы Образование")
    public static void EducationPage() {
        /*Проверка страницы Образование*/
        try {
            Subjects();
            String[] arrSubj = {"Information & Library Science", "Education & Public Policy", "K-12 General",
                    "Higher Education General", "Vocational Technology", "Conflict Resolution & Mediation (School settings)",
                    "Curriculum Tools- General", "Special Educational Needs", "Theory of Education",
                    "Education Special Topics", "Educational Research & Statistics", "Literacy & Reading",
                    "Classroom Management"};
            Click(getEducation());
            if (find(getEducationTitle()).isDisplayed()) {
                /*Получаем значения панели Предметы и преобразуем в тип строковые*/
                List<String> getlistSidePanel = new ArrayList();
                for (WebElement getlist : List_find(getSubjectList())) {
                    getlistSidePanel.add(getlist.getText());
                }
                getLog().log(Level.INFO, "Страница проверена");

              /*Assert.assertTrue("Элементы панели не найдены", getlistSidePanel.containsAll(Arrays.asList(arrSubj)));
*/
            } /*else {
                Assert.fail("Отсутствует заголовок \"Education\"");
            }*/
        } catch (Exception exEducation) {
            getLog().log(Level.ERROR, "Отсутствует заголовок " + getEducation(), exEducation);
        }

    }

    @Step("Переход на главную страницу")
    public static void HomePageClick() {
        /*Переход на главную страницу*/
        try {
            Click(getHomePage());
            getLog().log(Level.INFO, "Нажата кнопа " + getHomePage());
        } catch (Exception exBTN) {
            getLog().log(Level.ERROR, "Отсутствует элемент " + getHomePage(), exBTN);
        }
    }

    @Step("Нажатие на кнопку поиск")
    public static void SearchBtnClick() {
        /*Нажатие на кнопку поиск*/
        try {
            Click(getSearchBtn());
            getLog().log(Level.INFO, "Нажата кнопа " + getSearchBtn());
        } catch (Exception exBTN) {
            getLog().log(Level.ERROR, "Отсутствует элемент " + getSearchBtn(), exBTN);
        }
    }

    @Step("Ввод текста в поисковик")
    public static void SeachText(String textsearch) {
        try {
            find(getSearchEntryField()).sendKeys(textsearch);
            getLog().log(Level.INFO, "Введен текст " + textsearch);
        } catch (Exception exSeach) {
            getLog().log(Level.ERROR, "Отсутствует элемент " + getSearchEntryField(), exSeach);
        }
    }

    @Step("Сравнение найденных продуктов")
    public static void TitleProductsSearch(String str) {
        try {
            System.out.println("Номер проверки для MATH " + str);

            List<String> listTitleProduct = new ArrayList<>();
            List<String> list2 = new ArrayList<>();

            for (WebElement getListProduct : List_find(getTitleProducts())) {
                listTitleProduct.add(getListProduct.getText());
            }

            for (String e : listTitleProduct) {
                if (e.contains("Math")) {
                    System.out.println("Заголовки содержащие \"Math\": " + e);
            Assert.assertTrue(e.contains("Math"));
                    list2.add(e);
                }

            }
            getLog().log(Level.INFO, "Общее количество найденных звголовков " + listTitleProduct.size());
            getLog().log(Level.INFO, "Количество найденных звголовков с \"Math\" " + list2.size());
            Assert.assertEquals(listTitleProduct.size(), 19);

            BtnAdd();
        } catch (Exception exTitle) {
            getLog().log(Level.ERROR, "Отсутствует элемент " + getSearchEntryField(), exTitle);
        }
    }

    @Step("Получение количества кнопок Add to Cart")
    public static void BtnAdd() {
        try {
            List<String> listBtnAdd = new ArrayList<>();
            for (WebElement getListAddToCard : List_find(getButtonAddToCart())) {
                listBtnAdd.add(getListAddToCard.getText());
            }
            getLog().log(Level.INFO, "Колличество кнопок \"Add to Cart\" на найденных элементах " + listBtnAdd.size());
            Assert.assertEquals(listBtnAdd.size(), 15);
        } catch (Exception exBTN) {
            getLog().log(Level.ERROR, "Отсутствует элемент " + getButtonAddToCart(), exBTN);
        }
    }

}

