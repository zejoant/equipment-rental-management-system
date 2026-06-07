# Equipment Rental Management System

A Spring Boot REST API project that simulates a real-world equipment rental system inspired by enterprise ERP-style workflows.  
The system allows users to manage equipment, perform checkout/checkin operations, and track rental history.

---

## Features

- Create new equipment
- View all equipment
- View equipment by ID
- Checkout equipment (mark as rented)
- Checkin equipment (mark as available)
- Business rule validation (prevents invalid state changes)
- Rental history tracking (audit log of all actions)

---

## Tech Stack

- Java 21
- Spring Boot
- Spring Web
- Spring Data JPA
- Hibernate
- H2 Database (in-memory)
- Maven
- Lombok

---

## Project Structure

```
src/main/java/com/testproject/taskmanager
├── controller
│   └── EquipmentController.java
├── service
│   └── EquipmentService.java
├── repository
│   ├── EquipmentRepository.java
│   └── RentalHistoryRepository.java
├── model
│   ├── Equipment.java
│   └── RentalHistory.java
└── exception
    └── GlobalExceptionHandler.java
```

---

## How to Run the Project

### Clone the repository

```
git clone https://github.com/zejoant/equipment-rental-management-system.git
cd taskmanager
```

### Run the application
```
mvn spring-boot:run
```

### Open in browser
```
http://localhost:8080
```

---

## API Endpoints

```
GET /equipment
GET /equipment/{id}
POST /equipment
POST /equipment/{id}/checkout
POST /equipment/{id}/checkin
```

---

## Add New Equipment

```
{
  "name": "Camera",
  "description": "DSLR Camera"
}
```

---

## Rental History

Each checkout and checkin action is stored automatically.

Each record contains:
- Equipment ID
- Equipment name (optional extension)
- Action type (CHECKOUT / CHECKIN)
- Status after action
- Timestamp

---

## Example Workflow

1. Create equipment
2. Checkout equipment
3. Checkin equipment
4. View current state
5. Review history log

---

## Example CURL Requests

Create equipment:
```
curl -X POST http://localhost:8080/equipment -H "Content-Type: application/json" -d '{"name":"Camera","description":"DSLR Camera"}'
```

Checkout equipment:
```
curl -X POST http://localhost:8080/equipment/1/checkout
```

Checkin equipment:
```
curl -X POST http://localhost:8080/equipment/1/checkin
```

---

## Future Improvements

- PostgreSQL database integration
- User authentication (Spring Security)
- Role-based access control
- Swagger/OpenAPI documentation
- Docker containerization
- DTO layer separation
- Frontend dashboard (React or Angular)

---

## Author

Built as a learning project to demonstrate:

- Spring Boot backend development
- REST API design
- Layered architecture
- Real-world business logic modeling
