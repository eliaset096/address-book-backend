# address-book-bakend

Es una sencilla implentación en Spring Boot del CRUD de una libreta de contactos.


## Funcionalidades 

* La libreta de contactos permite agregar un contato
* La libreta de contactos permite modificar un contato 
* La libreta de contactos permite eliminar un contato
* La libreta de contactos permite listar los contactos

### Credenciales base de datos Postgres


>usuario: `ab_root`,

>pasword: `ab_password`

>puerto: `ab_password`

>url: `jdbc:postgresql://localhost:5432/Address_Book`




### Para correr el proyecto

> ./mvnw install

> ./mvnw clean spring-boot:run


## Endpoints


GET: http://localhost:9595/api/address-book/contacts

GET: http://localhost:9595/api/address-book/cont-id/5

GET: http://localhost:9595/api/address-book/first-name/Santi

GET: http://localhost:9595/api/address-book/last-name/Doe

POST: http://localhost:9595/api/address-book/add

POST: http://localhost:9595/api/address-book/update

POST: http://localhost:9595/api/address-book/delete
