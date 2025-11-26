# 🎟️ Ticket Booking System

A full-stack ticket booking application built with **Java Spring Boot** (backend) and **Next.js** (frontend).

## 📁 Project Structure

```
ticket-booking-system/
├── ticket-booking-backend/             # Java Spring Boot Application
├── frontend/                           # Next.js React Application
├── demo/                               # Screenshots and demos
├── requirements.txt                    # System requirements
└── README.md                           # This file
```

## 🚀 Quick Start

### 1. Prerequisites
- Install **Java 21** (Ensure added to PATH)
- Install **Node.js 18+**

### 2. Start Backend
Open a terminal in the `ticket-booking-backend` folder :

```bash
cd ticket-booking-backend
# If using Maven:
mvn spring-boot:run
# If using Maven Daemon:
mvnd spring-boot:run
```

The server will start at `http://localhost:8080`

### 3. Start Frontend
Open a new terminal in the `frontend` folder:

```bash
cd frontend
npm run dev
```

The application will be available at `http://localhost:3000`

## 🌟 Features
- View available events
- Real-time seat availability
- Book tickets with validation
- Premium UI design
- Dark/Light Mode Support
- Responsive layout

## 🔧 Troubleshooting
If you have issues with Java or Maven, check the `SETUP_MAC.md` or `SETUP_WINDOWS.md` inside the root folder.
