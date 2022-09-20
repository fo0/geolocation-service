package me.fo0.geolocation.service;

import static org.apache.commons.lang3.StringUtils.defaultString;

import com.maxmind.geoip2.DatabaseReader;
import com.maxmind.geoip2.model.CountryResponse;
import java.net.InetAddress;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Log4j2
public class GeoLocationService {

  public static final String EMPTY = "N/A";
  @Autowired
  private DatabaseReader reader;

  public CountryResponse countryResponse(InetAddress inetAddress) {
    log.trace("resolving ip: {}", inetAddress);
    if (inetAddress == null) {
      return null;
    }

    try {
      final CountryResponse response = reader.country(inetAddress);
      log.debug("ip resolved {} -> {}", inetAddress, extractCountryCode(response));
      return response;
    } catch (Exception ignored) {
      log.error("error resolving ip: {}", inetAddress);
    }

    return null;
  }

  public CountryResponse countryResponse(String ipAddress) {
    try {
      InetAddress inetAddress = InetAddress.getByName(ipAddress);
      return countryResponse(inetAddress);
    } catch (Exception ignored) {
    }
    return null;
  }

  public String countryIsoCode(String ipAddress) {
    return extractCountryCode(countryResponse(ipAddress));
  }

  public String countryIsoCode(InetAddress inetAddress) {
    return extractCountryCode(countryResponse(inetAddress));
  }


  private static String extractCountryCode(CountryResponse countryResponse) {
    return (countryResponse != null && countryResponse.getCountry() != null) ?
        //
        defaultString(countryResponse.getCountry()
                                     .getIsoCode(), EMPTY) : EMPTY;
  }
}