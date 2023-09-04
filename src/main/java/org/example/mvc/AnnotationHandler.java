package org.example.mvc;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class AnnotationHandler {
    private final Method targetMethod;
    private final Class<?> clazz;

    public AnnotationHandler(Class<?> clazz, Method method) {
        this.clazz = clazz;
        this.targetMethod = method;
    }

    public String handle(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Constructor<?> declaredConstructor = clazz.getDeclaredConstructor();
        Object instance = declaredConstructor.newInstance();

        return (String) targetMethod.invoke(instance, request, response);
    }
}
