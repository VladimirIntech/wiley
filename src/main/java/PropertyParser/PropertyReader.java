/**
 * Класс работает с проперти документами, возвращает значение ключа
 **/
package PropertyParser;

import org.apache.logging.log4j.Level;

import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Properties;

import static Logger.LogReader.*;

public class PropertyReader {

    public static final String PATH_TO_PROPERTY = "src/main/resources/config.properties";
    private static Properties properties;
    static {
        properties = new Properties();
        try {
            properties.load(new InputStreamReader(new FileInputStream(PATH_TO_PROPERTY), "windows-1251"));
        } catch (Exception e) {
            getLog().log(Level.ERROR, "Файл конфигурации не найден", e);
        }
    }
    public static String getPropertyReader(String KEY_PROPERTY) throws Exception {
        return properties.getProperty(KEY_PROPERTY);
    }
}
