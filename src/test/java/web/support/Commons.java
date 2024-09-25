package web.support;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.time.Duration;

public class Commons {
    public static WebDriver driver;
    private static Commons instance;

    public static Commons getInstance() {
        if (instance == null) {
            instance = new Commons();
        }
        return instance;
    }

    public void validarElementoPorTexto(WebElement element, String textEsperado) throws IOException {
        if (element == null) {
            throw new IllegalArgumentException("O elemento fornecido é nulo.");
        }

        String textoElemento = element.getText();
        Assert.assertEquals("O texto do elemento não corresponde ao esperado.", textEsperado, textoElemento);
    }

    public void waitForVisibilityElement(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void validarTextoParcialmente(WebElement elemento, String texto) {
        if (!elemento.getText().contains(texto)) {
            System.out.println("Texto do elemento: " + elemento.getText() + " diferente do texto esperado: " + texto);
            Assert.fail();
        }
    }
}
