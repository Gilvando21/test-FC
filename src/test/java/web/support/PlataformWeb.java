package web.support;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.CapabilityType;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class PlataformWeb extends Environment {

    public static WebDriver inicializarDriver() throws IOException {

        Properties prop = getProp();
        String browser = prop.getProperty("properties.plataform");

        switch (browser) {


            case "FIREFOX":
                WebDriverManager.firefoxdriver().setup();
                FirefoxOptions options = new FirefoxOptions();
                driver = new FirefoxDriver(options);
                driver.manage().window().setSize(new Dimension(1920, 1080));
                driver.manage().window().setPosition(new Point(0, 0));
                driver.manage().window().maximize();
                break;
            case "CHROME":
                WebDriverManager.chromedriver().clearDriverCache().setup();
                ChromeOptions handlingSSL = new ChromeOptions();
                handlingSSL.addArguments(Arrays.asList("--incognito","disable-infobars", "ignore-certificate-errors", "disable-popup-blocking", "disable-notifications", "no-sandbox"));
              //  handlingSSL.addArguments(Arrays.asList("--incognito","disable-infobars", "ignore-certificate-errors","--disable-dev-shm-usage", "disable-popup-blocking", "disable-notifications", "--no-sandbox","--headless","--verbose","--remote-allow-origins=*"));
                driver = new ChromeDriver(handlingSSL);
                driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
                driver.manage().window().setSize(new Dimension(1920 , 1080));
                //driver.manage().window().maximize();
                break;

            case "EDGE":
                WebDriverManager.chromedriver().setup();
                EdgeOptions ed = new EdgeOptions();
                ed.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
                driver = new EdgeDriver(ed);
                driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
                driver.manage().window().maximize();
                break;

            default:
                System.out.println("deve definir navegador no setup.properties");

                break;
        }
        return driver;
    }

    public static Properties getProp() throws IOException {
        Properties props = new Properties();
        FileInputStream file = new FileInputStream("src" + File.separator + "test" + File.separator + "setup.properties");
        props.load(file);
        return props;

    }
}
