# StudentsApp_SpringBoot_RestAPI
Simple rest api client connetcted with a postgres database. Basic functionality, GET, POST, DELETE, PUT

configured postgres in application.poprites: 

spring.datasource.url=jdbc:postgresql://localhost:5432/student
spring.datasource.username=postgres
spring.datasource.password=admin
spring.jpa.hibernate.ddl-auto=create-drop
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect
spring.jpa.properties.hibernate.format_sql=true
server.error.include-message=always

examples of get/post/delete/put
### get showing findALl() from db
GET http://localhost:8080/api/v1/student   

### post - can be used to place a new student in db, in this examples student's name is oskar.
POST http://localhost:8080/api/v1/student
Content-Type: application/json

{
"name": "Oskar",
"email": "chu5j123@op.pl",
"dob": "1992-12-17"
}

### delete - just delete the student giving only his id
DELETE http://localhost:8080/api/v1/student/3

### put - update information about student
PUT http://localhost:8080/api/v1/student/3?email=Oskar53@gmail.com
