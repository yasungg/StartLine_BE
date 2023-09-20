package startline.server.controller;

import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.MalformedJwtException;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class ExceptionController {
    @ExceptionHandler(BadCredentialsException.class)
    public ResponseEntity<Map<String, String>> badCredentialExceptionHandler(BadCredentialsException bad) {
        Map<String, String> err = new HashMap<>();
        err.put("message", bad.getMessage());
        return ResponseEntity.badRequest().body(err);
    }
    @ExceptionHandler(JwtException.class)
    public ResponseEntity<Map<String, String>> JwtExceptionHandler(JwtException jwt) {
        Map<String, String> err = new HashMap<>();
        err.put("message", jwt.getMessage());
        return ResponseEntity.badRequest().body(err);
    }

}