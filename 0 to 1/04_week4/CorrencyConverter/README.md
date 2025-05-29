# Currency Converter Spring Boot Application

## Overview
This is a Spring Boot application for converting currencies using a third-party API. It demonstrates RESTful API design, DTO mapping, auditing, and integration with external services. The project also includes configuration for Swagger API documentation and actuator endpoints.

---

## Project Structure
```
src/main/java/com/CorrencyConverter/CorrencyConverter/
├── entity/ # JPA entities
├── Dto/ # Data Transfer Objects
├── auditorAware/ # Auditing configuration and implementation
├── service/ # Business logic
├── appConfig/ # Application configuration
├── controller/ # REST controllers
├── repo/ # Spring Data JPA repositories
└── CorrencyConverterApplication.java # Main Spring Boot application class
src/main/resources/
├── application.properties # Application configuration

---
## Logging

- The application uses SLF4J logging via Lombok’s `@Slf4j` annotation.
- By adding `@Slf4j` to a class, a logger is automatically provided.
- You can log messages at various levels (info, debug, error, etc.) using the provided logger.
- No manual logger instantiation is needed; Lombok handles it for you.
- Logging helps track application flow and debug issues efficiently.

## Features
- **Currency Conversion**: Converts an amount from one currency to another using a third-party API.
- **Auditing**: Tracks who created/modified records using Spring Data JPA auditing.
- **DTO Mapping**: Uses ModelMapper for mapping entities to DTOs.
- **Swagger/OpenAPI**: API documentation available via Swagger UI.
- **Actuator**: Exposes management and info endpoints for monitoring.

---

## Third-Party Services Used
- **Free Currency API**: [https://api.freecurrencyapi.com/](https://api.freecurrencyapi.com/)
  - Used for fetching real-time currency conversion rates.
  - API Key and URL are configured in `application.properties`:
    ```
    currency.api.url=https://api.freecurrencyapi.com/v1/latest
    currency.api.key=YOUR_API_KEY
    ```

---

## Swagger API Documentation
- **Swagger UI** is available at: `http://localhost:8080/swagger-ui/index.html`
- **OpenAPI Docs**: `http://localhost:8080/v3/api-docs`
- If you don't see Swagger, ensure you have the `springdoc-openapi` dependency in your build file (not shown in this summary, but check your `pom.xml` or `build.gradle`).

---

## Auditing
- **AuditingEntity**: Base class for entities to track created/modified by and timestamps.
- **AuditorAwareImpl**: Provides the current auditor (user) for auditing fields.
- **AuditingConfig**: Enables JPA auditing with `@EnableJpaAuditing`.
- **Usage**: All changes to `CurrencyConversion` entities are automatically audited.

---

## Main Steps Done So Far
1. **Project Setup**: Created a Spring Boot project with required dependencies (Spring Web, Spring Data JPA, Lombok, MySQL, ModelMapper, etc.).
2. **Entity Design**: Implemented `CurrencyConversion` and `AuditingEntity` for data persistence and auditing.
3. **DTOs**: Created DTOs for API responses and third-party API integration.
4. **Repository**: Defined `CurrencyConversionRepo` for database operations.
5. **Service Layer**: Implemented `CurrencyConversionService` to handle business logic and third-party API calls using `RestClient`.
6. **Controller**: Exposed a REST endpoint for currency conversion:
    - `GET /currencyConvert/from/{fromCurrency}/to/{toCurrency}/unit/{amount}`
7. **Auditing**: Configured auditing to track changes to entities.
8. **ModelMapper**: Configured for easy mapping between entities and DTOs.
9. **RestClient**: Configured for making HTTP requests to the currency API.
10. **Application Properties**: Set up database, API keys, actuator, and info metadata.
11. **Swagger**: (If not visible, add `springdoc-openapi` dependency) for API documentation.
12. **Actuator**: Enabled all endpoints and custom info in `application.properties`.

---

## How to Run
1. **Configure Database**: Ensure MySQL is running and update credentials in `application.properties`.
2. **Set API Key**: Replace the placeholder API key in `application.properties` with your own from Free Currency API.
3. **Build & Run**:
    - Using Maven: `mvn spring-boot:run`
    - Or run from your IDE.
4. **Access API**: Use the endpoint as shown above to perform currency conversions.
5. **Swagger UI**: Visit `http://localhost:8080/swagger-ui/index.html` for API docs and testing.

---

## Troubleshooting & Reference
- If you get stuck, refer to the steps above to check your progress.
- Check logs for errors related to database, API calls, or configuration.
- Ensure all dependencies are present in your build file.
- For auditing issues, check the `auditorAware` package and configuration.
- For Swagger, ensure the correct dependency and check the application properties for the correct URL.

---

## Author
- Rohit Singh Sirohi
- Date: 27th May 