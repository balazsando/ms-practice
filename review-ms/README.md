# Review Microservice

A Spring Boot microservice for managing company reviews.

## API Endpoints

The service runs on port 8083 (default) and provides the following REST endpoints:

### Get All Reviews for a Company
```bash
curl -X GET "http://localhost:8083/reviews?companyId=1"
```

### Create a New Review

#### Example 1: Positive Review
```bash
curl -X POST "http://localhost:8083/reviews?companyId=1" \
  -H "Content-Type: application/json" \
  -d '{
    "title": "Great workplace",
    "description": "Excellent work environment and culture",
    "rating": 4.5
  }'
```

#### Example 2: Excellent Experience
```bash
curl -X POST "http://localhost:8083/reviews?companyId=2" \
  -H "Content-Type: application/json" \
  -d '{
    "title": "Outstanding company culture",
    "description": "Amazing leadership, great benefits, and incredible growth opportunities. Work-life balance is perfect.",
    "rating": 5.0
  }'
```

#### Example 3: Mixed Review
```bash
curl -X POST "http://localhost:8083/reviews?companyId=3" \
  -H "Content-Type: application/json" \
  -d '{
    "title": "Good company with room for improvement",
    "description": "Solid technical challenges and decent pay, but management could be more transparent and processes need improvement.",
    "rating": 3.5
  }'
```

#### Example 4: Negative Experience
```bash
curl -X POST "http://localhost:8083/reviews?companyId=1" \
  -H "Content-Type: application/json" \
  -d '{
    "title": "Disappointing experience",
    "description": "Poor work-life balance, unrealistic deadlines, and limited career advancement opportunities.",
    "rating": 2.0
  }'
```

#### Example 5: Average Experience
```bash
curl -X POST "http://localhost:8083/reviews?companyId=4" \
  -H "Content-Type: application/json" \
  -d '{
    "title": "Decent place to work",
    "description": "Standard corporate environment with fair compensation. Nothing exceptional but stable employment.",
    "rating": 3.0
  }'
```

### Get Review by ID
```bash
curl -X GET http://localhost:8083/reviews/1
```

### Update Review
```bash
curl -X PUT http://localhost:8083/reviews/1 \
  -H "Content-Type: application/json" \
  -d '{
    "title": "Outstanding workplace",
    "description": "Amazing work environment with great benefits",
    "rating": 5.0
  }'
```

### Delete Review
```bash
curl -X DELETE http://localhost:8083/reviews/1
```

## Review Entity Fields

- `id` (Long, auto-generated): Unique identifier
- `title` (String, required): Review title
- `description` (String, required): Review description
- `rating` (double, required): Review rating
- `companyId` (long, required): Associated company ID