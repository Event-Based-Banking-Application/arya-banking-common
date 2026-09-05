# Arya Banking Common

Multi-module shared library for the Arya Banking microservices platform.

## Modules

| Module | Artifact | Description |
|---|---|---|
| **core** | `core` | Domain models, exceptions, DTOs, utilities |
| **mongo** | `mongo` | MongoDB configuration |
| **kafka** | `kafka` | Kafka/Avro support |
| **feign** | `feign` | Feign client config |
| **oauth2** | `oauth2` | OAuth2 client credentials |

## Usage

```xml
<dependencyManagement>
    <dependencies>
        <dependency>
            <groupId>org.arya.banking</groupId>
            <artifactId>arya-banking-bom</artifactId>
            <version>2.0.0</version>
            <type>pom</type>
            <scope>import</scope>
        </dependency>
    </dependencies>
</dependencyManagement>

<dependencies>
    <dependency>
        <groupId>org.arya.banking</groupId>
        <artifactId>core</artifactId>
    </dependency>
</dependencies>
```

## Build

```sh
mvn clean install
```

## Links

- [Docs](https://event-based-banking-application.github.io/arya-banking/docs/common/)
- [BOM](https://github.com/Event-Based-Banking-Application/arya-banking-bom)
- [Metadata Loader](https://github.com/Event-Based-Banking-Application/arya-banking-common-metadata-loader)
