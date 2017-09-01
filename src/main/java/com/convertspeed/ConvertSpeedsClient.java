package com.convertspeed;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import java.net.URL;
import com.utils.*;

/**
 * @author Denys Ovcharuk (DOV) / WorldTicket A/S
 * @since 2017-09-01
 */
public class ConvertSpeedsClient {

    public ConvertSpeedsSoap client;

    public ConvertSpeedsClient() {
        try {
            URL url = new URL("http://www.webservicex.net/ConvertSpeed.asmx?WSDL");
            QName qName = new QName("http://www.webserviceX.NET/","ConvertSpeeds");
            Service service = Service.create(url,qName);

            service.setHandlerResolver(new JaxWsHandlerResolver());

            client = service.getPort(ConvertSpeedsSoap.class);

        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
