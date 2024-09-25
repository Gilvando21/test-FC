package web.screen;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Screen {
    @FindBy(id = "idl-menu-agency")
    public WebElement cmpAgencia;

    @FindBy(id = "idl-menu-account")
    public WebElement cmpConta;

    @FindBy(id = "idl-btn-login-ok")
    public WebElement cmpAvançar;

    @FindBy(xpath = "//p[text()=\"Desculpe, ocorreu um erro na sua solicitação. Por favor,aguarde alguns minutos e tente novamente.\"]")
    public WebElement txtMensagemAlert;

    @FindBy(xpath = "//a[text()=\"Tentar novamente\"]")
    public WebElement cmpMensagemFalha;



    public Screen(WebDriver driver) {
             PageFactory.initElements(driver, this);
    }


}
