package org.arya.banking.common.core.model;

public enum OutboxStatus {
    PENDING, COMPLETED, FAILED, RETRY_PENDING
}