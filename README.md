# Task Manager

## Requisitos 
  A empresa ACME decidiu criar uma lista de tarefas e a área de negócio definiu que o MVP deve
  conter apenas as funcionalidades abaixo:
  * Criar a lista
  * Adicionar item à lista
  * Remover item da lista
  * Marcar item como concluído
  
 ## Tecnologias utilizadas
 
 <div style="display:flex; ">

  <img src="https://upload.wikimedia.org/wikipedia/commons/thumb/c/cf/Angular_full_color_logo.svg/250px-Angular_full_color_logo.svg.png" width="13%" height="45%"/>

  <img src="http://www.t2ti.com/images/siscom-spring/spring.png" width="18%" height="%"/>

</div>

## Instruções para executar o projeto

Faça um clone do projeto no seu computador, em seguinda:

### Back-end
1. Abra a pasta do projeto no terminal;
2. Execute o comando **mvn clean eclipse:clean eclipse:eclipse -DdownloadSources=true  -DdownloadJavadocs=true** para baixar as dependências do Maven;
3. Execute o projeto como **Java Application** e selecione a classe **Aplicacao**.
4. Observe no console se a aplicação está rodando na porta 9000. Caso não esteja, adicione a pasta src/main/resources ao Build Path e execute o projeto novamente.


### Front-end
1. Abra a pasta do projeto no terminal;
2. Rode o comando **npm install** para baixar as dependências;
3. Rode o comando **ng serve** para executar o projeto;
