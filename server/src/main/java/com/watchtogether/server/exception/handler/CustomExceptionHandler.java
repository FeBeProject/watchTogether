package com.watchtogether.server.exception.handler;

import com.watchtogether.server.exception.PartyException;
import com.watchtogether.server.exception.TokenException;
import com.watchtogether.server.exception.UserException;
import com.watchtogether.server.exception.response.PartyExceptionResponse;
import com.watchtogether.server.exception.response.TokenExceptionResponse;
import com.watchtogether.server.exception.response.UserExceptionResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Slf4j
@ControllerAdvice
public class CustomExceptionHandler {

    @ExceptionHandler({UserException.class})
    public ResponseEntity<UserExceptionResponse> UserException(final UserException e) {
        log.error("UserException is occurred. ", e);

        return ResponseEntity.badRequest()
            .body(new UserExceptionResponse(e.getErrorStatus(), e.getUserErrorCode(),
                e.getMessage()));
    }

    // todo 파티 관련 에러 출력하게 끔 코드 수정
    @ExceptionHandler({PartyException.class})
    public ResponseEntity<PartyExceptionResponse> PartyException(final PartyException e) {
        log.error("PartyException is occurred. ", e);

        return ResponseEntity.badRequest()
            .body(new PartyExceptionResponse(e.getErrorStatus(), e.getPartyErrorCode(),
                e.getMessage()));
    }

    @ExceptionHandler({TokenException.class})
    public ResponseEntity<TokenExceptionResponse> RefreshTokenException(final TokenException e) {
        log.error("UserException is occurred. ", e);

        return ResponseEntity.badRequest()
            .body(new TokenExceptionResponse(e.getErrorStatus(), e.getRefreshTokenErrorCode(),
                e.getMessage()));
    }

}
