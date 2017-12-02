## Name: Alemberhan Getahun
## Project Description:
Implement a Restful API in spring-boot application. API to upload a file with a few meta-data fields. 
Persist meta-data in persistent store (In memory DB or file system and store the content on a file system)

TODO
	1-CONFIGURE IN MIMORY DATABASE (HSQL)
	2-CREATE DATABASE, TABLE IN HSQL
	3-CONFIGURE SPRING DATA JPA
	4-GENERATE ENTITY AND REPOSITORY
	5.IMPLEMENT UI
	5.IMPLEMENT REST CONTROLLER
	5.IMPLEMENT SERVICE
	6.TEST
	
## IN MIMORY DATABASE (H2)

For this project I am using H2 database to store meta-data of the file.
In pom.xml, I add the below dependency:
	<dependency>
		<groupId>com.h2database</groupId>
		<artifactId>h2</artifactId>
	</dependency>
	
