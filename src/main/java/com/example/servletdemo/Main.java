package com.example.servletdemo;

import jakarta.servlet.Servlet;
import jdk.internal.loader.Resource;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.WebResourceRoot;
import org.apache.catalina.connector.Connector;
import org.apache.catalina.core.StandardContext;
import org.apache.catalina.startup.Tomcat;
import org.apache.catalina.webresources.DirResourceSet;
import org.apache.catalina.webresources.StandardRoot;

import java.io.File;
import java.net.URL;
import java.util.Objects;

public class Main {
    public static void main(String[] args) throws Exception {
        ClassLoader contextClassLoader=Thread.currentThread().getContextClassLoader();
        String baseDir= Objects.requireNonNull(contextClassLoader.getResource("")).getPath();

        Tomcat tomcat = new Tomcat();
        //tomcat.setBaseDir(baseDir);
        tomcat.setPort(9999);

        Connector connector = new Connector();
        connector.setPort(9999); // 端口号
        connector.setURIEncoding("UTF-8");
        tomcat.getService().addConnector(connector);

        tomcat.addWebapp("/example", baseDir);
        tomcat.enableNaming();

        tomcat.start();
        tomcat.getServer().await();
    }
}
