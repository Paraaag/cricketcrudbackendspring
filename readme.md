🏏 Spring Boot CRUD App: Batsman & Team Management

A Spring Boot application to manage Batsmen and their Teams with full 
CRUD operations, validation, error handling, and ready
integration with MySQL or H2. This backend is designed for scalability,
cloud deployment, and enterprise-grade coding practices.


📦 Features
- Full CRUD operations for `Batsman` and `Team` entities
- One-to-many relationship: One `Team` → Many `Batsmen`
- Validation using Jakarta Bean Validation:
  - Unique names for both entities
  - `battingPosition` must be between 1 and 11
  - Required fields check (like names and batting position)
- Clear and concise error handling (400, 404, 409, 500)
- Layered architecture (Controller → Service → Repository)
- MySQL and H2 support
- Postman API documentation support

⚙️ Tech Stack
- Java 17+
- Spring Boot 3+
- Spring Web, Spring Data JPA, Validation
- Lombok
- MySQL / H2
- Postman (API testing and documentation)

📬 API Endpoints

🟦 Batsman APIs
- POST   `/batsmen`          → Create new batsman
- GET    `/batsmen`          → Get all batsmen
- PUT    `/batsmen/{id}`     → Update batsman by ID
- DELETE `/batsmen/{id}`     → Delete batsman by ID

Sample Batsman Request (POST / PUT):
{
  "batsmanName": "MS Dhoni",
  "battingPosition": 7,
  "team": {
    "teamName": "CSK"
  }
}

🟩 Team APIs
- POST   `/teams`            → Create a new team
- GET    `/teams`            → Get all teams
- PUT    `/teams/{id}`       → Update team by ID
- DELETE `/teams/{id}`       → Delete team by ID

Sample Team Request (POST / PUT):
{
  "teamName": "MI",
  "players": [
    {
      "batsmanName": "Rohit Sharma",
      "battingPosition": 1
    },
    {
      "batsmanName": "Suryakumar Yadav",
      "battingPosition": 4
    }
  ]
}

❗ Validations & Constraints
- `batsmanName`: Not blank, must be unique
- `battingPosition`: Must be between 1 and 11 inclusive
- `teamName`: Not blank, must be unique

🚫 Error Handling
- 400: Validation failed → `{ "battingPosition": "Must be <= 11" }`
- 404: Resource not found → `{ "error": "Team 'MI' not found" }`
- 409: Duplicate name → `{ "error": "Batsman already exists" }`
- 500: Unexpected exception → `{ "error": "Internal Server Error" }`

🧪 Database Setup

H2 (In-memory):
spring.datasource.url=jdbc:h2:mem:testdb
spring.datasource.driver-class-name=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=
spring.jpa.hibernate.ddl-auto=update
spring.h2.console.enabled=true
spring.h2.console.path=/h2-console
→ Visit: http://localhost:8080/h2-console

MySQL:
spring.datasource.url=jdbc:mysql://localhost:3306/cricketdb
spring.datasource.username=root
spring.datasource.password=yourpassword
spring.jpa.hibernate.ddl-auto=update

🔧 Build & Run

Using Maven:
./mvnw clean install
./mvnw spring-boot:run

Using IntelliJ / VSCode:
- Import project as Maven
- Run DemoApplication.java

📒 Postman API Docs

1. Open Postman → Click Import → Create collection `Batsman-Team App`
2. Add each API endpoint with method, URL, and sample body
3. Add examples and save collection
4. Click 3 dots on collection → View in web
5. Click "Publish Docs" to host it online

Optional Test:
pm.test("Status code is 200", function () {
  pm.response.to.have.status(200);
});

🚀 Ready for Deployment

- Compatible with cloud environments (Railway, Render, AWS)
- Add Dockerfile:
FROM openjdk:17-jdk-slim
COPY target/demo.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]

👨‍💻 Author
Parag Yadav  
Intern : Siemens (Team Mendix Cloud )  
GitHub: https://github.com/Paraaag

📄 License
MIT License
