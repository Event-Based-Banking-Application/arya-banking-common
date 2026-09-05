# Arya Banking Common

Multi-module shared library for the Arya Banking microservices ecosystem.

## Modules

| Module | Artifact | Description |
|---|---|---|
| **core** | `org.arya.banking:core` | Domain models, exceptions, DTOs, constants, metadata annotations, utilities |
| **mongo** | `org.arya.banking:mongo` | MongoDB configuration (auditing, converters, transactions) |
| **kafka** | `org.arya.banking:kafka` | Kafka producers, consumers, Avro IDL schemas, topic constants |
| **feign** | `org.arya.banking:feign` | Feign client configuration and error decoding |
| **oauth2** | `org.arya.banking:oauth2` | OAuth2 client credentials configuration |

## Quick Start

Add the BOM import and the modules you need:

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
    <dependency>
        <groupId>org.arya.banking</groupId>
        <artifactId>kafka</artifactId>
    </dependency>
</dependencies>
```

## Build

```sh
mvn clean install          # build all 5 modules
mvn clean deploy -s settings.xml  # publish to GitHub Packages
```

## Package Structure

| Module | Base Package |
|---|---|
| core | `org.arya.banking.common.core.*` |
| mongo | `org.arya.banking.common.mongo.*` |
| kafka | `org.arya.banking.common.kafka.*` |
| feign | `org.arya.banking.common.feign.*` |
| oauth2 | `org.arya.banking.common.oauth2.*` |

Avro-generated classes: `org.arya.banking.common.avro`

## Links

- [Documentation](https://event-based-banking-application.github.io/arya-banking/docs/common/)
- [GitHub Packages](https://github.com/Event-Based-Banking-Application/arya-banking-common/packages)
- [BOM Repository](https://github.com/Event-Based-Banking-Application/arya-banking-bom)
- [Metadata Loader](https://github.com/Event-Based-Banking-Application/arya-banking-common-metadata-loader)

## Maintainers

- [Karthik Kulkarni](https://github.com/karthikkulkarni)
