package org.arya.banking.common.exception;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import feign.Response;
import feign.codec.ErrorDecoder;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.util.Objects;

@Slf4j
public class FeignClientErrorDecoder implements ErrorDecoder {


    @Override
    public Exception decode(String s, Response response) {

        log.info("response status: {}", response.status());
        GlobalException globalException = extractGlobalException(response);
        log.error("Error in request went through feign client: {}", globalException.getErrorCode() + " - " + globalException.getErrorMessage());
        return globalException;
    }

    private GlobalException extractGlobalException(Response response) {

        GlobalException globalException = null;
        Reader reader = null;

        try {
            reader = response.body().asReader(StandardCharsets.UTF_8);
            String result = IOUtils.toString(reader);
            ObjectMapper mapper = new ObjectMapper();
            mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
            log.error("Exception from reader: {}", result);
            globalException = mapper.readValue(result, GlobalException.class);
            globalException.setHttpErrorCode(response.status());
        } catch (IOException e) {
            log.error("IO Exception while reading exception message", e);
        } finally {
            if (!Objects.isNull(reader)){
                try {
                    reader.close();
                } catch (IOException e) {
                    log.error("IO Exception while reading exception message", e);
                }
            }
        }
        return globalException;
    }

    private InternalServerExceptionHandler extractInternalServerException(Response response) {

        InternalServerExceptionHandler internalServerExceptionHandler = null;
        Reader reader = null;

        try {
            reader = response.body().asReader(StandardCharsets.UTF_8);
            String result = IOUtils.toString(reader);
            ObjectMapper mapper = new ObjectMapper();
            mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
            log.error("Internal service Exception from reader: {}", result);
            internalServerExceptionHandler = mapper.readValue(result, InternalServerExceptionHandler.class);
        } catch (IOException e) {
            log.error("IO Exception while reading exception message", e);
        } finally {
            if (!Objects.isNull(reader)){
                try {
                    reader.close();
                } catch (IOException e) {
                    log.error("IO Exception while reading exception message", e);
                }
            }
        }
        return internalServerExceptionHandler;
    }
}
