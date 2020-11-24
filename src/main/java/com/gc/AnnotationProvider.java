package com.gc;

import com.gc.config.DubboApplicationConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.IOException;

public class AnnotationProvider {

    public static void main(String[] args) throws IOException {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DubboApplicationConfig.class);
        context.start();

        System.in.read();
    }
}
