# Conversor de Moedas em Java

📌 Descrição

Este projeto é um Conversor de Moedas desenvolvido em Java, com interação via console. 
O sistema permite ao usuário escolher entre diferentes opções de conversão de moedas e
obtém as taxas de câmbio em tempo real, utilizando a ExchangeRate API.

O projeto foi desenvolvido como parte de um desafio prático do curso da Alura / Programa ONE,
com o objetivo de aplicar conceitos fundamentais de Java, consumo de API e manipulação de dados em formato JSON.

⚙️ Funcionalidades

- Menu interativo no console
- Conversão de moedas em tempo real
- Consumo de API externa de taxas de câmbio
- Leitura de valores com vírgula ou ponto
- Exibição dos valores formatados

💱 Conversões disponíveis

- Dólar (USD) → Real (BRL)
- Real (BRL) → Dólar (USD)
- Libra Turca (TRY) → Real (BRL)
- Real (BRL) → Libra Turca (TRY)
- Franco Suíço (CHF) → Real (BRL)
- Real (BRL) → Franco Suíço (CHF)

🧠 Conceitos utilizados

- Estruturas de repetição (while)
- Estrutura de decisão (switch-case)
- Métodos para organização do código
- Consumo de API com HttpClient, HttpRequest e HttpResponse
- Manipulação de JSON com a biblioteca Gson
- Formatação de números com DecimalFormat

🛠️ Tecnologias utilizadas

- Java JDK 17+
- IntelliJ IDEA
- Biblioteca Gson
- ExchangeRate API

▶️ Como executar o projeto

- Clone este repositório ou faça o download dos arquivos
- Abra o projeto em uma IDE Java (ex: IntelliJ IDEA)
- Certifique-se de ter o Java 17 ou superior instalado
- Execute a classe Main
- Escolha uma das opções do menu no console e informe o valor para conversão

✍️ Aprendizados

- Consumo de API em Java
- Manipulação de dados JSON com Gson
- Estruturação de menus com `switch`
- Organização de código usando métodos
- Interação com o usuário via console

🚀 Possíveis melhorias futuras

- Validação de entrada do usuário para evitar erros em valores inválidos

- Organização das opções do menu para reduzir repetição de código

- Uso de variável de ambiente para armazenar a chave da API

- Melhoria nas mensagens de erro retornadas pela API

- Inclusão de novas moedas disponíveis para conversão

Essas melhorias não foram implementadas nesta versão, pois o foco do projeto é o aprendizado dos conceitos básicos de Java e consumo de APIs.

📌 Observações

- A chave da API está configurada no código apenas para fins educacionais
- O projeto não possui interface gráfica, funcionando exclusivamente via console
- O foco do projeto é aprendizado e prática de conceitos básicos de Java

👩‍💻 Autora

Thais Miranda

Projeto desenvolvido para fins educacionais, como parte do aprendizado em Java e consumo de APIs.

📎 Licença

Este projeto é de uso educacional.