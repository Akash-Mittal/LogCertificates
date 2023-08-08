package com.am.bp.innovations;

import static org.testng.Assert.assertEquals;

import java.io.File;

import org.cryptacular.bean.KeyStoreFactoryBean;
import org.cryptacular.io.FileResource;
import org.cryptacular.io.Resource;
import org.junit.gen5.api.Test;
import org.testng.annotations.DataProvider;

public class AppTest {

    private static final String KS_PATH = "src/test/resources/keystores/";

    @DataProvider(name = "keystore-data")
    public Object[][] getKeyStoreData() {
        return new Object[][] { new Object[] { "JCEKS", new FileResource(new File(KS_PATH + "keystore.jceks")), 1, },
                new Object[] { "JKS", new FileResource(new File(KS_PATH + "keystore.jks")), 1, },
                new Object[] { "PKCS12", new FileResource(new File(KS_PATH + "keystore.p12")), 1, }, };
    }

    @Test
    public void testNewInstance(final String type, final Resource resource, final int expectedSize) throws Exception {
        final KeyStoreFactoryBean factory = new KeyStoreFactoryBean();
        factory.setType("PKCS12");
        factory.setResource(new FileResource(new File(KS_PATH + "keystore.jks")));
        factory.setPassword("vtcrypt");
        assertEquals(factory.newInstance().size(), expectedSize);
    }

}
