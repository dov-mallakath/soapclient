package com.product.client;

import org.testng.annotations.Test;
import static org.testng.AssertJUnit.assertEquals;

/**
 * @author Denys Ovcharuk (DOV) / WorldTicket A/S
 * @since 2017-09-01
 */
public class ProductClientTest {

    private JAXBClient jaxbClient = new JAXBClient();
    private ProductInterface productClient = jaxbClient.client;

    @Test
    public void productTest(){
        Product product = productClient.getProduct();
        assertEquals(product.getProductName(),"Sony");
    }

    @Test
    public void productValidationTest() {
        Product product = productClient.getProduct("Xperia");
        assertEquals(product.getProductName(), "Sony");
    }

}
