<h1>Name check application</h1>

<h3> Description </h3>

Application allows user to check probability of nationality based on their name. It is using global API:

> https://api.nationalize.io

Localhost port is 8081.

<h3>Features</h3>
After entering name using below endpoint:

Get method
> http://localhost:8081/persons/name/{name}

results of searching is added to build in H2 database.

To see all of added entities please use:

Get method
> http://localhost:8081/persons

It is also possible to get person by id:

Get method
> http://localhost:8081/persons/{id}

And to delete person by id:

Delete method
> http://localhost:8081/persons/{id}
>
<h3>Tech stack</h3>

- Java 11
- Maven
- Spring-boot
- Lombok
- H2 db
- Junit
- MockMvc

<h3>Running</h3>

> mvn spring-boot:run

<h3>Author</h3>

Piotr Boczar