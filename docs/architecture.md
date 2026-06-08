# AgriRent Architecture

## High Level Architecture

User
  |
  v
React Frontend
  |
  | HTTPS / REST API
  v
Spring Boot Backend
  |
  | JPA/Hibernate
  v
PostgreSQL Database

## Frontend Layer
Responsibilities:
- Authentication UI
- Machine Listing
- Machine Management
- Booking Management
- Dashboard

Technology:
- React

## Backend Layer
Responsibilities:
- Authentication
- Authorization
- Machine Management
- Booking Management
- Business Rules

Technology:
- Spring Boot
- Spring Security
- JPA/Hibernate

## Database Layer
Responsibilities:
- Store Users
- Store Machines
- Store Bookings

Technology:
- PostgreSQL