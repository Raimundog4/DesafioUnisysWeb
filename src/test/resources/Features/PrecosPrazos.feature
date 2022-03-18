#language: pt
#enconding: UTF-8
@PrecosPrazos @End2End
Funcionalidade: Calculo de precos e prazos de entrega

  Contexto: 
    Dado que o usuario esteja na tela de Calculo de precos e prazos de entrega dos Correios

  @CalculoDePrecoEPrazoDeEntregaComDadosValidos
  Cenario: Calculo de preco e prazo de entrega com dados validos
    Quando preencher o campo Cep de Origem como "34006-056"
    E preencher o campo Cep de Destino como "04711-130"
    E selecionar o tipo de serivo como "Sedex"
    E selecionar o formato como Caixa/Pacote
    E selecionar a embalagem como "Outra Embalagem"
    E preencher o campo Altura como "9"
    E preencher o campo Largura como "27"
    E preencher o campo Comprimento como "18"
    E selecionar o peso estimado como "2"
    E selecionar o servico Mao Propria
    E acionar o botao Calcular
    Entao o sistema apresentara a pagina Resultado do Calculo informando o PrazoDeEntrega e o ValorTotal

  @CalculoDePrecoEPrazoDeEntregaComCepDeOrigemInvalido
  Cenario: Calculo de preco e prazo de entrega com Cep de origem invalido
    Quando preencher o campo Cep de Origem como "10101010"
    E preencher o campo Cep de Destino como "04711-130"
    E selecionar o tipo de serivo como "Sedex"
    E selecionar o formato como Caixa/Pacote
    E selecionar a embalagem como "Outra Embalagem"
    E preencher o campo Altura como "9"
    E preencher o campo Largura como "27"
    E preencher o campo Comprimento como "18"
    E selecionar o peso estimado como "2"
    E selecionar o servico Mao Propria
    E acionar o botao Calcular
    Entao o sistema apresentara um Alert com a mensagem "CEP de origem nao encontrado na base de dados dos Correios (-1)."
    
    #Para o relatório foi gerada uma screenshot ao final de cada cenário, para evidenciar o teste.
    #No cenário 'Calculo de preco e prazo de entrega com Cep de origem invalido' a screenshot foi gerada, porém não capturou o Alert.
