Instruções para Rodar o Projeto com Eclipse IDE e WildFly 21

1. Necessario

	eclipse, Java 11 e Maven e WildFly 21
	
	import o projeto normalmente como Maven Project
	
	marque a pasta resouce com principal (imagens: 00 - Import.png, 01 - Import.png, 02 - Import.png)
	
	é necessario criar um dataSource no WildFly tem prints com a configuração o standalone.xml e o module esta na pasta
	
	criar o banco de dados e rodar o arquivo project_script.sql (caso de problema de autenticação alterar na pasta /resources/persistente.xml)
	
	feito tudo isso subir o servidor e rodar na URL http://localhost:8080/ltda-manage-people
