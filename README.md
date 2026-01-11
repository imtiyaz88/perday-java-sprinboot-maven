
# Getting Started

# To get MongoDB container up and running:
docker run -d \
  --name perday-mongodb-container1 \
  -p 27017:27017 \
  -v perday-mongodb-volume1:/data/db \
  mongo

# To connect to the MongoDB from Compass
use connection string 
  perday-mongodb-conn1 = mongodb://localhost:27017/
add credentials if needed
create database
  perday-mongodb-database1
create collection in the database
  perday-mongodb-database1-collection1
create document in the collection
  {
  "_id": {
    "$oid": "6963662c7b1a2bd94119c4c6"
  },
  "name": "Imtiyaz",
  "city": "Bangalore",
  "createdAt": {
    "$date": "2026-01-11T00:00:00.000Z"
  }
}
query the document
  { city: "Bangalore" }

# To run the maven app
Open the ExpenseManagerApplication.java and run the main class

# Run all the HTTP method requests 
Open the perday_javaspring.http and run all the requests in sequence.
Update the expense_id_1 and expense_id_2 with the id values returned in the responses to POST requests

# verify the inserted records in the Mongodb
    perday-mongodb-conn1
    |--perday-mongodb-database1 
    |---expenses


### Reference Documentation
For further reference, please consider the following sections:

* [Official Gradle documentation](https://docs.gradle.org)
* [Spring Boot Gradle Plugin Reference Guide](https://docs.spring.io/spring-boot/3.4.3/gradle-plugin)
* [Create an OCI image](https://docs.spring.io/spring-boot/3.4.3/gradle-plugin/packaging-oci-image.html)
* [Spring Web Services](https://docs.spring.io/spring-boot/3.4.3/reference/io/webservices.html)
* [Spring for GraphQL](https://docs.spring.io/spring-boot/3.4.3/reference/web/spring-graphql.html)
* [Spring Data JPA](https://docs.spring.io/spring-boot/3.4.3/reference/data/sql.html#data.sql.jpa-and-spring-data)
* [Spring Boot DevTools](https://docs.spring.io/spring-boot/3.4.3/reference/using/devtools.html)

### Guides
The following guides illustrate how to use some features concretely:

* [Producing a SOAP web service](https://spring.io/guides/gs/producing-web-service/)
* [Building a GraphQL service](https://spring.io/guides/gs/graphql-server/)
* [Accessing Data with JPA](https://spring.io/guides/gs/accessing-data-jpa/)

### Additional Links
These additional references should also help you:

* [Gradle Build Scans – insights for your project's build](https://scans.gradle.com#gradle)

REST API Reference:
https://www.abhijits.com/spring%20boot/spring-boot-getting-started/
https://www.geeksforgeeks.org/spring-boot-database-integration-jpa-hibernate-mysql-h2/
https://docs.spring.io/spring-boot/reference/web/servlet.html


H2:
http://localhost:8080/h2-console/

git:
https://github.com/imtiyaz88/perday
https://docs.github.com/en/migrations/importing-source-code/using-the-command-line-to-import-source-code/adding-locally-hosted-code-to-github
https://docs.github.com/en/authentication/keeping-your-account-and-data-secure/about-authentication-to-github#authenticating-with-the-command-line
https://docs.github.com/en/authentication/connecting-to-github-with-ssh/adding-a-new-ssh-key-to-your-github-account

mac:
To show hidden files in Finder on a Mac, you can use the keyboard shortcut Command + Shift + . 
