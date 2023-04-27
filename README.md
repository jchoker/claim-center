# Claim Center

A scaled-down version of a Claim Center application. 

The purpose is to record and manage claims of health care providers such as hospitals and laboratories with the related information on patient admission.

Technologies:  
	 Jdk 19, Java 17, spring boot 2.7.9, spring web, microservice, REST API, OpenAPI, integration  
	 testing, JUnit, Hibernate, jpql, MySQL/PostgreSQL, Docker, Jib, Maven, Lombok, HATEOAS

Setup:  
Install mysql or PostgreSQL server then create 'claim-center' schema (not required for container)  
Once the app runs, it creates setup data in the db  

For dtos embedded custom fields (foreign keys) included 2 fields id and type, id used when adding data (post meth.)  
 and type when retieving data (get meth.) e.g. physician_i/physician

Resources:  
www.start.spring.io/  
www.springdoc.org/  (integration between spring-boot and swagger-ui)  
www.cloud.google.com/java/getting-started/jib  
www.dev.mysql.com/downloads/windows/installer/8.0.html (Mysql 8.0.32 download)  
www.dev.mysql.com/downloads/workbench/  
www.enterprisedb.com/downloads/postgres-postgresql-downloads v 15.2  
www.spring.io/guides/tutorials/rest/ section 'What makes something RESTful'?  


Swagger UI:  
http://localhost:8080/v3/api-docs  
http://localhost:8080/v3/api-docs.yaml  
http://localhost:8080/swagger-ui/index.html  
