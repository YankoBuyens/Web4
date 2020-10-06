package ui.controller;

import domain.model.ContactService;
import domain.model.Person;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public abstract class RequestHandler {
    ContactService service;

    public ContactService getService() {
        return service;
    }
    public void setService(ContactService service){
        this.service = service;
    }
    public abstract void handleRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
}