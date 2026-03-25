#  NeoBank Backend Platform

A production-style **Spring Boot banking backend system** demonstrating clean architecture, event-driven design with Kafka, and cloud-ready deployment using Docker and Kubernetes.

---

##  Project Overview

NeoBank Backend simulates a **digital banking system** where users can:

* Register and authenticate (JWT-based)
* Create and manage accounts
* Transfer money between accounts
* Process transactions asynchronously using Kafka

This project is designed to reflect **real-world backend engineering practices** used in fintech and enterprise systems.

---

##  Architecture

The system follows a **layered architecture** with event-driven extensions:

###  Core Layers

* **Controller Layer**

  * Handles HTTP requests and responses
  * Example: `AuthController`, `BankingController`

* **Service Layer**

  * Contains business logic (money transfer, validation)
  * Ensures separation of concerns

* **Repository Layer**

  * Handles database access via Spring Data JPA

* **DTO Layer**

  * Transfers structured data between layers

---

###  Event-Driven Flow (Kafka)

1. User initiates a money transfer
2. Transaction is processed synchronously
3. A **Kafka event** is published (`TransactionEvent`)
4. Consumers handle it asynchronously (e.g. logging, notifications)

 This mimics **real fintech systems** where operations are decoupled and scalable.

---

###  Infrastructure

* **Database:** PostgreSQL
* **Messaging:** Apache Kafka
* **Containerization:** Docker
* **Orchestration:** Kubernetes
* **API Docs:** Swagger

---

##  Tech Stack

* Java 17
* Spring Boot
* Spring Security (JWT)
* Spring Data JPA
* Apache Kafka
* PostgreSQL
* Docker & Docker Compose
* Kubernetes
* JUnit

---

##  API Endpoints

###  Authentication

#### Register

```
POST /auth/register
```

```json
{
  "username": "user1",
  "password": "password123"
}
```

---

#### Login

```
POST /auth/login
```

```json
{
  "username": "user1",
  "password": "password123"
}
```

 Response:

```
JWT TOKEN
```

---

###  Money Transfer

```
POST /api/transfer
```

```json
{
  "fromAccountId": 1,
  "toAccountId": 2,
  "amount": 100
}
```

 Response:

```
Transfer successful
```

---

##  Screenshots (Example)

### Swagger UI

---

### Kafka Event Flow (Concept)

---

### Kubernetes Deployment

---

##  How to Run

### 1. Build the project

```
mvn clean package
```

### 2. Start services (PostgreSQL + Kafka)

```
docker-compose up
```

### 3. Run the application

```
java -jar target/neo-bank.jar
```

---

### ☁️ Kubernetes Deployment

```
kubectl apply -f k8s/
```

---

## 🧪 Testing

Run tests using:

```
mvn test
```

---

##  Why This Project Stands Out

* Demonstrates **real backend architecture**
* Uses **event-driven design (Kafka)**
* Shows **cloud-native deployment (Docker + Kubernetes)**
* Includes **authentication, transactions, and persistence**
* Follows **clean code and layered design principles**








