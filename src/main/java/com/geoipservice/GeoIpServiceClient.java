package com.geoipservice;

import com.product.client.ProductInterface;
import com.utils.JaxWsHandlerResolver;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import java.net.URL;

/**
 * @author Denys Ovcharuk (DOV) / WorldTicket A/S
 * @since 2017-09-01
 */
public class GeoIpServiceClient {


    public GeoIPServiceSoap client;

    public GeoIpServiceClient() {
        try {
            URL url = new URL("http://www.webservicex.net/geoipservice.asmx?wsdl");
            QName qName = new QName("http://www.webservicex.net/","GeoIPService");
            Service service = Service.create(url,qName);

            service.setHandlerResolver(new JaxWsHandlerResolver());

            client = service.getPort(GeoIPServiceSoap.class);

        } catch (Exception e){
            e.printStackTrace();
        }
    }


}
