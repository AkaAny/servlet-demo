package com.example.servletdemo;



import jakarta.servlet.*;

import java.util.Set;

public class ServletInit implements ServletContainerInitializer {
    @Override
    public void onStartup(Set<Class<?>> c, ServletContext ctx) throws ServletException {
        System.out.println("ServletContainerInitializer onStartup");
        //add servlet here
        addServlet(ctx,"/hello",HelloServlet.class);
    }

    private void addServlet(ServletContext context,String path,Class<? extends Servlet> servletClass){
        ServletRegistration.Dynamic dynamic= context.addServlet(servletClass.getName(),servletClass);
        dynamic.addMapping(path);
    }
}
