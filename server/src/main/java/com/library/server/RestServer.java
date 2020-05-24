/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.library.server;

import org.apache.cxf.jaxrs.JAXRSServerFactoryBean;
import org.apache.cxf.endpoint.Server;
import org.apache.cxf.interceptor.LoggingInInterceptor;
import org.apache.cxf.interceptor.LoggingOutInterceptor;
import org.apache.cxf.jaxrs.lifecycle.SingletonResourceProvider;
import org.apache.cxf.jaxrs.utils.ResourceUtils;

/**
 *
 * @author gdimitrova
 */
class RestServer {

    private RestApplication application;

    public Server server;

    private JAXRSServerFactoryBean sf;

    public RestServer() {
        application = new RestApplication();
    }

    public void setResourceClass(Class Resourse) {
        sf.setResourceClasses(Resourse);
    }

    public void setResourceProvider(Class Resourse) {
        sf.setResourceProvider(Resourse, new SingletonResourceProvider(Resourse));
    }

    public void setAddress(int num) {
        sf.setAddress("http://localhost:" + num + "/");
    }

    public void setDefaultAddress() {
        setAddress(8000);
    }

    public void start() {

        sf = ResourceUtils.createApplication(application, false, false, true, null);
//        application.getClasses().forEach(clazz -> {
//            this.setResourceClass(clazz);
//            this.setResourceProvider(clazz);
//        });

        setDefaultAddress();

        this.stop();

        server = sf.create();
        server.start();
    }

    public void stop() {
        if (server != null) {
            server.stop();
            server.destroy();
        }
    }
}
