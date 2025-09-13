package org.arya.banking.common.exception;

public interface ExceptionCode {

    String KEYCLOAK_INTERNAL_SERVER_CODE = "AUTH_KCISEERR_500";
    String KEYCLOAK_USER_CREATION_CODE = "AUTH_KCUCERR_400";

    String USER_EXISTS_CODE = "USER_USREXTERR_409";

    String INVALID_OAUTH_CODE = "AUTH_INVLDOA_400";
}
