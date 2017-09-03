# xy-inc
Desafio back-end

Este projeto foi criada com o framework Spring Boot , Spring Data e Spring web services.
Foi utilizado o banco de dados postgres.
Foi utilizado a IDE Eclipse.


1 -Para executar a aplica��o:
  - Executar os scripts de cria��o da base dados, cria��o de usu�rio e de carga de dados inicial. Arquivo "sql_cria banco.sql"
  
2 - Compilar aplica��o:
  
  Dentro da pasta do projeto executar:
   
   mvn install
   
   Ap�s compilado entrar na pasta target e executar o comando:
   
   java -jar xy-inc-0.0.1-SNAPSHOT.jar

  
3 - Url de execu��o/testes dos Servi�os
  
  1- Servi�o para cadastrar pontos de interesse com 3 atributos:
   url:
     http://localhost:8080/api/poi
	 
	 Json :
	  {"descricao": "Posto","x":"12","y":"18"}
	  
  2- Servi�o para listar todos os POIs cadastrados.
   url:  
     http://localhost:8080/api/poi
	 
  3- Servi�o para listar POIs por proximidade.
  
   url:
     http://localhost:8080/api/poi/27/12/1
	 
	 Onde 27 � a coordenada x
	      12 � a coordenada y
		  1 � a dist�ncia maxima entre os pontos.
  
