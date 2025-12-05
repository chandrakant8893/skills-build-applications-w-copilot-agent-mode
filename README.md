# Items API (new endpoint)

This branch adds a small Spring Boot REST endpoint:

- POST /api/items
  - Request JSON: { "name": "string", "description": "string" (optional) }
  - Response JSON: { "id": "string", "name": "string", "description": "string", "createdAt": "ISO8601" }
  - Returns HTTP 201 on success.

Example curl:
```
curl -X POST http://localhost:8080/api/items \
  -H "Content-Type: application/json" \
  -d '{"name":"My Item","description":"Optional"}'
```

Run:
- mvn spring-boot:run
- mvn test
