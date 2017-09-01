package com.utils;

import com.product.client.ProductInterface;

import javax.xml.ws.WebServiceRef;

public class JAXBAnnotClient {

    @WebServiceRef(wsdlLocation =
            "http://localhost:9999/ws/product?wsdl")
   private static ProductInterface productInterface;

  public static void main(String[] args) {
       System.out.println(productInterface.getProduct());
    }
}
