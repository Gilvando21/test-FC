package web.support;



import io.cucumber.java.Before;

import java.io.IOException;

public class Hooks {

    @Before
    public void inicio() throws IOException, InterruptedException {
        PlataformWeb.inicializarDriver();

    }
}
