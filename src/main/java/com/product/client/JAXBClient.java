package com.product.client;


import com.utils.JaxWsHandlerResolver;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import java.net.URL;

/**
 * @author Denys Ovcharuk (DOV) / WorldTicket A/S
 * @since 2017-09-01
 */
public class JAXBClient {

    public ProductInterface client;

    public JAXBClient() {
        try {
            URL url = new URL("http://localhost:9999/ws/product?WSDL");
            QName qName = new QName("http://jaxb.soap.com/","ProductService");
            Service service = Service.create(url,qName);

            service.setHandlerResolver(new JaxWsHandlerResolver());

            client = service.getPort(ProductInterface.class);

        } catch (Exception e){
            e.printStackTrace();
        }
    }

}
