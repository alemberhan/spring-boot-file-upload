# spring-boot-file-upload

## By Alemberhan Getahun

## Project Description:
Implement a Restful API in spring-boot application. API to upload a file with a few meta-data fields. 
Persist meta-data in persistent store (In memory DB or file system and store the content on a file system)

## Database
I use H2 in memory DB Engine

## File Store
the path of the file store is specified in application.properties file (file-path properties), You may need to change the value to your file store, where the uploaded file reside.

## Running Application
#### $ mvn spring-boot:run

## Accessing H2 database
#### http://localhost:8080/h2

## Accessing Application 
#### http://localhost:8080/
