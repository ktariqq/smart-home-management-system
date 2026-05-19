# Smart Home Management System

A Java-based Smart Home Management System that enables users to control devices, monitor rooms, and automate home operations using Object-Oriented Programming principles and multi-threading. The system includes a JavaFX GUI for real-time interaction with smart devices such as lights, thermostats, and locks.

![Java](https://img.shields.io/badge/Java-OOP-8A2BE2.svg)
![JavaFX](https://img.shields.io/badge/JavaFX-GUI-4B0082.svg)
![License](https://img.shields.io/badge/License-MIT-6A0DAD.svg)

<div align="center">

━━━━━━━━━━━━━━ ✦ ✧ ✦ ━━━━━━━━━━━━━━

</div>

## 🟣 Overview

This project simulates a real-world smart home environment using a modular Java architecture. It models devices, rooms, users, and system-level control logic to enable centralized smart home management.

The system supports real-time device control, energy monitoring, and multi-threaded device monitoring. A JavaFX-based GUI provides an interactive interface for controlling devices and viewing system status.
<br><br>

## 🟣 Key Features

- Object-Oriented design (Inheritance, Polymorphism, Encapsulation, Abstraction)
- Multi-device support (Smart Lights, Thermostats, Smart Locks)
- JavaFX graphical user interface (GUI)
- Multi-threaded device monitoring system
- Multi-threaded user command processing
- Real-time device control (On/Off, temperature adjustment)
- Room-based device organization
- Central Smart Home controller system
<br><br>

## 🏠 System Architecture

- **Device (Abstract Class)** → Base class for all smart devices  
- **SmartLight / SmartThermostat / SmartLock** → Concrete device implementations  
- **Room** → Container for multiple devices  
- **SmartHome** → Central system manager  
- **User** → Controls assigned rooms and devices  
- **DeviceMonitor (Threaded)** → Periodic device status monitoring  
- **UserCommandProcessor (Threaded)** → Asynchronous command execution system  
<br><br>

## 🔧 Technologies Used

- Java (OOP)
- JavaFX (GUI)
- Multithreading (ExecutorService, Threads)
- Java Collections Framework (ArrayList, List)
- LocalDateTime API
<br><br>

## 🟣 GUI Features

- Real-time view of all rooms and devices
- Turn devices ON/OFF via input controls
- Adjust thermostat temperature dynamically
- Refresh system state instantly
- Error handling with popup alerts
<br><br>

## 🟣 Core Functionalities

### Device Control
Devices are controlled using polymorphism through a shared `Device` interface/abstract class.

### Smart Thermostat Control
Allows dynamic temperature updates per device ID.

### Multi-threaded Monitoring
Each device runs a background thread that continuously reports status.

### Room-Based Organization
Devices are grouped into rooms for structured control and scalability.
<br><br>

## 🟣 How to Run

1. Clone the repository:
```bash
git clone https://github.com/ktariqq/smart-home-management-system.git
```
2. Open the project in IntelliJ IDEA or Eclipse
3. Configure JavaFX SDK in your IDE
4. Run the main class:
SmartHomeManagementSystem.java
<br><br>

## 🟣 Example Use Cases
- Turn living room lights ON/OFF
- Set bedroom thermostat temperature
- Lock/unlock smart doors
- Monitor device status in real time
<br><br>

## 🟣 Concepts Demonstrated
- Object-Oriented Programming (OOP)
- Inheritance and Interfaces
- Encapsulation and Modularity
- GUI event-driven programming (JavaFX)
- Multithreading and concurrency
- System design and architecture

## 🟣 Future Improvements
- Mobile application integration
- IoT hardware integration (Raspberry Pi / Arduino)
- Cloud-based smart home control system
- Voice assistant integration
- Energy optimization analytics and dashboards
