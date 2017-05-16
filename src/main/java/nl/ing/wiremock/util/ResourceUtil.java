package nl.ing.wiremock.util;

import javax.ws.rs.core.Response;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by thage on 16-5-17.
 */
public class ResourceUtil {

    public static Properties getProperties() {
        String fileName = "config.properties";

        Properties prop = new Properties();
        //Get file from resources folder
        ClassLoader classLoader = new ResourceUtil().getClass().getClassLoader();
        File file = new File(classLoader.getResource(fileName).getFile());
        try {
            InputStream input = new FileInputStream(file);
            prop.load(input);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return prop;
    }

}
