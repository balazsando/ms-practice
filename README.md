# Microservices Practice Project

This project contains three Spring Boot microservices: Company, Job, and Review services. Each service has its own PostgreSQL database and runs on different ports.

## Quick Start

### Start All Microservices

Use the Makefile to start all three microservices with their databases:

```bash
make up
```

This will start:
- **Company Service**: `http://localhost:8081`
- **Job Service**: `http://localhost:8082`
- **Review Service**: `http://localhost:8083`

### Stop All Services

```bash
make down
```

### View Database Connection Info

```bash
make db-info
```

## Database Connections

- **Company DB**: `localhost:5435` (database: `company_db`, user: `postgres`, password: `postgres`)
- **Job DB**: `localhost:5433` (database: `job_db`, user: `postgres`, password: `postgres`)
- **Review DB**: `localhost:5434` (database: `review_db`, user: `postgres`, password: `postgres`)

## API Examples

Once all services are running, you can populate the databases with sample data using these curl commands:

### 1. Create Companies

```bash
# Create Company 1 - Tech Corp
curl -X POST http://localhost:8081/companies \
  -H "Content-Type: application/json" \
  -d '{
    "name": "Tech Corp",
    "description": "Leading technology company specializing in cloud solutions"
  }'

# Create Company 2 - DataSoft Inc
curl -X POST http://localhost:8081/companies \
  -H "Content-Type: application/json" \
  -d '{
    "name": "DataSoft Inc",
    "description": "Data analytics and business intelligence solutions"
  }'

# Create Company 3 - Innovation Labs
curl -X POST http://localhost:8081/companies \
  -H "Content-Type: application/json" \
  -d '{
    "name": "Innovation Labs",
    "description": "R&D focused startup working on AI and machine learning"
  }'
```

### 2. Create Jobs

```bash
# Job 1 - Software Engineer at Tech Corp (companyId: 1)
curl -X POST http://localhost:8082/jobs \
  -H "Content-Type: application/json" \
  -d '{
    "title": "Senior Software Engineer",
    "description": "Develop scalable cloud-native applications using Java and Spring Boot",
    "minSalary": "80000",
    "maxSalary": "120000",
    "location": "San Francisco, CA",
    "companyId": 1
  }'

# Job 2 - Data Scientist at DataSoft Inc (companyId: 2)
curl -X POST http://localhost:8082/jobs \
  -H "Content-Type: application/json" \
  -d '{
    "title": "Data Scientist",
    "description": "Analyze large datasets and build predictive models",
    "minSalary": "90000",
    "maxSalary": "140000",
    "location": "New York, NY",
    "companyId": 2
  }'

# Job 3 - ML Engineer at Innovation Labs (companyId: 3)
curl -X POST http://localhost:8082/jobs \
  -H "Content-Type: application/json" \
  -d '{
    "title": "Machine Learning Engineer",
    "description": "Design and implement ML pipelines and algorithms",
    "minSalary": "95000",
    "maxSalary": "150000",
    "location": "Austin, TX",
    "companyId": 3
  }'

# Job 4 - Frontend Developer at Tech Corp (companyId: 1)
curl -X POST http://localhost:8082/jobs \
  -H "Content-Type: application/json" \
  -d '{
    "title": "Frontend Developer",
    "description": "Build responsive web applications using React and TypeScript",
    "minSalary": "70000",
    "maxSalary": "100000",
    "location": "San Francisco, CA",
    "companyId": 1
  }'
```

### 3. Create Reviews

```bash
# Review 1 - Tech Corp (companyId: 1)
curl -X POST "http://localhost:8083/reviews?companyId=1" \
  -H "Content-Type: application/json" \
  -d '{
    "title": "Great place to work",
    "description": "Excellent work-life balance and innovative projects. Management is supportive and encourages learning.",
    "rating": 4.5
  }'

# Review 2 - Tech Corp (companyId: 1)
curl -X POST "http://localhost:8083/reviews?companyId=1" \
  -H "Content-Type: application/json" \
  -d '{
    "title": "Good growth opportunities",
    "description": "Lots of opportunities to learn new technologies and advance career. Competitive salary and benefits.",
    "rating": 4.2
  }'

# Review 3 - DataSoft Inc (companyId: 2)
curl -X POST "http://localhost:8083/reviews?companyId=2" \
  -H "Content-Type: application/json" \
  -d '{
    "title": "Data-driven culture",
    "description": "Amazing company for data professionals. Cutting-edge tools and interesting problems to solve.",
    "rating": 4.7
  }'

# Review 4 - DataSoft Inc (companyId: 2)
curl -X POST "http://localhost:8083/reviews?companyId=2" \
  -H "Content-Type: application/json" \
  -d '{
    "title": "Fast-paced environment",
    "description": "High expectations but rewarding work. Great team collaboration and modern tech stack.",
    "rating": 4.0
  }'

# Review 5 - Innovation Labs (companyId: 3)
curl -X POST "http://localhost:8083/reviews?companyId=3" \
  -H "Content-Type: application/json" \
  -d '{
    "title": "Startup energy",
    "description": "Exciting startup atmosphere with opportunity to work on breakthrough AI technologies.",
    "rating": 4.3
  }'

# Review 6 - Innovation Labs (companyId: 3)
curl -X POST "http://localhost:8083/reviews?companyId=3" \
  -H "Content-Type: application/json" \
  -d '{
    "title": "Research focused",
    "description": "Perfect for those who love research and experimentation. Flexible hours and creative freedom.",
    "rating": 4.6
  }'
```

## Verification Commands

After populating the databases, verify the data was created successfully:

```bash
# Get all companies
curl http://localhost:8081/companies

# Get all jobs
curl http://localhost:8082/jobs

# Get reviews for Tech Corp (companyId: 1)
curl "http://localhost:8083/reviews?companyId=1"

# Get reviews for DataSoft Inc (companyId: 2)
curl "http://localhost:8083/reviews?companyId=2"

# Get reviews for Innovation Labs (companyId: 3)
curl "http://localhost:8083/reviews?companyId=3"
```

## Individual Service Management

You can also manage services individually:

```bash
# Start individual services
make company-up
make job-up
make review-up

# Stop individual services
make company-down
make job-down
make review-down

# View logs for individual services
make company-logs
make job-logs
make review-logs
```

## Complete Setup Script

For convenience, here's a complete bash script to populate all databases:

```bash
#!/bin/bash

echo "Creating companies..."
curl -s -X POST http://localhost:8081/companies -H "Content-Type: application/json" -d '{"name": "Tech Corp", "description": "Leading technology company specializing in cloud solutions"}' | jq
curl -s -X POST http://localhost:8081/companies -H "Content-Type: application/json" -d '{"name": "DataSoft Inc", "description": "Data analytics and business intelligence solutions"}' | jq
curl -s -X POST http://localhost:8081/companies -H "Content-Type: application/json" -d '{"name": "Innovation Labs", "description": "R&D focused startup working on AI and machine learning"}' | jq

echo "Creating jobs..."
curl -s -X POST http://localhost:8082/jobs -H "Content-Type: application/json" -d '{"title": "Senior Software Engineer", "description": "Develop scalable cloud-native applications using Java and Spring Boot", "minSalary": "80000", "maxSalary": "120000", "location": "San Francisco, CA", "companyId": 1}' | jq
curl -s -X POST http://localhost:8082/jobs -H "Content-Type: application/json" -d '{"title": "Data Scientist", "description": "Analyze large datasets and build predictive models", "minSalary": "90000", "maxSalary": "140000", "location": "New York, NY", "companyId": 2}' | jq
curl -s -X POST http://localhost:8082/jobs -H "Content-Type: application/json" -d '{"title": "Machine Learning Engineer", "description": "Design and implement ML pipelines and algorithms", "minSalary": "95000", "maxSalary": "150000", "location": "Austin, TX", "companyId": 3}' | jq
curl -s -X POST http://localhost:8082/jobs -H "Content-Type: application/json" -d '{"title": "Frontend Developer", "description": "Build responsive web applications using React and TypeScript", "minSalary": "70000", "maxSalary": "100000", "location": "San Francisco, CA", "companyId": 1}' | jq

echo "Creating reviews..."
curl -s -X POST "http://localhost:8083/reviews?companyId=1" -H "Content-Type: application/json" -d '{"title": "Great place to work", "description": "Excellent work-life balance and innovative projects. Management is supportive and encourages learning.", "rating": 4.5}' | jq
curl -s -X POST "http://localhost:8083/reviews?companyId=1" -H "Content-Type: application/json" -d '{"title": "Good growth opportunities", "description": "Lots of opportunities to learn new technologies and advance career. Competitive salary and benefits.", "rating": 4.2}' | jq
curl -s -X POST "http://localhost:8083/reviews?companyId=2" -H "Content-Type: application/json" -d '{"title": "Data-driven culture", "description": "Amazing company for data professionals. Cutting-edge tools and interesting problems to solve.", "rating": 4.7}' | jq
curl -s -X POST "http://localhost:8083/reviews?companyId=2" -H "Content-Type: application/json" -d '{"title": "Fast-paced environment", "description": "High expectations but rewarding work. Great team collaboration and modern tech stack.", "rating": 4.0}' | jq
curl -s -X POST "http://localhost:8083/reviews?companyId=3" -H "Content-Type: application/json" -d '{"title": "Startup energy", "description": "Exciting startup atmosphere with opportunity to work on breakthrough AI technologies.", "rating": 4.3}' | jq
curl -s -X POST "http://localhost:8083/reviews?companyId=3" -H "Content-Type: application/json" -d '{"title": "Research focused", "description": "Perfect for those who love research and experimentation. Flexible hours and creative freedom.", "rating": 4.6}' | jq

echo "Done! Verifying data..."
echo "Companies:"
curl -s http://localhost:8081/companies | jq
echo "Jobs:"
curl -s http://localhost:8082/jobs | jq
echo "Reviews:"
curl -s "http://localhost:8083/reviews?companyId=1" | jq
```

Save this as `populate_data.sh`, make it executable with `chmod +x populate_data.sh`, and run it with `./populate_data.sh`.