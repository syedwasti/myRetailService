# myRetail RESTful service

myRetail is a rapidly growing company with HQ in Richmond, VA and over 200 stores across the east coast. myRetail wants to make its internal data available to any number of client devices, from myRetail.com to native mobile apps.

The goal for this exercise is to create an end-to-end Proof-of-Concept for a products API, which will aggregate product data from multiple sources and return it as JSON to the caller.

Your goal is to create a RESTful service that can retrieve product and price details by ID. The URL structure is up to you to define, but try to follow some sort of logical convention.

Build an application that performs the following actions:
    
* Responds to an HTTP GET request at /products/{id} and delivers product data as JSON (where {id} will be a number.
* Example product IDs: 13860428, 54456119, 13264003, 12954218)
* Example response: {"id":13860428,"name":"The Big Lebowski (Blu-ray) (Widescreen)","current_price":{"value": 13.49,"currency_code":"USD"}}
* Performs an HTTP GET to retrieve the product name from an external API. (For this exercise the data will come from redsky.target.com, but let’s just pretend this is an internal resource hosted by myRetail)  
* Example: [Get Sample Data from here; ](https://redsky.target.com/v3/pdp/tcin/13860428?excludes=taxonomy,price,promotion,bulk_ship,rating_and_review_reviews,rating_and_review_statistics,question_answer_statistics&key=candidate)
* Reads pricing information from a NoSQL data store and combines it with the product id and name from the HTTP request into a single response.  
* BONUS: Accepts an HTTP PUT request at the same path (/products/{id}), containing a JSON request body similar to the GET response, and updates the product’s price in the data store.  

## myRetail RESTful service Platform: 
* Java version 11
* Spring Boot Version 2.4.2
* MongoDB Community Version 4.4.3
* Maven Build System
* Swagger Version 2.9.2 for API Documentation

## RESTApi's:
1. GET /api/v1/products/{id} (Retrieves the product name from an external/Redsky API and pricing information from MongoDB)
2. PUT /api/v1/products/{id} (Updates product pricing for the given id in MongoDB)
3. GET /api/v1/products (Lists all products from MongoDB)
4. POST /api/v1/products (Creates a new Prodcut record in MongoDB)
5. Delete /api/v1/products/{id} (Deletes the record from MongoDB)
6. Swagger API Documentaion /swagger-ui.html#/

## Usefull commands to Run the app:
* Start MongoDB Locally: brew services start mongodb-community@4.4
* To check Services running: brew service list  
* To build the app: mvn clean install
* To Run the app: 
    * java -jar target/myRetailService-0.0.1-SNAPSHOT.jar
    * mvn spring-boot:run
* Tu build and run: mvn clean install spring-boot:run  
* To Stop MongoDB: brew services stop mongodb-community@4.4

