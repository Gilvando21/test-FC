package web.support;

import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Environment extends Commons {


    public static String escolherAmbiente() throws IOException, InterruptedException {
        // Verifica se o driver está inicializado
        if (driver == null) {
            // Chama o método de inicialização da classe PlataformWeb
            driver = PlataformWeb.inicializarDriver();
        }

        Properties pro = getProp();
        String ambient = pro.getProperty("properties.link.ambiente");

        switch (ambient) {
            case "QA":
                driver.get("https://www.itau.com.br/");
                break;

            case "HOM":
                driver.get("");
                break;

            case "PROD":
                driver.get("");
                break;

            default:
                System.out.println("deve definir ambiente no properties.link.ambiente");
                break;
        }

        return ambient;
    }

    public static Properties getProp() throws IOException {
        Properties props = new Properties();
        FileInputStream file = new FileInputStream("src" + File.separator + "test" + File.separator + "setup.properties");
        props.load(file);
        return props;
    }
}
