package stepsDefinitions;

import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import pageObjects.PrecosPrazosPage;

import static utils.Utils.*;

public class PrecosPrazosSteps {

	@Dado("que o usuario esteja na tela de Calculo de precos e prazos de entrega dos Correios")
	public void queOUsuarioEstejaNaTelaDeCalculoDePrecosEPrazosDeEntregaDosCorreios() {
		Na(PrecosPrazosPage.class).validarTelaCalculoDePrecosPrazos();
	}

	@Quando("preencher o campo Cep de Origem como {string}")
	public void preencherOCampoCepDeOrigemComo(String cepOrigem) {
		Na(PrecosPrazosPage.class).preencherCampoCepOrigem(cepOrigem);
	}

	@E("preencher o campo Cep de Destino como {string}")
	public void preencherOCampoCepDeDestinoComo(String cepDestino) {
		Na(PrecosPrazosPage.class).preencherCampoCepDestino(cepDestino);
	}

	@E("selecionar o tipo de serivo como {string}")
	public void selecionarOTipoDeSerivoComo(String servico) {
		Na(PrecosPrazosPage.class).selecionarServico(servico);
	}

	@E("selecionar o formato como Caixa\\/Pacote")
	public void selecionarOFormatoComoCaixaPacote() {
		Na(PrecosPrazosPage.class).acionarFormatoCaixa();
	}

	@E("selecionar a embalagem como {string}")
	public void selecionarAEmbalagemComo(String embalagem) {
		Na(PrecosPrazosPage.class).selecionarEmbalagem(embalagem);
	}

	@E("preencher o campo Altura como {string}")
	public void preencherOCampoAlturaComo(String altura) {
		Na(PrecosPrazosPage.class).preencherCampoAltura(altura);
	}

	@E("preencher o campo Largura como {string}")
	public void preencherOCampoLarguraComo(String largura) {
		Na(PrecosPrazosPage.class).preencherCampoLargura(largura);
	}

	@E("preencher o campo Comprimento como {string}")
	public void preencherOCampoComprimentoComo(String comprimento) {
		Na(PrecosPrazosPage.class).preencherCampoComprimento(comprimento);
	}

	@E("selecionar o peso estimado como {string}")
	public void selecionarOPesoEstimadoComo(String peso) {
		Na(PrecosPrazosPage.class).selecionarPeso(peso);
	}

	@E("selecionar o servico Mao Propria")
	public void selecionarOServicoMaoPropria() {
		Na(PrecosPrazosPage.class).acionarServicoMaoPropria();
	}

	@E("acionar o botao Calcular")
	public void acionarOBotaoCalcular() {
		Na(PrecosPrazosPage.class).acionarBotaoCalcular();
	}
	
	@Entao("o sistema apresentara a pagina Resultado do Calculo informando o PrazoDeEntrega e o ValorTotal")
	public void oSistemaApresentaraUmaPaginaInformandoOPrazoDeEntregaEOValorTotal() {
		Na(PrecosPrazosPage.class).validarResultadoDoCalculo();
	}

	@Entao("o sistema apresentara um Alert com a mensagem {string}")
	public void oSistemaApresentaraUmAlertComAMensagem(String mensagem) {
		Na(PrecosPrazosPage.class).validarMensagemCepDeOrigemInvalido();
	}


}
