package web.action;


import web.screen.Screen;
import web.support.Commons;
import web.support.Environment;
import web.support.PlataformWeb;

import java.io.IOException;

import static web.support.Commons.driver;

public class Action {
    Screen screen = new Screen(driver);
    public void acessarSite() throws Exception {
        Environment.escolherAmbiente();

    }

    public void digitarLoginSenha() throws Exception {

        Commons.getInstance().waitForVisibilityElement(screen.cmpAgencia);
        screen.cmpAgencia.sendKeys("1234");
        screen.cmpConta.sendKeys("123456");
        screen.cmpAvançar.click();

    }

    public void validarMensagemFalha(String mensagemFalha) throws Exception {
        Commons.getInstance().waitForVisibilityElement(screen.cmpMensagemFalha);
        Commons.getInstance().validarElementoPorTexto(screen.cmpMensagemFalha,mensagemFalha);
        Commons.getInstance().validarTextoParcialmente(screen.txtMensagemAlert,"Desculpe, ocorreu um erro na sua solicitação. Por favor,aguarde alguns minutos e tente novamente.");
        driver.quit();
    }
}
