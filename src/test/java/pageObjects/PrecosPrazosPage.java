package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.junit.Assert.assertTrue;
import static utils.Utils.*;

import java.util.ArrayList;
import java.util.List;

public class PrecosPrazosPage {
	
	@FindBy(xpath = "//div[@class='tituloimagem']//h3[text()='Cálculo de preços e prazos de entrega']")
	private WebElement telaCalculoDePrecosPrazos;

	@FindBy(name = "cepOrigem")
	private WebElement campoCepOrigem;
	
	@FindBy(name = "cepDestino")
	private WebElement campoCepDestino;
	
	@FindBy(name = "servico")
	private WebElement selectServico;
	
	@FindBy(xpath = "//span[@id='spanFormato']//img[@class='caixa']")
	private WebElement opcaoFormatoCaixa;
	
	@FindBy(name = "embalagem1")
	private WebElement selectEmbalagem;
	
	@FindBy(name = "Altura")
	private WebElement campoAltura;
	
	@FindBy(name = "Comprimento")
	private WebElement campoComprimento;
	
	@FindBy(name = "Largura")
	private WebElement campoLargura;
	
	@FindBy(name = "peso")
	private WebElement selectPeso;
	
	@FindBy(name = "MaoPropria")
	private WebElement opcaoServicoMaoPropria;
	
	@FindBy(name = "Calcular")
	private WebElement botaoCalcular;
	
	@FindBy(xpath = "(//tr[@class='destaque']//td)[1]")
	private WebElement campoPrazoDeEntrega;
	
	@FindBy(xpath = "(//tr[@class='destaque']//td)[2]")
	private WebElement campoValorTotal;
	
	@FindBy(xpath = "//script[@language='javascript'][contains(.,'CEP de origem não encontrado na base de dados dos Correios (-1).')]")
	private WebElement mensagemErroCepDeOrigem;
	
	public void validarTelaCalculoDePrecosPrazos() {
		assertTrue(telaCalculoDePrecosPrazos.isDisplayed());
	}
	
	public void preencherCampoCepOrigem(String cepOrigem) {
		esperarElemento(campoCepOrigem);
		campoCepOrigem.sendKeys(cepOrigem);
	}
	
	public void preencherCampoCepDestino(String cepDestino) {
		esperarElemento(campoCepDestino);
		campoCepDestino.sendKeys(cepDestino);
	}
	
	public void selecionarServico(String servico) {
		esperarElemento(selectServico);
		selecionar(selectServico, servico.toUpperCase());
	}
	
	public void acionarFormatoCaixa() {
		esperarElemento(opcaoFormatoCaixa);
		opcaoFormatoCaixa.click();
	}
	
	public void selecionarEmbalagem(String embalagem) {
		esperarElemento(selectEmbalagem);
		selecionar(selectEmbalagem, embalagem);
	}
	
	public void preencherCampoAltura(String altura) {
		esperarElemento(campoAltura);
		campoAltura.sendKeys(altura);
	}
	
	public void preencherCampoLargura(String largura) {
		esperarElemento(campoLargura);
		campoLargura.sendKeys(largura);
	}
	
	public void preencherCampoComprimento(String comprimento) {
		esperarElemento(campoComprimento);
		campoComprimento.sendKeys(comprimento);
	}
	
	public void selecionarPeso(String peso) {
		esperarElemento(selectPeso);
		selecionar(selectPeso, peso);
	}
	
	public void acionarServicoMaoPropria() {
		esperarElemento(opcaoServicoMaoPropria);
		opcaoServicoMaoPropria.click();
	}
	
	public void acionarBotaoCalcular() {
		esperarElemento(botaoCalcular);
		botaoCalcular.click();
	}
	
	public void validarResultadoDoCalculo() {
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} 
		/* ALTERNAR ABA */
		List<String> abas = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(abas.get(1));
		
		/* A validação foi feita baseada na ideia de que os campos são dinâmicos.
		* Então foram realizados dois Asserts, um para verificar se está visível 
		* e outro para verificar se não está vazio. */
		assertTrue(campoPrazoDeEntrega.isDisplayed() && campoPrazoDeEntrega.getText().length() != 0);
		assertTrue(campoValorTotal.isDisplayed() && campoValorTotal.getText().length() != 0);
	}
	
	public void validarMensagemCepDeOrigemInvalido() {
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} 
		List<String> abas = new ArrayList<String>(driver.getWindowHandles());
		
		/* Foi fechado a primeira Aba por conta de que o Alert contendo a mensagem de erro
		 * foi apresentado em uma nova Aba, e essa nova Aba não estava carregando o código HTML para que fosse efetuada
		 * a validação. Uma solução para que assim fosse carregado o código HTML foi fechando a primeira Aba. */
		driver.switchTo().window(abas.get(0)).close();
		driver.switchTo().window(abas.get(1));
		assertTrue(mensagemErroCepDeOrigem.isEnabled());
	}
}
