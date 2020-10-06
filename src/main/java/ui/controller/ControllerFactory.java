package ui.controller;

import domain.model.ContactService;


public class ControllerFactory{
    public RequestHandler getController(String key, ContactService service) {
        return createHandler(key,service);
    }

    private RequestHandler createHandler(String handlerName,ContactService service) {
        RequestHandler handler = null;
        try {
            Class<?> handlerClass = Class.forName("ui.controller." + handlerName + "Handler");
            Object handlerObject = handlerClass.getConstructor().newInstance();
            handler = (RequestHandler) handlerObject;
            handler.setService(service);
        } catch (Exception e) {
            throw new RuntimeException("The requested page doesn’t exist");
        }
        return handler;
    }
}
