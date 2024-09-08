# Payment Processor API 🏦

![Java](https://img.shields.io/badge/Java-17-blue)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.3.3-brightgreen)
![Hibernate Search](https://img.shields.io/badge/Hibernate%20Search-7.2.0-yellowgreen)
![PostgreSQL](https://img.shields.io/badge/PostgreSQL-%3E%3D12-blue)
![Opensearch](https://img.shields.io/badge/Opensearch-2.16-orange)
![Redis](https://img.shields.io/badge/Redis-7.4.0-red)

## Overview 📖

The **Payment Processor API** is a robust and scalable solution designed for processing and managing payments. The project is built using modern Java practices and leverages the power of **Spring Boot**, **Hibernate Search**, **Opensearch** and **Redis** to provide efficient and scalable search capabilities over payment data.

## Features ✨

- **Domain-Driven Design (DDD)**: The project follows the principles of DDD, ensuring that the business logic is encapsulated within the domain layer.
- **Hibernate Search**: Integrated with Opensearch to provide full-text search capabilities.
- **PostgreSQL**: Used as the primary relational database for persistence.
- **Redis**: Used to cache results after GET operations.
- **Modular Architecture**: The project is organized into multiple modules for better separation of concerns and maintainability.

## Project Structure 🏗️

The project is divided into several modules, each with a specific responsibility:

### 1. `payment-processor-domain`
This module contains the core business logic and domain models. The domain models are implemented using plain Java objects (POJOs) and are responsible for enforcing business rules.

### 2. `payment-processor-repository`
This module handles the data persistence logic. It maps domain models to the database entities using **JPA** and **Hibernate Search**. The repository layer interacts with PostgreSQL and Opensearch.

### 3. `payment-processor-service`
The service layer contains business services that orchestrate the operations between the domain and repository layers. It uses **DTOs** (Data Transfer Objects) to transfer data between layers.

### 4. `payment-processor-api`
This module exposes RESTful APIs for external clients. It handles HTTP requests and responses and interacts with the service layer to process payments and perform searches.

---
## Setup and Installation 🚀

To get started with the project, follow these steps:

### **Prerequisites**

* Java 17
* Maven 3.8+
* PostgreSQL 12+
* Opensearch 2.16

### **Steps**

- Clone the repository
- Build the project
```bash
mvn clean install
```
- Start the infrastructure using Docker Compose:

```bash
  cd infrastructure
  docker-compose up
```
- Run the application.
```bash
mvn spring-boot:run
```

- To stop and remove the infrastructure run the following:
```bash
docker-compose down -v
```

### **View data**

If you want to check what is happening behind the scenes, you can access the following urls:

For Opensearch:
- http://localhost:5601/app/opensearch-query-workbench#/

For Postgres:
- http://localhost:8080/

---
## API Endpoints 📡

### 1. Create Payment
- **Endpoint**: `/api/payments`
- **Method**: `POST`
- **Request Body**:
  ```json
  {
    "description": "Payment for order #12345",
    "amount": 100.00
  }
  ```

### 2. Search Payments by Description
- **Endpoint**: `/api/payments/search?description={INSERT_YOUR_TERM_HERE}`
- **Method**: `GET`
- **Response Body**:
  ```json
  [
  {
    "id": 1,
    "description": "Payment for order #12345",
    "amount": 100.00
  },
  {
    "id": 2,
    "description": "Payment for order #67890",
    "amount": 50.00
  }
  ]
  ```
### 3. Search Payments by Description Paginated
- **Endpoint**: `/api/payments/search-paginated?description={YOUR_TERM_HERE}&page=0&size=10`
- **Method**: `GET`
- **Response Body**:
  ```json
  {
    "content": [
    {
        "id": 3,
        "description": "Payment for government",
        "amount": 50.0
    },
    {
      "id": 5,
      "description": "Payment for government",
      "amount": 50.0
    }
    ],
    "pageable": {
      "pageNumber": 0,
      "pageSize": 20,
      "sort": {
        "empty": true,
        "sorted": false,
        "unsorted": true
      },
      "offset": 0,
      "paged": true,
      "unpaged": false
    },
    "last": true,
    "totalElements": 2,
    "totalPages": 1,
    "size": 20,
    "number": 0,
    "sort": {
      "empty": true,
      "sorted": false,
      "unsorted": true
    },
    "first": true,
    "numberOfElements": 2,
    "empty": false
  }
  ```
---
## Acknowledgments 🎉
- [Spring Boot](https://spring.io/projects/spring-boot)
- [Hibernate Search](https://docs.jboss.org/hibernate/search/7.2/reference/en-US/html_single/index.html#backend-elasticsearch-compatibility-opensearch)
- [PostgreSQL](https://hub.docker.com/_/postgres)
- [Opensearch](https://opensearch.org/docs/latest/install-and-configure/install-opensearch/docker/)
