package ui.controller;

import domain.model.ContactService;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Properties;

@WebServlet("/Controller")
public class Controller extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private ControllerFactory controllerFactory = new ControllerFactory();
    private ContactService service;

    public Controller() {
        super();
    }

    @Override
    public void init() throws ServletException {
        service = new ContactService();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("command");
        if (action == null || action.isEmpty())
            action = "Home";
        RequestHandler handler = controllerFactory.getController(action,service);

        try {
            handler.handleRequest(request, response);

        } catch (NotAuthorizedException e) {
            request.setAttribute("notAuthorized", "You have insufficient rights to have a look at the requested page.");
            controllerFactory.getController("Home",service).handleRequest(request,response);
        }
    }
}

