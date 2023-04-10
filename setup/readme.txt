-tech: java 17, spring boot, hibernate, jpql, Mysql, spring web, microservice, rest api, integration testing

-install mysql server then create 'claim-center' schema
- once the app is run it creates setup data in the db
-for dtos embedded custom fields (foreign keys) included 2 fields id and type,
  id used in post and type in get. eg. physician_id & physician
-card no. is validated prior to db call (optimization)

resources:
-Mysql 8.0.32 download: https://dev.mysql.com/downloads/windows/installer/8.0.html
-https://spring.io/guides/tutorials/rest/ section 'What makes something RESTful'?
-https://springdoc.org/  (integration between spring-boot and swagger-ui)
http://localhost:8080/v3/api-docs
http://localhost:8080/v3/api-docs.yaml
http://localhost:8080/swagger-ui/index.html

todo:
- swagger inspector api doc. - Swagger (OpenAPI)
- same db for net & java versions?
- fix ClaimModelAssembler claims link should display query params properly in response message
- publish online (private/public?)
- dockerize/compose


-3,335m:620 + 560 + 265 + 355 + 200 + 120 + 245 + 260 + 205 + 180 + 325 in 11 days
+125m pres. .docx
+90m onsite pres.