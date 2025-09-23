# Company Microservice

A Spring Boot microservice for managing companies.

## API Endpoints

The service runs on port 8081 (default) and provides the following REST endpoints:

### Get All Companies
```bash
curl -X GET http://localhost:8081/companies
```

### Create a New Company

#### Example 1: Technology Company
```bash
curl -X POST http://localhost:8081/companies \
  -H "Content-Type: application/json" \
  -d '{
    "name": "Tech Corp",
    "description": "A leading technology company"
  }'
```

#### Example 2: Financial Services
```bash
curl -X POST http://localhost:8081/companies \
  -H "Content-Type: application/json" \
  -d '{
    "name": "FinTech Solutions",
    "description": "Innovative financial technology services and digital banking solutions"
  }'
```

#### Example 3: Healthcare Company
```bash
curl -X POST http://localhost:8081/companies \
  -H "Content-Type: application/json" \
  -d '{
    "name": "MedTech Innovations",
    "description": "Healthcare technology company focused on improving patient outcomes"
  }'
```

#### Example 4: E-commerce Platform
```bash
curl -X POST http://localhost:8081/companies \
  -H "Content-Type: application/json" \
  -d '{
    "name": "Global Commerce Hub",
    "description": "Leading e-commerce platform connecting buyers and sellers worldwide"
  }'
```

#### Example 5: Startup
```bash
curl -X POST http://localhost:8081/companies \
  -H "Content-Type: application/json" \
  -d '{
    "name": "NextGen AI",
    "description": "AI-powered solutions for modern business challenges"
  }'
```

### Get Company by ID
```bash
curl -X GET http://localhost:8081/companies/1
```

### Update Company
```bash
curl -X PUT http://localhost:8081/companies/1 \
  -H "Content-Type: application/json" \
  -d '{
    "name": "Tech Solutions Inc",
    "description": "Innovative technology solutions provider"
  }'
```

### Delete Company
```bash
curl -X DELETE http://localhost:8081/companies/1
```

## Company Entity Fields

- `id` (Long, auto-generated): Unique identifier
- `name` (String, required): Company name
- `description` (String): Company description