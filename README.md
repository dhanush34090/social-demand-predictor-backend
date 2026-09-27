# Social Demand Predictor Backend (Lombok-free)

Spring Boot 3.5.5 + Java 17 + PostgreSQL backend.

## Why this version
This version removes Lombok completely. All constructors, getters and setters are written explicitly to avoid STS/Lombok annotation-processing errors.

## PostgreSQL
Create database:
CREATE DATABASE social_demand_db;

Edit `src/main/resources/application.properties` and set your PostgreSQL username/password.

## Run in STS
1. Import as Existing Maven Project.
2. Right-click project -> Maven -> Update Project.
3. Project -> Clean.
4. Run `SocialDemandPredictorApplication.java` as Spring Boot App.

Server: http://localhost:8080

## APIs
GET/POST /api/products
GET /api/products/{id}
PUT /api/products/{id}
DELETE /api/products/{id}
GET/POST /api/sales
GET /api/sales/product/{productId}
GET/POST /api/social-data
GET /api/social-data/product/{productId}
GET /api/predictions
GET /api/predictions/product/{productId}

The prediction endpoints currently read prediction records. The actual ML engine will be added later.
