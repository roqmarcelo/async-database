package io.github.roquesantosdev.asyncdatabase;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;

import java.lang.reflect.Method;

public class ApplicationLogAsyncUncaughtExceptionHandler implements AsyncUncaughtExceptionHandler {

    private static final Logger LOGGER = LoggerFactory.getLogger(ApplicationLogAsyncUncaughtExceptionHandler.class);

    @Override
    public void handleUncaughtException(Throwable throwable, Method method, Object... objects) {
        LOGGER.error("Unexpected asynchronous exception at : {}.{}", method.getDeclaringClass().getName(), method.getName());
    }
}