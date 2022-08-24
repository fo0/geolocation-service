package me.fo0.geolocation.service.config;

import static me.fo0.geolocation.service.config.MaxmindGeoIPProperties.PROPERTY_PREFIX;

import com.maxmind.geoip2.DatabaseReader;
import me.fo0.geolocation.service.GeoLocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConditionalOnProperty(prefix = PROPERTY_PREFIX, value = {"enabled"}, matchIfMissing = true)
@EnableConfigurationProperties(MaxmindGeoIPProperties.class)
public class MaxmindGeoIPAutoconfiguration {

  @Autowired
  private MaxmindGeoIPProperties properties;

  @Bean
  public DatabaseReader geoIpDatabaseReader() throws Exception {
    return new DatabaseReader.Builder(properties.getGeolite2CountryMmdb()
                                                .getInputStream()).build();
  }

  @Bean
  public GeoLocationService geoIpService() throws Exception {
    return new GeoLocationService(geoIpDatabaseReader());
  }

}