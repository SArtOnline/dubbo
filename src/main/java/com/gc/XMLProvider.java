package com.gc;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

public class XMLProvider {
    public static void main(String []args) throws IOException {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("META-INF.spring/service.xml");
        context.start();

        System.in.read();
    }
}
