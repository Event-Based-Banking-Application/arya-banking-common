# Arya Banking Common

[![SonarCloud](https://sonarcloud.io/api/project_badges/measure?project=Event-Based-Banking-Application_arya-banking-common&metric=alert_status)](https://sonarcloud.io/dashboard?id=Event-Based-Banking-Application_arya-banking-common)
[![Maven Package](https://img.shields.io/github/v/tag/Event-Based-Banking-Application/arya-banking-common?label=package&color=blue&logo=apache-maven)](https://github.com/Event-Based-Banking-Application/arya-banking-common/packages)

## Overview

**Arya Banking Common** is the foundational shared library for the Arya Banking microservices ecosystem. It provides core domain models, MongoDB integration, Kafka/Avro support, metadata versioning, and utility classes to accelerate the development of event-driven banking applications.

This library is intended to be used as a dependency in other Arya Banking microservices, ensuring consistency and reducing code duplication across the platform.

---

## Features

- **Domain Models:** User, Address, Role, Permission, ContactNumber, SecurityDetails, Audit, and more.
- **MongoDB Integration:** Spring Data MongoDB repositories, auditing, and custom converters for `LocalDateTime`.
- **Kafka & Avro Integration:** Kafka configuration, Avro schema support, and serialization utilities.
- **Metadata Versioning:** Automatic tracking and versioning of model schemas using custom annotations and hash-based detection.
- **Validation:** Jakarta Bean Validation annotations on models for robust data integrity.
- **Extensible:** Easily add new models and metadata with the `@TrackMetadata` annotation.

---

## Project Structure

```
arya-banking-common/
├── src/
│   ├── main/
│   │   ├── avro/                # Avro schemas (e.g., AuditEvent.avsc)
│   │   ├── java/
│   │   │   ├── org/arya/banking/common/
│   │   │   │   ├── config/      # Spring configuration (Mongo, Kafka)
│   │   │   │   ├── constants/   # Kafka constants
│   │   │   │   ├── loader/      # Metadata initialization logic
│   │   │   │   ├── mapper/      # MongoDB converters
│   │   │   │   ├── metadata/    # Table/Column metadata classes & annotations
│   │   │   │   ├── model/       # Domain models
│   │   │   │   ├── repository/  # Spring Data MongoDB repositories
│   │   │   │   └── utils/       # Utility classes
│   │   └── resources/
│   │       └── application.yaml # Spring Boot configuration
│   └── test/
│       └── java/                # Unit and integration tests
├── .github/workflows/           # CI/CD workflows (build, deploy, SonarCloud)
├── docker-compose.yaml          # Local development stack (Kafka, Schema Registry)
├── pom.xml                      # Maven build configuration
├── settings.xml                 # Maven repository credentials (for GitHub Packages)
└── README.md                    # Project documentation
```

---

## Getting Started

### Prerequisites

- Java 17+
- Maven 3.8+
- Docker (for local Kafka/Schema Registry)
- MongoDB instance (local or remote)

### Build & Test

```sh
# Build and run tests
mvn clean verify

# Generate Avro Java classes
mvn generate-sources

# Run metadata loader (updates MongoDB with model metadata)
mvn install -Pmetadata-loader
```

### Local Development

1. **Start Kafka & Schema Registry:**

   ```sh
   docker-compose up -d
   ```

2. **Configure MongoDB:**

   Update `src/main/resources/application.yaml` with your MongoDB URI if needed.

3. **Run the Application:**

   ```sh
   mvn spring-boot:run
   ```

---

## Usage

### As a Dependency

Add this library as a dependency in your microservice's `pom.xml`:

```xml
<dependency>
    <groupId>org.arya.banking</groupId>
    <artifactId>arya-banking-common</artifactId>
    <version>1.1.0</version>
</dependency>
```

### Metadata Versioning

Annotate your domain models with [`@TrackMetadata`](src/main/java/org/arya/banking/common/metadata/annotation/TrackMetadata.java) to enable automatic metadata extraction and versioning.

Example:

```java
@TrackMetadata(name = "User", description = "Stores information about the User")
public class User extends AryaBase { ... }
```

The [`MetadataInitializer`](src/main/java/org/arya/banking/common/loader/MetadataInitializer.java) will scan and persist schema metadata to MongoDB.

---

## Avro Schema Support

Avro schemas are located in [src/main/avro/](src/main/avro/). Java classes are generated automatically during the Maven build.

---

## Kafka Integration

Kafka producer/consumer configuration is provided in [`KafkaConfiguration`](src/main/java/org/arya/banking/common/config/KafkaConfiguration.java). Update `application.yaml` for your Kafka and Schema Registry endpoints.

---

## Contributing

1. Fork the repository
2. Create a feature branch (`git checkout -b feature/my-feature`)
3. Commit your changes
4. Push to your fork and open a Pull Request

---

## License

This project is licensed under the [Apache License 2.0](https://www.apache.org/licenses/LICENSE-2.0).

---

## Maintainers

- [Karthik Kulkarni](https://github.com/karthikkulkarni)

---

## Links

- [Project Repository](https://github.com/Event-Based-Banking-Application/arya-banking-common)
- [SonarCloud Dashboard](https://sonarcloud.io/dashboard?id=Event-Based-Banking-Application_arya-banking-common)
- [GitHub Package (Maven)](https://github.com/Event-Based-Banking-Application/arya-banking-common/packages)