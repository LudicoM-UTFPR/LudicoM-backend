# LudicoM Backend

A comprehensive Spring Boot backend API for the LudicoM system. This backend provides RESTful APIs that can be consumed by frontend applications.

## 🚀 Features

- **Spring Boot 3.2.0** with Java 17
- **RESTful API** endpoints for system operations
- **JPA/Hibernate** for database operations
- **Spring Security** with basic authentication
- **H2 Database** for development (easily configurable for PostgreSQL in production)
- **Maven** build system
- **Comprehensive testing** with JUnit 5
- **Health checks** and monitoring endpoints
- **CORS** enabled for frontend integration
- **Global exception handling**

## 📋 Prerequisites

- Java 17 or higher
- Maven 3.6 or higher

## 🛠️ Getting Started

### Clone the repository
```bash
git clone https://github.com/LudicoM-UTFPR/LudicoM-backend.git
cd LudicoM-backend
```

### Build the project
```bash
mvn clean compile
```

### Run tests
```bash
mvn test
```

### Start the application
```bash
mvn spring-boot:run
```

The application will start on `http://localhost:8080`

## 📚 API Documentation

### Public Endpoints (No authentication required)

#### Health Check
```http
GET /api/health
```

Response:
```json
{
  "status": "UP",
  "timestamp": "2025-09-13T21:08:16.254918752",
  "service": "LudicoM Backend",
  "version": "1.0.0"
}
```

#### Application Info
```http
GET /api/info
```

Response:
```json
{
  "application": "LudicoM Backend",
  "description": "Backend API for LudicoM system",
  "version": "1.0.0",
  "java_version": "17.0.16",
  "environment": "development"
}
```

#### Welcome Message
```http
GET /api/welcome
```

Response:
```json
{
  "message": "Welcome to LudicoM Backend API!",
  "documentation": "Visit /api/info for more information"
}
```

### Protected Endpoints (Authentication required)

Default credentials: `admin` / `admin123`

#### User Management

**Get all users**
```http
GET /api/users
Authorization: Basic admin:admin123
```

**Get user by ID**
```http
GET /api/users/{id}
Authorization: Basic admin:admin123
```

**Get user by username**
```http
GET /api/users/username/{username}
Authorization: Basic admin:admin123
```

**Search users**
```http
GET /api/users/search?username={searchTerm}
Authorization: Basic admin:admin123
```

**Create new user**
```http
POST /api/users
Authorization: Basic admin:admin123
Content-Type: application/json

{
  "username": "newuser",
  "email": "user@example.com"
}
```

**Get active users only**
```http
GET /api/users/active
Authorization: Basic admin:admin123
```

**Deactivate user (soft delete)**
```http
DELETE /api/users/{id}
Authorization: Basic admin:admin123
```

## 🗄️ Database

### Development
The application uses H2 in-memory database for development. You can access the H2 console at:
- URL: `http://localhost:8080/h2-console`
- JDBC URL: `jdbc:h2:mem:ludicomdb`
- Username: `sa`
- Password: (empty)

### Production
For production, configure PostgreSQL by updating `application.properties`:
```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/ludicomdb
spring.datasource.username=your_username
spring.datasource.password=your_password
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect
```

## 🔒 Security

The application uses Spring Security with:
- Basic HTTP Authentication for protected endpoints
- CORS enabled for frontend integration
- Public access to health check endpoints
- Password-based authentication (configurable)

## 🏗️ Project Structure

```
src/
├── main/
│   ├── java/com/ludicom/backend/
│   │   ├── config/          # Configuration classes
│   │   ├── controller/      # REST controllers
│   │   ├── dto/            # Data Transfer Objects
│   │   ├── model/          # JPA entities
│   │   ├── repository/     # Data repositories
│   │   ├── service/        # Business logic
│   │   └── LudicomBackendApplication.java
│   └── resources/
│       └── application.properties
└── test/
    ├── java/               # Test classes
    └── resources/
        └── application-test.properties
```

## 🧪 Testing

Run the complete test suite:
```bash
mvn test
```

The project includes:
- Unit tests for controllers
- Integration tests for the application context
- Test-specific configuration

## 📦 Building for Production

Create a JAR file:
```bash
mvn clean package
```

Run the JAR:
```bash
java -jar target/ludicom-backend-1.0.0.jar
```

## 🔧 Configuration

Key configuration properties in `application.properties`:

```properties
# Server configuration
server.port=8080

# Database configuration
spring.datasource.url=jdbc:h2:mem:ludicomdb
spring.jpa.hibernate.ddl-auto=update

# Security configuration
spring.security.user.name=admin
spring.security.user.password=admin123

# Actuator endpoints
management.endpoints.web.exposure.include=health,info
```

## 🚀 Deployment

1. **Docker** (recommended for production)
2. **Traditional server deployment** with JAR file
3. **Cloud platforms** (AWS, Azure, GCP)

## 🤝 Contributing

1. Fork the repository
2. Create a feature branch
3. Make your changes
4. Add tests for new functionality
5. Run the test suite
6. Submit a pull request

## 📄 License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

## 📞 Support

For questions or support, please:
1. Check the documentation above
2. Review existing issues
3. Create a new issue with detailed information

---

**Built with ❤️ for the LudicoM system**
