
# Job Microservice

A Spring Boot microservice for managing job postings.

## API Endpoints

The service runs on port 8082 (default) and provides the following REST endpoints:

### Get All Jobs
```bash
curl -X GET http://localhost:8082/jobs
```

### Create a New Job

#### Example 1: Software Engineer
```bash
curl -X POST http://localhost:8082/jobs \
  -H "Content-Type: application/json" \
  -d '{
    "title": "Software Engineer",
    "description": "Develop and maintain software applications",
    "minSalary": "70000",
    "maxSalary": "100000",
    "location": "New York",
    "companyId": 1
  }'
```

#### Example 2: Data Scientist
```bash
curl -X POST http://localhost:8082/jobs \
  -H "Content-Type: application/json" \
  -d '{
    "title": "Data Scientist",
    "description": "Analyze complex data sets and build machine learning models",
    "minSalary": "80000",
    "maxSalary": "120000",
    "location": "Boston",
    "companyId": 2
  }'
```

#### Example 3: DevOps Engineer
```bash
curl -X POST http://localhost:8082/jobs \
  -H "Content-Type: application/json" \
  -d '{
    "title": "DevOps Engineer",
    "description": "Manage CI/CD pipelines and cloud infrastructure",
    "minSalary": "75000",
    "maxSalary": "110000",
    "location": "Austin",
    "companyId": 3
  }'
```

#### Example 4: Product Manager
```bash
curl -X POST http://localhost:8082/jobs \
  -H "Content-Type: application/json" \
  -d '{
    "title": "Product Manager",
    "description": "Define product strategy and coordinate development efforts",
    "minSalary": "90000",
    "maxSalary": "140000",
    "location": "Seattle",
    "companyId": 1
  }'
```

### Get Job by ID
```bash
curl -X GET http://localhost:8082/jobs/1
```

### Update Job
```bash
curl -X PUT http://localhost:8082/jobs/1 \
  -H "Content-Type: application/json" \
  -d '{
    "title": "Senior Software Engineer",
    "description": "Lead software development projects",
    "minSalary": "90000",
    "maxSalary": "130000",
    "location": "San Francisco",
    "companyId": 1
  }'
```

### Delete Job
```bash
curl -X DELETE http://localhost:8082/jobs/1
```

## Job Entity Fields

- `id` (Long, auto-generated): Unique identifier
- `title` (String, required): Job title
- `description` (String): Job description
- `minSalary` (String, required): Minimum salary
- `maxSalary` (String, required): Maximum salary
- `location` (String, required): Job location
- `companyId` (Long, required): Associated company ID

## Docker

### Building a Docker Image

`./mvnw spring-boot:build-image "-Dspring-boot.build-image.imageName=<IMAGE_NAME>"`

Publish to Docker Hub
`docker push <IMAGE_NAME>`

