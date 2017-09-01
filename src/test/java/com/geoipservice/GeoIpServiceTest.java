package com.geoipservice;

import org.testng.annotations.Test;
import static org.testng.AssertJUnit.assertEquals;

/**
 * @author Denys Ovcharuk (DOV) / WorldTicket A/S
 * @since 2017-09-01
 */
public class GeoIpServiceTest {

    private GeoIpServiceClient geoIpServiceClient = new GeoIpServiceClient();
    private GeoIPServiceSoap geoIPServiceSoap = geoIpServiceClient.client;

    @Test
    public void getCountryFromIP() {

        GeoIP geoIP = geoIPServiceSoap.getGeoIP("8.8.8.8");
        assertEquals(geoIP.getCountryCode(),"USA");

    }

}
