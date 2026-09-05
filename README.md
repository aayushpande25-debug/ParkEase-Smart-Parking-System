# 🚗 ParkEase – Smart Parking Management System

ParkEase is a **Smart Parking Management System** developed to simplify and manage parking operations digitally. The system allows users to register, add their vehicles, view parking slots, and book available parking spaces through a web-based interface.

The application is built using **Java and Spring Boot** for the backend, **MySQL** for database management, and **HTML, CSS, and JavaScript** for the frontend.

---

## 📌 Project Overview

Finding and managing parking spaces manually can be time-consuming and inefficient. ParkEase provides a centralized system for managing parking slots, users, vehicles, and bookings.

The system maintains parking slot availability and updates the slot status when a booking is made, helping users and administrators manage parking efficiently.

---

## ✨ Features

* 👤 **User Registration**

  * Register users with name, email, password, phone number, and role.
  * Supports `USER` and `ADMIN` roles.

* 🚘 **Vehicle Registration**

  * Register vehicles with vehicle number, vehicle type, and owner name.
  * Supports different vehicle types such as cars and bikes.

* 🅿️ **Parking Slot Management**

  * Add parking slots to the system.
  * View all available parking slots.
  * Maintain parking slot status.

* 📅 **Parking Booking**

  * Book a parking slot using vehicle and slot details.
  * Automatically records the entry time.
  * Updates the parking slot status from `AVAILABLE` to `OCCUPIED`.

* 📊 **Booking Management**

  * View registered parking bookings.
  * Stores vehicle number, slot number, entry time, exit time, and amount.

* 🌐 **REST APIs**

  * Backend functionality is exposed through RESTful APIs.

---

## 🛠️ Technologies Used

| Technology          | Purpose                                    |
| ------------------- | ------------------------------------------ |
| **Java**            | Backend application development            |
| **Spring Boot**     | Building the backend and REST APIs         |
| **Spring Data JPA** | Database operations and ORM                |
| **Hibernate**       | Object-relational mapping                  |
| **MySQL**           | Database management                        |
| **HTML**            | Frontend structure                         |
| **CSS**             | Frontend styling                           |
| **JavaScript**      | Frontend interaction and API communication |
| **Maven**           | Dependency and project management          |
| **Git & GitHub**    | Version control and project hosting        |
| **VS Code**         | Development environment                    |

---

## 🏗️ Project Architecture

The backend follows a layered architecture:

```text
                    ┌─────────────────────┐
                    │     Frontend        │
                    │ HTML / CSS / JS     │
                    └──────────┬──────────┘
                               │
                               ▼
                    ┌─────────────────────┐
                    │    Controllers      │
                    │    REST APIs        │
                    └──────────┬──────────┘
                               │
                               ▼
                    ┌─────────────────────┐
                    │      Services       │
                    │ Business Logic       │
                    └──────────┬──────────┘
                               │
                               ▼
                    ┌─────────────────────┐
                    │    Repositories     │
                    │   Spring Data JPA   │
                    └──────────┬──────────┘
                               │
                               ▼
                    ┌─────────────────────┐
                    │       MySQL         │
                    │      Database       │
                    └─────────────────────┘
```

---

## 📂 Project Structure

```text
ParkEase-Smart-Parking-System/
│
├── .mvn/
│   └── wrapper/
│
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/aayush/smart_parking_system/
│   │   │       │
│   │   │       ├── controller/
│   │   │       │   ├── BookingController.java
│   │   │       │   ├── HomeController.java
│   │   │       │   ├── ParkingSlotController.java
│   │   │       │   ├── UserController.java
│   │   │       │   └── VehicleController.java
│   │   │       │
│   │   │       ├── entity/
│   │   │       │   ├── Booking.java
│   │   │       │   ├── ParkingSlot.java
│   │   │       │   ├── User.java
│   │   │       │   └── Vehicle.java
│   │   │       │
│   │   │       ├── repository/
│   │   │       │   ├── BookingRepository.java
│   │   │       │   ├── ParkingSlotRepository.java
│   │   │       │   ├── UserRepository.java
│   │   │       │   └── VehicleRepository.java
│   │   │       │
│   │   │       ├── service/
│   │   │       │   ├── BookingService.java
│   │   │       │   ├── ParkingSlotService.java
│   │   │       │   ├── UserService.java
│   │   │       │   └── VehicleService.java
│   │   │       │
│   │   │       └── SmartParkingSystemApplication.java
│   │   │
│   │   └── resources/
│   │       ├── static/
│   │       │   └── index.html
│   │       └── application.properties
│   │
│   └── test/
│       └── java/
│
├── .gitignore
├── .gitattributes
├── mvnw
├── mvnw.cmd
├── pom.xml
└── README.md
```

---

## 🗄️ Database

ParkEase uses **MySQL** as its relational database.

### Main Tables

#### Users

Stores registered user information.

```text
id
full_name
email
password
phone_number
role
```

#### Vehicles

Stores vehicle information.

```text
id
vehicle_number
vehicle_type
owner_name
```

#### Parking Slots

Stores parking slot information.

```text
id
slot_number
vehicle_type
status
```

#### Bookings

Stores parking booking information.

```text
id
vehicle_number
slot_number
entry_time
exit_time
amount
```

---

## 🔄 How the System Works

### 1. User Registration

The user enters their personal information through the frontend.

```text
User
  ↓
Registration Form
  ↓
UserController
  ↓
UserService
  ↓
UserRepository
  ↓
MySQL
```

### 2. Vehicle Registration

The user registers their vehicle by providing the vehicle number, vehicle type, and owner name.

```text
Vehicle Details
      ↓
VehicleController
      ↓
VehicleService
      ↓
VehicleRepository
      ↓
MySQL
```

### 3. Parking Slot Management

Parking slots are stored in the database along with their type and current status.

Example:

```text
A01 → AVAILABLE
A02 → AVAILABLE
A03 → OCCUPIED
```

### 4. Parking Booking

When a user books an available parking slot:

```text
Select Vehicle
      ↓
Select Parking Slot
      ↓
Create Booking
      ↓
Record Entry Time
      ↓
Update Slot Status
      ↓
AVAILABLE → OCCUPIED
```

---

## 🔗 REST API Endpoints

### 👤 User APIs

| Method | Endpoint | Description              |
| ------ | -------- | ------------------------ |
| POST   | `/users` | Register a new user      |
| GET    | `/users` | Get all registered users |

### 🚘 Vehicle APIs

| Method | Endpoint    | Description        |
| ------ | ----------- | ------------------ |
| POST   | `/vehicles` | Register a vehicle |
| GET    | `/vehicles` | Get all vehicles   |

### 🅿️ Parking Slot APIs

| Method | Endpoint | Description           |
| ------ | -------- | --------------------- |
| POST   | `/slots` | Add a parking slot    |
| GET    | `/slots` | Get all parking slots |

### 📅 Booking APIs

| Method | Endpoint    | Description              |
| ------ | ----------- | ------------------------ |
| POST   | `/bookings` | Create a parking booking |
| GET    | `/bookings` | Get all bookings         |

---

## ⚙️ Installation and Setup

### Prerequisites

Make sure the following are installed:

* Java
* Maven
* MySQL
* Git
* VS Code or another Java IDE

### 1. Clone the Repository

```bash
git clone https://github.com/YOUR-USERNAME/ParkEase-Smart-Parking-System.git
```

### 2. Open the Project

Open the cloned project in VS Code or your preferred Java IDE.

### 3. Create the MySQL Database

Open MySQL and create the database:

```sql
CREATE DATABASE smart_parking_db;
```

### 4. Configure MySQL

Update the database configuration in:

```text
src/main/resources/application.properties
```

Example:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/smart_parking_db
spring.datasource.username=root
spring.datasource.password=YOUR_MYSQL_PASSWORD
```

**Do not commit your real database password to GitHub.**

### 5. Run the Application

Using Maven:

```bash
mvn spring-boot:run
```

Or on Windows:

```bash
.\mvnw.cmd spring-boot:run
```

### 6. Open the Application

After the application starts, open:

```text
http://localhost:8080
```

---

## 🧪 Testing

The project includes a test structure using Spring Boot testing support.

Tests can be executed using:

```bash
mvn test
```

or:

```bash
.\mvnw.cmd test
```

---

## 🚀 Future Enhancements

The following features can be added in future versions:

* 🔐 Secure user authentication and authorization
* 👨‍💼 Admin dashboard
* 💳 Online parking payment
* 📱 Responsive mobile-friendly interface
* 📍 GPS/location-based parking search
* 🔔 Booking notifications
* 🕐 Automatic exit-time tracking
* 💰 Automatic parking fee calculation
* 📊 Parking analytics and reports
* 🔎 Advanced parking-slot search and filtering
* ☁️ Cloud deployment

---

## 🎯 Project Objectives

* Reduce the difficulty of finding and managing parking spaces.
* Digitize parking slot management.
* Maintain real-time parking slot status.
* Simplify vehicle and booking management.
* Provide a scalable backend using Spring Boot and MySQL.
* Demonstrate practical implementation of REST APIs and database integration.

---

## 👨‍💻 Developer

**Aayush Pande**

**Project:** ParkEase – Smart Parking Management System

**Domain:** Web Development / Backend Development

**Technologies:** Java • Spring Boot • MySQL • HTML • CSS • JavaScript

---

## 📄 License

This project is developed for **educational and academic purposes**.
