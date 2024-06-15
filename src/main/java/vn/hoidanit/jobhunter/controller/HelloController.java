package vn.hoidanit.jobhunter.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import vn.hoidanit.jobhunter.service.error.IdlnvalidException;

@RestController
public class HelloController {

    @ExceptionHandler(value = IdlnvalidException.class)
    public ResponseEntity<String> handleIdException(IdlnvalidException idException) {
        return ResponseEntity.badRequest().body(idException.getMessage());
    }

    @GetMapping("/")
    public String getHelloWorld() throws IdlnvalidException {
        if (true)
            throw new IdlnvalidException("123");
        return "Hello World (Hỏi Dân IT & Eric)";
    }
}
