package com.example.clinisched.exception;

public class NotFoundException extends RuntimeException {
    public NotFoundException(Long id){
        super(id + " not found.");
    }
}
