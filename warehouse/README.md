# 🏪 Warehouse Management API

A simple **Spring Boot 3** RESTful API for managing a shop’s warehouse inventory — including items, their variants, prices, and stock levels.

---

## 🚀 Features

- CRUD operations for **Items** and **Variants**
- **Stock management** – prevent selling out-of-stock items
- **Data validation**
- **Error handling** with a global exception handler
- **Swagger UI** for interactive API testing
- Uses **PostgreSQL** or **H2** (in-memory) database

---

## 🧩 Tech Stack

| Layer | Technology |
|-------|-------------|
| Language | Java 21 |
| Framework | Spring Boot 3.x |
| Build Tool | Maven |
| Database | PostgreSQL / H2 |
| API Docs | Swagger (SpringDoc OpenAPI 2.x) |
| Persistence | Spring Data JPA (Hibernate) |

---

## 📁 Project Structure

```
src/
 ├── main/
 │   ├── java/com/app/warehouse/
 │   │   ├── controller/     # REST controllers
 │   │   ├── entity/         # JPA entities (Item, Variant)
 │   │   ├── repository/     # Spring Data repositories
 │   │   ├── service/        # Business logic layer
 │   │   ├── exception/      # Custom exceptions + global handler
 │   │   └── WarehouseApplication.java
 │   └── resources/
 │       └── application.yml # Environment configuration
 |
 └── test/
     └── java/...            # Unit tests (future works)
```

---

## ⚙️ Getting Started (Local Setup)

### 1️⃣ Prerequisites
Make sure you have:
- **Java 21+**
- **Maven 3.9+**
- (Optional) **PostgreSQL 16+**

---

### 2️⃣ Clone the Repository

```bash
git clone https://github.com/yourusername/warehouse.git
cd warehouse
```

---

### 3️⃣ Configure Database

By default, the app runs with an **in-memory H2** database.

You can check or modify it in `src/main/resources/application.yml`:

```yaml
spring:
  datasource:
    url: jdbc:h2:mem:warehouse
    driver-class-name: org.h2.Driver
    username: sa
    password:
  h2:
    console:
      enabled: true
  jpa:
    hibernate:
      ddl-auto: update
```

👉 To use PostgreSQL instead, update it as follows:

```yaml
spring:
  datasource:
    url: jdbc:postgresql://localhost:5432/warehouse
    username: warehouse_user
    password: warehouse_pass
  jpa:
    hibernate:
      ddl-auto: update
```

---

### 4️⃣ Build and Run

```bash
mvn clean package
mvn spring-boot:run
```

Once the app starts, open your browser:
- API root → http://localhost:8080/api/items  
- Swagger UI → http://localhost:8080/swagger-ui.html  
- H2 Console → http://localhost:8080/h2-console  

---

## 🧪 API Endpoints (cURL Examples)

### 🟢 Create Item
```bash
curl -X POST http://localhost:8080/api/items   -H "Content-Type: application/json"   -d '{"name":"T-Shirt","description":"Cotton shirt"}'
```

### 🟡 Get All Items
```bash
curl -X GET http://localhost:8080/api/items
```

### 🟠 Add Variant to Item
```bash
curl -X POST http://localhost:8080/api/items/1/variants   -H "Content-Type: application/json"   -d '{"color":"Red","size":"M","price":199000,"stock":10}'
```

### 🔵 Sell a Variant
```bash
curl -X POST "http://localhost:8080/api/variants/1/sell?quantity=2"
```

### 🔴 Delete an Item
```bash
curl -X DELETE http://localhost:8080/api/items/1
```

---

## 🧠 Design Highlights

- **Layered Architecture (Controller → Service → Repository)**  
- **Global Exception Handler** for consistent error responses  
- **DTO-based input validation** using `jakarta.validation`  
- **Transaction-safe stock operations**

---

## 🧰 Common Issues

| Problem | Fix |
|----------|-----|
| `mvn not recognized` | Add Maven to PATH or use Maven Wrapper (`./mvnw`) |
| Swagger error `NoSuchMethodError` | Use Spring Boot ≤ 3.3.x with `springdoc-openapi-starter-webmvc-ui:2.5.0` |
| Database connection refused | Make sure PostgreSQL service is running and credentials match `application.yml` |

---

## 🧾 License

This project is licensed under the MIT License — free to use, modify, and distribute.

---

## 👨‍💻 Author

**Reza Rachman**  
📧 _rezarachman8932@gmail.com_  
💼 _GitHub: [rezarachman8932](https://github.com/rezarachman8932)_

---

_Enjoy building and expanding your warehouse management system!_
