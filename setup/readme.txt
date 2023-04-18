Claim Center

A scaled-down version of a Claim Center application.
The purpose is to record and manage claims of health care providers such as hospitals and laboratories with the related information on patient admission.

Technologies:
	 jdk 19, java 17, spring boot 2.7.9, spring web, microservice, REST API, OpenAPI, integration
	 testing, JUnit, Hibernate, jpql, MySQL/PostgreSQL, Docker, Jib, Maven, Lombok, HATEOAS

Setup:
-install mysql server then create 'claim-center' schema (not required for container)
-once the app runs, it creates setup data in the db
-for dtos embedded custom fields (foreign keys) included 2 fields id and type, id used when adding data (post meth.) and type when retieving data (get meth.) e.g. physician_i/physician

Resources:
start.spring.io/
springdoc.org/  (integration between spring-boot and swagger-ui)
cloud.google.com/java/getting-started/jib
dev.mysql.com/downloads/windows/installer/8.0.html (Mysql 8.0.32 download)
dev.mysql.com/downloads/workbench/
spring.io/guides/tutorials/rest/ section 'What makes something RESTful'?


Swagger UI:
http://localhost:8080/v3/api-docs
http://localhost:8080/v3/api-docs.yaml
http://localhost:8080/swagger-ui/index.html

Todo:
- fix ClaimModelAssembler claims link should display query params properly in response message
- when calling get claims of the dockerized service, the search jpql query unlike Mysql fails and doesn't run against PostgreSql