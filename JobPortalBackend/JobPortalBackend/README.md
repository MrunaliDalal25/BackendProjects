# Job Portal Backend API

A starter REST API for a job portal built with Java 21, Spring Boot, Spring Data JPA, and MySQL. It includes CRUD endpoints for job postings, input validation, basic error handling, and Actuator health checks.

## Requirements
- JDK 21
- Maven 3.9+
- MySQL 8+

## Run locally
1. Create a database: `CREATE DATABASE job_portal;`
2. Set environment variables (recommended):
   - `DB_URL=jdbc:mysql://localhost:3306/job_portal`
   - `DB_USERNAME=your_mysql_user`
   - `DB_PASSWORD=your_mysql_password`
3. From this directory run: `mvn spring-boot:run`
4. API base URL: `http://localhost:8080/api/jobs`
5. Health check: `http://localhost:8080/actuator/health`

For quick local-only use, application.properties has defaults for the URL and username. Set `DB_PASSWORD` in your environment; do not commit credentials.

## Endpoints
- `POST /api/jobs` — create a job
- `GET /api/jobs` — list jobs (optional `?keyword=java`)
- `GET /api/jobs/{id}` — fetch one job
- `PUT /api/jobs/{id}` — update a job
- `DELETE /api/jobs/{id}` — delete a job

Example POST body:
```json
{
  "title": "Java Backend Developer",
  "company": "Example Technologies",
  "location": "Pune",
  "description": "Build REST APIs using Java and Spring Boot",
  "employmentType": "FULL_TIME"
}
```

## AWS deployment outline
1. Provision an RDS MySQL database in a private subnet.
2. Build the application with `mvn clean package`.
3. Deploy the JAR to an EC2 instance (or containerize and use ECS).
4. Put database credentials in AWS Secrets Manager or Parameter Store.
5. Restrict security groups: public traffic to the app only; MySQL port 3306 accessible only from the app security group.
6. Configure HTTPS through an Application Load Balancer and monitor with CloudWatch.

This is a starter project, not a production-secured deployment. Authentication/authorization, migrations (Flyway), pagination, rate limiting, and integration tests are sensible next steps.
