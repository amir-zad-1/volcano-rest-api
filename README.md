# Volcano REST-API Service 

#### Run the tests (integration and unit)
    mvn test
    
#### Run the project
    mvn spring-boot:run
    curl localhost:8080

### Endpoints
     1. http://localhost:8080/ [GET]
     2. http://localhost:8080/users [GET, POST, PUT, DELETE]
     3. http://localhost:8080/reservations [GET, POST, PUT, DELETE]