# Movies

This an example Spring app that stores information about actors and movies.

It aims to show the following Spring, Hibernate and Java features:
- Transactions
- Relationships (Eager & Lazy)
- Events (both sync and async)
- Async methods and futures
- Enums
- Deployment
- Docker
- Annotations and interceptors
- CI/CD (Spotless, Sonarqube)
- Test containers (using a @TestConfiguration for integration tests)

## Configuration

This project uses:

- Java 11
- Gradle 6.8
- Spring Boot 2.6.3
- MySQL 5.7

### Database

Connect to MySQL with a user with permissions to create users and dbs

```mysql
create database movies_dev;
create user 'movies'@'%' identified by 'ThePassword';
grant all on movies_dev.* to 'movies'@'%';
```

## Run

The app uses `8081` port from `application.properties`

To run the project from the command line:\
`./gradlew bootRun`

## Tests

To run all project tests:\
`./gradlew test`
