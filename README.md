# spring-boot-poc

A Proof of Concept for a Spring Boot microservice that:
- can serve static files (HTML, CSS, JavaScript, images) in a public and non-public manner
- uses JWT for authentication
- has public and non-public REST endpoints


The microservice can be described overall by the following mindmap:

![image](https://user-images.githubusercontent.com/7413283/152059489-8c9e9a8a-ed3c-488e-aa6d-5081da1b39ae.png)

### Before you start
Run mvn clean install once to have a clean start


### OpenAPI & Swagger
Openapi v3 documentation is available under /v3/api-docs.

Swagger can be accessed under /swagger-ui/index.html

### Postman collection
Postman collection for all REST endpoints can be found in the resources folder.

For all protected endpoint a request against /auth/login is sent in the Pre-Request script to fetch a fresh jwt token, 
which is then used for the actual request. For the time being the combination of "testUsername" and "testPassword" is 
used for the JWT. There is no udnerlying data storage implemented and therefore these values are hardcoded in the filter.
