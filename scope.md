
# URL Shortener

## What is this project about?

This project converts large and complex URLs into shorter, more manageable URLs. The generated short URL redirects users to the same destination as the original URL, ensuring the same functionality while making links easier to share, use, and remember.

---

## Project Setup

- **Language:** Java
- **Build Tool:** Maven
- **Java Version:** 17
- **Spring Boot Version:** 4.2.0
- **Packaging Type:** JAR
- **IDE:** IntelliJ IDEA

---

## Required Dependencies

### Spring Boot Web MVC

Used to build a web-based application and develop RESTful APIs. It provides the embedded web server and essential components required for handling HTTP requests and responses.

### H2 Database

H2 is a lightweight, fast, and in-memory database that is ideal for rapid prototyping, development, and testing. It allows data to be stored and managed efficiently during the initial stages of application development.

### Lombok

Lombok is a Java annotation-based library that reduces boilerplate code by automatically generating getters, setters, constructors, and other commonly used methods.

---
`27/11/2026`

## What I Have Developed So Far

### 1. ShortUrlEntity

This is an entity class located in the `model` package. It is responsible for collecting URL data and mapping the request body received from the client.

This class stores information such as:

- Original URL
- Generated short URL
- Short URL code

### 2. ShortUrlController

This controller handles incoming HTTP requests and exposes the application's REST APIs.

Currently implemented:

- POST endpoint
- GET endpoint

#### POST Endpoint

When a client sends a POST request containing a URL in the request body, the request is first received by Spring Boot's `DispatcherServlet`.

The `DispatcherServlet` maps the request to the appropriate controller method based on the configured URL path (for example, `/api/url`).

The controller then delegates the request to the service layer, where the business logic is executed to generate a short URL and store the URL mapping.

#### GET Endpoint

When a client sends a GET request with a short URL code, the request is routed by the `DispatcherServlet` to the corresponding controller method.

The controller invokes the service layer to retrieve the original URL associated with the short code and returns the result to the client.

### 3. ShortUrlService

This service class contains the business logic of the application.

#### Current Responsibilities

- Storing URL mappings in a `HashMap`
- Generating unique short codes for URLs
- Retrieving the original URL based on the generated short code
- Processing requests received from the controller layer

---

## Architecture Flow

```text
Client
   |
   v
Controller (ShortUrlController)
   |
   v
Service (ShortUrlService)
   |
   v
HashMap / Database
   |
   v
Response to Client
