# 🎟️ Ticket Booking System

A full-stack ticket booking application built with **Java Spring Boot** (backend) and **Next.js** (frontend).

## 📋 Features

- ✅ View all available events
- ✅ Book tickets for events
- ✅ Real-time seat availability validation
- ✅ Prevents overbooking with synchronized booking
- ✅ Beautiful, modern UI with animations
- ✅ Responsive design for all devices
- ✅ Form validation and error handling

## 🛠️ Technology Stack

### Backend
- **Java 17**
- **Spring Boot 3.2.0**
- **Spring Data JPA** - Database operations
- **H2 Database** - In-memory database (easily switchable to PostgreSQL/MySQL)
- **Maven** - Build tool

### Frontend
- **Next.js 14+** - React framework
- **TypeScript** - Type safety
- **Modern CSS** - Premium design with gradients and animations

## 📁 Project Structure

```
ticket-booking-frontend/
├── ticket-booking-backend/          # Backend (Spring Boot)
│   ├── src/main/java/com/ticketbooking/
│   │   ├── model/                   # Entities (Event, Booking)
│   │   ├── repository/              # Data access layer
│   │   ├── service/                 # Business logic
│   │   ├── controller/              # REST API endpoints
│   │   ├── dto/                     # Data transfer objects
│   │   ├── exception/               # Error handling
│   │   ├── config/                  # CORS configuration
│   │   └── TicketBookingApplication.java
│   ├── src/main/resources/
│   │   ├── application.properties   # Configuration
│   │   └── data.sql                 # Sample data
│   └── pom.xml                      # Maven dependencies
│
├── app/                             # Next.js app directory
│   ├── page.tsx                     # Main page
│   └── globals.css                  # Styles
├── components/                      # React components
│   ├── EventCard.tsx               # Event display
│   └── BookingModal.tsx            # Booking form
├── services/                        # API integration
│   └── api.ts                      # Backend API calls
└── types/                           # TypeScript types
    └── index.ts
```

## 🚀 Getting Started

### Prerequisites

1. **Java 17 or higher** - [Download here](https://www.oracle.com/java/technologies/downloads/)
2. **Maven** - [Download here](https://maven.apache.org/download.cgi)
3. **Node.js 18+** - [Download here](https://nodejs.org/)

### Backend Setup

1. Navigate to the backend directory:
```bash
cd ticket-booking-backend
```

2. Run the Spring Boot application:
```bash
mvn spring-boot:run
```

The backend will start on **http://localhost:8080**

**Available endpoints:**
- `GET http://localhost:8080/api/events` - Get all events
- `GET http://localhost:8080/api/events/{id}` - Get event by ID
- `POST http://localhost:8080/api/bookings` - Create booking

**H2 Database Console:**
- URL: http://localhost:8080/h2-console
- JDBC URL: `jdbc:h2:mem:ticketdb`
- Username: `sa`
- Password: (leave empty)

### Frontend Setup

1. Navigate to the frontend directory:
```bash
cd ticket-booking-frontend
```

2. Install dependencies (if not already installed):
```bash
npm install
```

3. Start the development server:
```bash
npm run dev
```

The frontend will start on **http://localhost:3000**

## 📖 How to Use

1. **Start the backend** (Spring Boot) on port 8080
2. **Start the frontend** (Next.js) on port 3000
3. **Open your browser** to http://localhost:3000
4. **Browse events** - View all available events with details
5. **Book tickets** - Click "Book Now" on any event
6. **Fill the form** - Enter your name, email, and number of seats
7. **Submit** - Your booking will be created and seats updated

## 🎨 Code Features

### Clean & Readable Code
- ✅ **Comprehensive comments** explaining every class and method
- ✅ **Clear naming** - Variables and functions are self-documenting
- ✅ **Simple structure** - Easy to understand and maintain
- ✅ **Reusable components** - Modular design

### Backend Highlights
- **MVC Architecture** - Clear separation of concerns
- **Synchronized Booking** - Prevents race conditions
- **Validation** - Input validation with helpful error messages
- **Exception Handling** - Global error handler for consistent responses
- **CORS Configuration** - Properly configured for frontend

### Frontend Highlights
- **TypeScript** - Type safety throughout
- **Component-based** - Reusable React components
- **API Service Layer** - Centralized API calls
- **Premium UI** - Modern design with animations
- **Responsive** - Works on all screen sizes

## 🔧 Configuration

### Switch to PostgreSQL/MySQL

Edit `application.properties`:

```properties
# PostgreSQL
spring.datasource.url=jdbc:postgresql://localhost:5432/ticketdb
spring.datasource.username=your_username
spring.datasource.password=your_password
spring.jpa.database-platform=org.hibernate.dialect.PostgreSQLDialect

# MySQL
spring.datasource.url=jdbc:mysql://localhost:3306/ticketdb
spring.datasource.username=your_username
spring.datasource.password=your_password
spring.jpa.database-platform=org.hibernate.dialect.MySQLDialect
```

Add the appropriate driver dependency to `pom.xml`.

## 📝 API Examples

### Get All Events
```bash
curl http://localhost:8080/api/events
```

### Create Booking
```bash
curl -X POST http://localhost:8080/api/bookings \
  -H "Content-Type: application/json" \
  -d '{
    "eventId": 1,
    "customerName": "John Doe",
    "customerEmail": "john@example.com",
    "numberOfSeats": 2
  }'
```

## 🎯 Key Implementation Details

### Seat Validation
The `BookingService` uses `synchronized` method to prevent multiple users from booking the same seats simultaneously. This ensures data consistency.

### Error Handling
The `GlobalExceptionHandler` catches all exceptions and returns user-friendly JSON responses with appropriate HTTP status codes.

### CORS
Configured to allow requests from `http://localhost:3000` (frontend) to `http://localhost:8080` (backend).

## 📄 License

This project is open source and available for educational purposes.

## 👨‍💻 Author

Built with ❤️ using clean, simple, and well-commented code.
