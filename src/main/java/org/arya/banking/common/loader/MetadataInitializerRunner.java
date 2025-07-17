package org.arya.banking.common.loader;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("metadata-loader")
public class MetadataInitializerRunner implements CommandLineRunner {

    private static final Logger log = LoggerFactory.getLogger(MetadataInitializerRunner.class);
    private final MetadataInitializer metadataInitializer;
    private final ConfigurableApplicationContext applicationContext;

    public MetadataInitializerRunner(MetadataInitializer metadataInitializer, ConfigurableApplicationContext applicationContext) {
        this.metadataInitializer = metadataInitializer;
        this.applicationContext = applicationContext;
    }

    @Override
    public void run(String... args) throws Exception {
        metadataInitializer.initializeMetadata();
        log.info("Metadata initialization completed.");
        applicationContext.close();
    }
}
