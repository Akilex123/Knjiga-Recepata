# Recipe Book Application

A Spring Boot backend application for managing recipes and categories.

## Features
- Create, view, and delete categories and recipes
- Filter recipes by category
- DTO pattern to expose only necessary information
- Global exception handling with meaningful messages and status codes

## Technologies
- Java
- Spring Boot
- MySQL
- REST API
- JPA / Hibernate
- DTO Pattern
- SLF4J (logging)


## API Endpoints
- `GET /kategorija` - List all categories
- `POST /kategorija` - Add a new category
- `DELETE /kategorija/{id}` - Delete a category
- `GET /recept` - List all recipes
- `POST /recept` - Add a new recipe
- `DELETE /recept/{id}` - Delete a recipe
