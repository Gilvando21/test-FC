package web.runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import web.support.Environment;

@RunWith(Cucumber.class)
@CucumberOptions(
        tags = "@web",
        features = {"src/test/java/web/features"},
        glue = {"web"},
        monochrome=true,
        plugin = {"pretty", "html:target/report-html.html", "json:target/report.json", "junit:target/report.xml"}



)

public class Runner {

}

