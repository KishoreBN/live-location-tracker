# 🚖 Live Location Tracker

A microservices-based project to simulate **real-time driver location tracking**, inspired by how apps like **Ola, Uber, Swiggy** track delivery agents and cabs.  
The project demonstrates how to ingest driver location data, stream it using **Kafka**, and broadcast live updates to end users via **WebSockets** with a simple **frontend map**.

---

## 📌 Architecture

![High-level Design](./High-level-design.png)

---

## ⚙️ How it Works

1. 🚴 **Delivery Agent** periodically updates his location → sent to **gps-ingestion-service**.  
2. 📡 **gps-ingestion-service** acts as a **Kafka Producer** → pushes these messages to **Kafka Broker**.  
3. 🎧 **tracking-websocket-service** (Kafka Consumer) continuously listens for new messages.  
4. 🌍 Whenever a new message arrives, the service pushes it to the **end user via WebSocket**, giving **real-time tracking**.  
5. 🔄 Kafka messages can also be consumed by **other services** in parallel for:  
   - ETA calculation  
   - Push notifications  
   - Analytics & reporting  

---

## 🏗️ Modules

### 1. gps-ingestion-service
- A Spring Boot microservice.  
- Acts as a **Kafka Producer**.  
- Accepts driver’s location updates and publishes them to Kafka.  

### 2. tracking-websocket-service
- A Spring Boot microservice.  
- Acts as a **Kafka Consumer**.  
- Subscribes to location topic and pushes live updates to frontend clients via WebSocket.  

### 3. shared-dto
- Shared module containing `LocationSnapshot` and other DTOs used across services.  

### 4. demo.html
- A lightweight frontend built with **Leaflet.js**.  
- Connects to WebSocket and shows real-time driver movement on a **Google Maps-like UI**.  

---

## ⚙️ Tech Stack

- **Backend**: Java 17, Spring Boot, Kafka  
- **Frontend**: HTML, CSS, JavaScript, Leaflet.js  
- **Messaging**: Apache Kafka  
- **Realtime**: WebSockets  
- **Build Tools**: Maven  

---

## 🚀 Getting Started

### 1. Clone the repository
```bash
git clone https://github.com/KishoreBN/live-location-tracker.git
cd live-location-tracker