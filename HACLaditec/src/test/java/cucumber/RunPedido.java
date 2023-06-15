package cucumber;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = "src/test/java/cucumber/pedido.feature",
    glue = "Pedido.steps",
    plugin = {
        "io.qameta.allure.cucumber6jvm.AllureCucumber6Jvm",
        "json:target/cucumber-report/cucumber.json",
        "html:target/cucumber-report/cucumber-html-report"
    }
)
public class RunPedido {
}


