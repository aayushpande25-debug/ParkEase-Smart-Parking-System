# ParkEase - Smart Parking Management System

ParkEase is a web-based smart parking management system built with Java, Spring Boot, MySQL, HTML, CSS and JavaScript.

## Features
- User registration
- Vehicle registration
- Real-time parking slot availability
- Parking slot booking
- Booking history
- Checkout / vehicle exit
- Automatic parking fee calculation
- Slot becomes AVAILABLE after checkout
- Admin-style dashboard with slot and booking statistics

## Fee Calculation
Parking is charged at **₹20 per started hour**, with a minimum charge of ₹20.

## Technology Stack
- Java
- Spring Boot
- Spring Data JPA / Hibernate
- MySQL
- HTML5, CSS3, JavaScript
- Maven

## Main API Endpoints
- `POST /api/users/register` - Register user
- `POST /vehicles` - Register vehicle
- `GET /vehicles` - View vehicles
- `GET /slots` - View parking slots
- `PUT /slots/{slotNumber}/status?status=OCCUPIED` - Update slot status
- `POST /bookings` - Create booking
- `GET /bookings` - View booking history
- `PUT /bookings/{id}/checkout` - Checkout and calculate fee

## How to Run
1. Create MySQL database:
   `CREATE DATABASE smart_parking_db;`
2. Update MySQL username/password in `src/main/resources/application.properties`.
3. Start the application:
   `./mvnw spring-boot:run`
   On Windows PowerShell:
   `.\mvnw.cmd spring-boot:run`
4. Open:
   `http://localhost:8080`

## Project Structure
- `entity` - Database entities
- `repository` - JPA repositories
- `service` - Business logic
- `controller` - REST APIs
- `static/index.html` - Frontend UI
