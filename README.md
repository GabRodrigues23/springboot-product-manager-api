# 📌 Spring Boot Product Management API

## 📖 Project Description
This project is a **REST API** built with **Spring Boot** that allows users to manage **products, categories, clients, and sales**. The system will support CRUD operations (Create, Read, Update, Delete) and provide **reports and logs** for user activities.

### ✅ Features
- **Product Management**: Add, update, delete, and list products.
- **Category Management**: Manage product categories.
- **Client Management**: Add, update, delete, and list clients.
- **Sales Management**: Register sales by linking products to clients.
- **Reports**: Generate reports for products, clients, and sales within a specific date range.
- **User Logs**: Track user interactions with the system.

## 📂 Project Structure
```
📦 MANAGER
├── 📂 .vscode
├── 📂 src
│   ├── 📂 main
│   │   ├── 📂 java/com/spring/manager
│   │   │   ├── 📂 config        # 🔧 Configuration classes (CORS, security, etc.)
│   │   │   ├── 📂 controller    # 🎯 REST Controllers (handles HTTP requests)
│   │   │   ├── 📂 dto           # 📦 Data Transfer Objects (DTOs)
│   │   │   ├── 📂 entity        # 🗂 JPA Entities (database models)
│   │   │   ├── 📂 exception     # 🚨 Custom exceptions and handlers
│   │   │   ├── 📂 repository    # 🛢 Spring Data JPA Repositories
│   │   │   ├── 📂 service       # ⚙ Business logic and services
│   │   │   ├── 📂 util          # 🛠 Utility classes and helpers
│   │   │   ├── 📜 ManagerApplication.java  # 🚀 Main application entry
│   │   ├── 📂 resources
│   │   │   ├── 📂 static        # 🖼 Static resources (images, CSS, JS)
│   │   │   ├── 📂 templates     # 📝 Thymeleaf templates (if applicable)
│   │   │   ├── 📜 application.properties  # ⚙ Main configuration file
│   │   │   ├── 📜 application.yml         # 🔧 Alternative configuration file
│   ├── 📂 test
│   │   ├── 📂 java/com/spring/manager  # ✅ Unit & integration tests
│   │
│   ├── 📂 target  # 🚀 Compiled output files
│
├── 📜 .gitattributes
├── 📜 .gitignore     # 🚫 Git ignore file
├── 📜 HELP.md        # ℹ Project help file
├── 📜 mvnw           # 🛠 Maven wrapper script (Linux/macOS)
├── 📜 mvnw.cmd       # 🛠 Maven wrapper script (Windows)
├── 📜 pom.xml        # 📦 Maven dependencies
├── 📜 README.md      # 📖 Project documentation
```

## 🚀 Conclusion
This project will provide a **robust API** for managing products, categories, clients, and sales. The **reporting** and **logging** features ensure transparency and easy tracking of operations. The system is structured using **Spring Boot MVC architecture**, making it scalable and maintainable.

---