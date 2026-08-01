package org.arya.banking.common.model;

public enum OutboxStatus {
    PENDING, COMPLETED, FAILED, RETRY_PENDING
}