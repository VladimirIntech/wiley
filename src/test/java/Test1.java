import io.qameta.allure.Step;
import org.junit.Test;

public class Test1 extends WebDR {
    Action steps = new Action();
    WaitTimer timer = new WaitTimer();
    PageObject po = new PageObject();

    @Test
    public void test1() {
        //Шаг 1 переход на страницу
        steps.PageNavigate("https://www.wiley.com/en-ru");
        //Шаг 2 ожидание окончания страницы и проверка присутствия элементов на странице
        timer.ExpectedConditionsTimer();
        steps.resoursesCh();
        steps.subjectsCh();
        steps.aboutCh();
        /*Проверка значений вкладки Resources*/
        steps.resItems();
        /*Шаг 3 Проверка страницы студенты */
        steps.StudentsPage();
        /*Шаг 4 Проверка страницы Образование */
        steps.EducationPage();
        /*Шаг 5 Переход на главную страницу*/
        steps.HomePageClick();
        /*Шаг 6 нажатие на поиск*/
        steps.SearchBtnClick();
        timer.timer(1);
        /*Шаг 7 Ввод данных в строку поиска "Математика"*/
        steps.SeachText("Math");
        timer.timer(5);
        steps.SearchBtnClick();
        /*Шаг 8 Проверка на количество элементов с титулом Math и проверка хотябы одной кнопки Add to cart*/
        steps.TitleProductsSearch("1");
        /*Шаг 9 Ввод данных в строку поиска "Математика"*/
        steps.SeachText("Math");
        steps.SearchBtnClick();
        /*Шаг 10 Повторная проверка MATH*/
        steps.TitleProductsSearch("2");

    }
}
