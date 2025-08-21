# StayBook – Hotel Booking System

StayBook is a **Spring Boot and PostgreSQL based hotel booking system** that demonstrates
end-to-end full stack development skills. It provides REST APIs for user management,
hotel listings, and room bookings. The project is designed with clean architecture,
ready for extension into microservices and AWS deployment.

## ✨ Features
- User management (register, view, roles: ADMIN / CUSTOMER)
- Hotel management (create, list, pricing, locations)
- Room booking (create, list bookings with check-in/out dates)
- REST APIs with Spring Web
- Database persistence with Spring Data JPA + PostgreSQL
- Maven Wrapper included for easy build

## 🛠 Tech Stack
- **Backend**: Java 21, Spring Boot 3, Spring Data JPA
- **Database**: PostgreSQL
- **Build Tool**: Maven
- **Deployment Ready**: Docker, AWS Free Tier

## 🚀 Getting Started

### Prerequisites
- JDK 21
- PostgreSQL 16+
- Maven (or Maven Wrapper `./mvnw`)

### Setup
1. Clone the repo:
   ```bash
   git clone https://github.com/jayanth539/staybook.git
   cd staybook
   
2. Update src/main/resources/application.yml with your PostgreSQL credentials.
3. Run the application:
   ```bash
   ./mvnw spring-boot:run
   ```
4. Access the API at `http://localhost:8080/api`.
5. Use tools like Postman or cURL to test the endpoints.

### Example API Endpoints

#### Create Hotel
```bash
curl -X POST http://localhost:8080/api/hotels \
-H "Content-Type: application/json" \
-d '{"name":"Marriott Hyderabad","location":"Gachibowli","pricePerNight":4500}'
```

#### List Hotels
```bash
curl -X GET http://localhost:8080/api/hotels
```

#### Create User
```bash
curl -X POST http://localhost:8080/api/users \
-H "Content-Type: application/json" \
-d '{"username":"jayanth","password":"secret","role":"CUSTOMER"}'
```

#### List Users
```bash
curl -X GET http://localhost:8080/api/users
```


#### Create Booking
```bash
curl --location 'http://localhost:8080/api/bookings' \
--header 'Content-Type: application/json' \
--header 'Cookie: JSESSIONID=491FD63F69D7E0C6B6774F648DEC1EA6' \
--data '{
    "checkInDate": "2025-09-01",
    "checkOutDate": "2025-09-05",
    "user": {
        "id": 1
    },
    "hotel": {
        "id": 1
    }
}'
```

#### List Bookings
```bash
curl -X GET http://localhost:8080/api/bookings
```