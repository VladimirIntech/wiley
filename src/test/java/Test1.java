import Driver.WebDR;

import org.junit.Test;

import static PageInfo.ActionPage.*;
import static PropertyParser.PropertyReader.*;
import static SimpleActions.ActionsAPI.*;

public class Test1 extends WebDR {
    @Test
    public void test1() throws Exception {
        //Шаг 1 переход на страницу
        PageNavigate(getPropertyReader("baseURL"));
        //Шаг 2 ожидание окончания страницы и проверка присутствия элементов на странице
        resoursesCh();
        subjectsCh();
        aboutCh();
        /*Проверка значений вкладки Resources*/
        resItems();
        /*Шаг 3 Проверка страницы студенты */
        StudentsPage();
        /*Шаг 4 Проверка страницы Образование */
        EducationPage();
        /*Шаг 5 Переход на главную страницу*/
        HomePageClick();
        /*Шаг 6 нажатие на поиск*/
        SearchBtnClick();
        /*Шаг 7 Ввод данных в строку поиска "Математика"*/
        SeachText(getPropertyReader("SeachText"));
        SearchBtnClick();
        /*Шаг 8 Проверка на количество элементов с титулом Math и проверка хотябы одной кнопки Add to cart*/
        TitleProductsSearch(getPropertyReader("TitleProductsSearch1"));
        /*Шаг 9 Ввод данных в строку поиска "Математика"*/
       // SeachText(getPropertyReader("SeachText"));
        SearchBtnClick();
        /*Шаг 10 Повторная проверка MATH*/
        TitleProductsSearch(getPropertyReader("TitleProductsSearch2"));

    }
}
