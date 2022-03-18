package runners;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.CucumberOptions.SnippetType;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "classpath:Features",
		glue = "stepsDefinitions",
		plugin = {"pretty", "html:target/cucumber-reports"},
		tags = "@CalculoDePrecoEPrazoDeEntregaComCepDeOrigemInvalido",
		snippets = SnippetType.CAMELCASE,
		monochrome = true,
		dryRun = false
		)
public class CalculoDePrecoEPrazoDeEntregaComCepDeOrigemInvalidoTest {

}
