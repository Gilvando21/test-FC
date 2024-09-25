package web.steps;

import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;
import web.action.Action;

import java.io.IOException;

public class Steps {
      Action action = new Action();
    @Dado("que o usuario acesse o site")
    public void que_o_usuario_acesse_o_site() throws Exception {
       action.acessarSite();

    }
    @Quando("digitar login e senha invalido")
    public void digitar_login_e_senha_invalido() throws Exception {
        action.digitarLoginSenha();

    }
    @Então("valido mensagem de erro {string}")
    public void valido_mensagem_de_erro(String mensagem) throws Exception {
           action.validarMensagemFalha(mensagem);
    }

}
