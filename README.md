# apimovies
API Restful que possibilita a leitura da lista de indicados e vencedores da categoria Pior Filme do Golden Raspberry Awards

Aplicação desenvolvida utilizando a IDE SpringToolSuite4. Starts: Spring Boot Web, DevTools, Maven, H2 database, JPA;

JRE: JavaSE - 11, Junit4

Step 1 - Para baixar a aplicação basta clonar o repositório no Github: https://github.com/ricardosteilein/apimovies

Step 2 - Importar o projeto como Existente Projeto Maven 

Step 3 - Para executar a aplicação clicar em "Run as Spring Boot Aplicattion" ou clicar em Boot Dashboard e clicar em "Start Process";

Step 4 - O Arquivo movielist.csv encontra-se em: src/main/resources/movielist.csv;

Step 5 - O endereço da aplicação e o  Banco de dados H2 em memória está configurado no arquivo src/main/resources/application.config;
	   - server.servlet.contextPath=/app - local onde está localizada a api
	   - spring.h2.console.path=/h2 -- caminho onde é possível acessar o banco de dados e suas entidades
	   - spring.datasource.url=jdbc:h2:mem:dbmovies -- nome determinado ao banco
	   - spring.datasource.username=sa -- usuário banco de dados
	   - spring.datasource.password=   -- senha banco de dados
	   - spring.jpa.show-sql=true -- mostra a criação das entidades e dados no banco, pode ser setado false para desabilitar
	   
Step 6 - Após iniciar o projeto colar a url: http://localhost:8080/app/producer/awards-interval no navegador de internet, para visualizar o resultado da API construída.

Step 7 - A classe de testes de integração encontra-se em: src\test;
		Para executar a classe AplicattionTest.java utilizando o Junit4;
		
		
			
