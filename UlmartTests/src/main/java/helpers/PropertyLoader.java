package helpers;

import java.io.IOException;
import java.util.Properties;

/**
 * Created by Мастер on 20.11.2016.
 */
public class PropertyLoader {
    public static final String PROPERTIES_FILE = "/application.properties";

    private PropertyLoader() {
    }

    public static String loadProperty(String name) {
        Properties props = new Properties();
        try {
            props.load(PropertyLoader.class.getResourceAsStream(PROPERTIES_FILE));
        } catch (IOException e) {
            e.printStackTrace();
        }
        String value = "";
        if (name != null) {
            value = props.getProperty(name);
        }
        return value;
    }
}
