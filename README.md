# Volcano REST-API Service 

#### Run Integration Tests
 Note: Requires node.js to be installed.
    
     cd [root path of repository]
     mvn spring-boot:run&
     cd testApp
     npm i
     mocha integrationTests.js
     
![Test Results](https://uc5366370021ea8195d5f3b6da89.dl.dropboxusercontent.com/cd/0/inline/AUnzDhOfQPBNI7dzXzB32ZThsH7i2wVHcNc4BTLrmv_r7nXwQ5Avold4C__ra9YhoXy66R8xjElykRnyV8tYP7J4EmO-vF1talwDOGZSzHTm0u-xjXa6hqwvvwNsi0x22tGsXP0qvZqmeU4dl8dIzIIyXh68O9_k63D2U9W2YGadlZCNr1TMlhSjDdyPyllDGvE/file "Test Cases")

    
#### Run the Project
    mvn spring-boot:run
    curl localhost:8080

#### Endpoints
     1. http://localhost:8080/
        1.1 [GET] => Returns basic information about the API.
     
     2. http://localhost:8080/reset 
        2.1 [POST]=> Deletes all data and resets the service.
     
     3. http://localhost:8080/reservations/availabledates
        3.1 [GET] => Returns all available dates.
     
     4. http://localhost:8080/reservations
        4.1 [GET] => Returns all reservations.
        4.2 [GET]/[reservationid] => Returns the reservation with the given id.
        4.3 [POST] => Makes a new reservation according to the rules.
        4.4 [PUT] => Updates a new reservation according to the rules.
        4.5 [DELETE] => Cancels the reservation with the given id.
