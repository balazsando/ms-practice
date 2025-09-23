.PHONY: help up down logs build clean restart status network-create

help: ## Show this help message
	@echo "Available commands:"
	@grep -E '^[a-zA-Z_-]+:.*?## .*$$' $(MAKEFILE_LIST) | awk 'BEGIN {FS = ":.*?## "}; {printf "\033[36m%-15s\033[0m %s\n", $$1, $$2}'

network-create: ## Create shared network for microservices
	docker network create microservices-network 2>/dev/null || true

up: network-create ## Start all microservices using individual compose files
	DB_PORT=5435 docker-compose -f company-ms/docker-compose.yml -p company up -d
	DB_PORT=5433 docker-compose -f job-ms/docker-compose.yml -p job up -d
	DB_PORT=5434 docker-compose -f review-ms/docker-compose.yml -p review up -d

down: ## Stop all microservices
	docker-compose -f company-ms/docker-compose.yml -p company down
	docker-compose -f job-ms/docker-compose.yml -p job down
	docker-compose -f review-ms/docker-compose.yml -p review down

logs: ## Show logs for all services
	DB_PORT=5435 docker-compose -f company-ms/docker-compose.yml -p company logs -f &
	DB_PORT=5433 docker-compose -f job-ms/docker-compose.yml -p job logs -f &
	DB_PORT=5434 docker-compose -f review-ms/docker-compose.yml -p review logs -f &
	wait

build: ## Build all microservices
	DB_PORT=5435 docker-compose -f company-ms/docker-compose.yml -p company build
	DB_PORT=5433 docker-compose -f job-ms/docker-compose.yml -p job build
	DB_PORT=5434 docker-compose -f review-ms/docker-compose.yml -p review build

clean: ## Stop and remove containers, networks, and volumes
	DB_PORT=5435 docker-compose -f company-ms/docker-compose.yml -p company down -v --remove-orphans
	DB_PORT=5433 docker-compose -f job-ms/docker-compose.yml -p job down -v --remove-orphans
	DB_PORT=5434 docker-compose -f review-ms/docker-compose.yml -p review down -v --remove-orphans
	docker network rm microservices-network 2>/dev/null || true

restart: down up ## Restart all services

status: ## Show status of all containers
	DB_PORT=5435 docker-compose -f company-ms/docker-compose.yml -p company ps
	DB_PORT=5433 docker-compose -f job-ms/docker-compose.yml -p job ps
	DB_PORT=5434 docker-compose -f review-ms/docker-compose.yml -p review ps

# Individual service commands
company-logs: ## Show logs for company service only
	DB_PORT=5435 docker-compose -f company-ms/docker-compose.yml -p company logs -f

job-logs: ## Show logs for job service only
	DB_PORT=5433 docker-compose -f job-ms/docker-compose.yml -p job logs -f

review-logs: ## Show logs for review service only
	DB_PORT=5434 docker-compose -f review-ms/docker-compose.yml -p review logs -f

# Individual service management
company-up: network-create ## Start only company microservice
	DB_PORT=5435 docker-compose -f company-ms/docker-compose.yml -p company up -d

job-up: network-create ## Start only job microservice
	DB_PORT=5433 docker-compose -f job-ms/docker-compose.yml -p job up -d

review-up: network-create ## Start only review microservice
	DB_PORT=5434 docker-compose -f review-ms/docker-compose.yml -p review up -d

company-down: ## Stop company microservice
	docker-compose -f company-ms/docker-compose.yml -p company down

job-down: ## Stop job microservice
	docker-compose -f job-ms/docker-compose.yml -p job down

review-down: ## Stop review microservice
	docker-compose -f review-ms/docker-compose.yml -p review down

# Alternative: Use the aggregate compose file
up-aggregate: ## Start all services using the main docker-compose.yml
	docker-compose up -d

down-aggregate: ## Stop all services using the main docker-compose.yml
	docker-compose down

# Show database connection info
db-info: ## Show database connection information
	@echo "Database Connection Info:"
	@echo "Company DB: localhost:5435 (companydb/postgres/postgres)"
	@echo "Job DB:     localhost:5433 (jobdb/postgres/postgres)"
	@echo "Review DB:  localhost:5434 (reviewdb/postgres/postgres)"