package com.uisrael.edu.ec.sispa.template.session;

import java.util.logging.Logger;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * Created by rmpestano on 28/04/17.
 */
public class AdminServletContextListener implements ServletContextListener {

    private static final Logger log = Logger.getLogger(AdminServletContextListener.class.getName());

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        //only here for backyard compatibility
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}
