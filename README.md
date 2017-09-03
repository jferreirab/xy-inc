# xy-inc
Desafio back-end

Este projeto foi criada com o framework Spring Boot , Spring Data e Spring web services.
Foi utilizado o banco de dados postgres.
Foi utilizado a IDE Eclipse.


1 -Para executar a aplicação:
  - Executar os scripts de criação da base dados, criação de usuário e de carga de dados inicial. Arquivo "sql_cria banco.sql"
  
2 - Compilar aplicação:
  
  Dentro da pasta do projeto executar:
   
   mvn install
   
   Após compilado entrar na pasta target e executar o comando:
   
   java -jar xy-inc-0.0.1-SNAPSHOT.jar

  
3 - Url de execução/testes dos Serviços
  
  1- Serviço para cadastrar pontos de interesse com 3 atributos.
   
   url:
     http://localhost:8080/api/poi
	 
	 Json :
	  {"descricao": "Posto","x":"12","y":"18"}
	  
  2- Serviço para listar todos os POIs cadastrados.
  
   url:  
     http://localhost:8080/api/poi
	 
  3- Serviço para listar POIs por proximidade.
  
   url:
     http://localhost:8080/api/poi/27/12/1
	 
	 Onde :
	 27 é a coordenada x
	 12 é a coordenada y
	 1 é a distância maxima entre os pontos.
  
