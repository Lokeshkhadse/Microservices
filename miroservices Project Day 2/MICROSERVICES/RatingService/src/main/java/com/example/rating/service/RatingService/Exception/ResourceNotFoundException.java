package com.example.rating.service.RatingService.Exception;

public class ResourceNotFoundException  extends  RuntimeException{

    public ResourceNotFoundException(){
        super("resource not found on server!!!!!!");
    }

    public ResourceNotFoundException(String message){
        super(message);
    }
}

