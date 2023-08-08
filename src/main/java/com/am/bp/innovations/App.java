package com.am.bp.innovations;

import java.io.File;
import java.util.Enumeration;

import org.cryptacular.bean.KeyStoreFactoryBean;
import org.cryptacular.io.FileResource;

public class App {

    private static final String KS_PATH = "src/test/resources/keystores/";

    public static void main(String[] args) throws Exception {
        final KeyStoreFactoryBean factory = new KeyStoreFactoryBean();
        factory.setType("PKCS12");
        factory.setResource(new FileResource(new File(KS_PATH + "keystore.p12")));
        factory.setPassword("vtcrypt");
        Enumeration<String> alises = factory.newInstance().aliases();
        while (alises.hasMoreElements()) {
            String element = alises.nextElement();
            System.out.println(element);
        }
    }

}
