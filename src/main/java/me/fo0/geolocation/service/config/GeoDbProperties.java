package me.fo0.geolocation.service.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.core.io.Resource;

@ConfigurationProperties(GeoDbProperties.PROPERTY_PREFIX)
@Data
public class GeoDbProperties {

  public static final String PROPERTY_PREFIX = "maxmind.geoip";

  private Boolean enabled = true;
  private Resource database;

}