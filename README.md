# GraalGenius
# graal-gemini-service

A lightweight Java-based service that uses **GraalVM** to execute JavaScript code and integrates with **Gemini API** (Google's LLM) to generate responses based on dynamic input questions. This setup allows running JS logic inside a Java service and leveraging AI to provide intelligent responses.

## 🚀 Features

- 💡 Executes JavaScript code inside Java using GraalVM
- 🤖 Sends input queries to Gemini API and retrieves intelligent answers
- ⚡ Fast and efficient using GraalVM's polyglot engine
- 📦 Exposed as a REST API for external use

## 🛠 Tech Stack

- Java 17+
- GraalVM (Polyglot Engine)
- Gemini API (Google AI)
- Spring Boot (or any HTTP framework)
- HTTP Client (e.g., OkHttp, WebClient)

## 📁 Project Structure

graal-gemini-service/
├── controller/ # REST endpoints
├── service/ # JS execution and Gemini API integration
├── config/ # API keys, config setup
├── model/ # Request and response DTOs
├── util/ # Helper methods (e.g., JSON parsing, headers)
├── Application.java
├── README.md
