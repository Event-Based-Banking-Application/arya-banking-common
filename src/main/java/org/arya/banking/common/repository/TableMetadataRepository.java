package org.arya.banking.common.repository;

import org.arya.banking.common.metadata.TableMetadata;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TableMetadataRepository extends MongoRepository<TableMetadata, String> {

    Optional<TableMetadata> findByModelName(String tableName);
}
