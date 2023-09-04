package org.example.mvc;

public interface HandlerMapping {

    Object findHandler(HandlerKey handlerKey); // Controller 뿐만 아니라 Annotation 도 받을수 있게
}
